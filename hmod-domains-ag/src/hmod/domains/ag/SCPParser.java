/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmod.domains.ag;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alejandro Catalan I.
 */
public class SCPParser {
    private boolean [][] coveringMatrix;
    private int[] costVector;
    private int m;
    private int n;
    
    public void parseStream(String re) throws FileNotFoundException, IOException 
    {
        BufferedReader br = new BufferedReader(new FileReader(re));
        String[] dimensions = ProcessLine(br.readLine()); 
        m = Integer.parseInt(dimensions[0]);
        n = Integer.parseInt(dimensions[1]);
        
        coveringMatrix = new boolean[m][n];
        
        int i = 0;
        costVector = new int[n];
        while(i<costVector.length)
        {
            String[] costsLine;
            costsLine = ProcessLine(br.readLine());

            for (int j = 0; j < costsLine.length; j++)
                costVector[i++] = Integer.parseInt(costsLine[j]);
        }

        for (i = 0; i < m; i++)
        {
            String line = br.readLine();
            int setsThatCover = Integer.parseInt(ProcessLine(line)[0]);

            int[] coverSetIndexes = new int[setsThatCover];

            int k=0;

            while (k < setsThatCover)
            {
                String[] covsLine = ProcessLine(br.readLine());

                for (int j = 0; j < covsLine.length; j++)
                    coverSetIndexes[k++] =Integer.parseInt(covsLine[j]);
            }
            
            for (int r = 0; r < coverSetIndexes.length; r++)
                coveringMatrix[i][coverSetIndexes[r] -1] = true;
        }
    }
    
    private String[] ProcessLine(String orig)
    {
        if(orig==null)
            return (new String[]{""});
        return (orig.trim()).split(" ");
    }
    
    public boolean checkColumnCover()
    {
        return coveringMatrix[m][n];
    }
    
    public int [] getCostVector()
    {
        return costVector;
    }
    
    public boolean [][] getCoveringMatrix()
    {
        return coveringMatrix;
    }
    
    public int getM()
    {
        return m;
    }
    
    public int getN()
    {
        return n;
    }
}
