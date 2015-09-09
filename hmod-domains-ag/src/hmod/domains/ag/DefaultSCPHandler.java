/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmod.domains.ag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Alejandro Catalan I.
 */
public class DefaultSCPHandler implements SCPHandler{

    private boolean [][] coveringMatrix;
    private int[] costVector;
    private int m;
    private int n;
    private ArrayList <Integer> solutionList;
    private ArrayList <Integer> solutionListCost;
    private HashSet <Integer> hashset;
    private int cantMax;
    private int indMax;
    
    public  DefaultSCPHandler()
    {
        try
        {
            SCPParser scparser = new SCPParser();
            scparser.parseStream("scp41.txt");
            
            coveringMatrix = scparser.getCoveringMatrix();
            costVector = scparser.getCostVector();
            m = scparser.getM();
            n = scparser.getN();
            cantMax=0;
            indMax=0;
            hashset = new HashSet<>();
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
        solutionList = new ArrayList<> ();
    }
    
    public boolean isComplete() {
        if (solutionList.size()>0){
            for(int a: solutionList){
                for(int i=0; i< m; i++){
                    if (coveringMatrix[i][a]==true){
                        if(!hashset.contains(i)){
                            hashset.add(i);
                        }
                    }
                }
            }
            
            if(m == hashset.size()){
                return true;
            }
        }
        return false;
    }
    
    public void itemCoveringUniverse() {
        for(int i=0; i<n; i++){
            if(!solutionList.contains(i)){
                HashSet <Integer> hashset_2 = new HashSet<>();
                for(int j=0; j< m; j++){
                    if (coveringMatrix[j][i]==true){
                        hashset_2.add(j);
                    }
                }
                if (hashset_2.size()>cantMax){
                    cantMax=hashset_2.size();
                    indMax=i;
                }
            }
        }
        
        if (!solutionList.contains(indMax)) {
            solutionList.add(indMax);
            cantMax = 0;
            indMax = 0;
        }
    }
    
    public void printSolutionCovering(){
        System.out.println("printSolutionCovering().Start()");
        System.out.println("m: " +m+" n: " +n);
        System.out.println("coveringMatrix.length: " +coveringMatrix.length+" coveringMatrix[0].length: " +coveringMatrix[0].length);
        System.out.println("costVector.length: " + costVector.length);
        int sumCost = 0;
        if(m == hashset.size()){
            Iterator<Integer> Iterator = solutionList.iterator();
            while(Iterator.hasNext()){
                Integer elemento = Iterator.next();
                int cont=0;
                for (int i=0; i<m; i++)
                    if (coveringMatrix[i][elemento])
                        cont++;
                System.out.print("["+elemento+"|"+costVector[elemento]+"|"+cont+"]");
                sumCost += costVector[elemento];
            }
        }
        System.out.println("\nsolutionList.size(): "+solutionList.size());
        System.out.println("hashset.size(): "+hashset.size());
        System.out.println("sumCost: "+sumCost);
    }
}