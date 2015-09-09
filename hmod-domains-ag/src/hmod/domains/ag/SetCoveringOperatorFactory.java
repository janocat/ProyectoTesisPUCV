/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmod.domains.ag;

import hmod.core.Condition;
import hmod.core.Operator;
import hmod.loader.graph.ArgumentList;
/**
 *
 * @author Alejandro Catalan I.
 */
public class SetCoveringOperatorFactory {
    private static SetCoveringOperatorFactory instance;
    
    private static boolean [][] m_coveringMatrix;
    private static int[] m_costVector;
    
    public static SetCoveringOperatorFactory getInstance() {
        if(instance == null)
            instance = new SetCoveringOperatorFactory();
        
        return instance;
    }
    
    public Condition checkSolutionIsComplete(ArgumentList args)
    {
        SCPHandler solutionHandler = args.next(SCPHandler.class);

        return () -> {
            return solutionHandler.isComplete(); 
        };
    }
    
    public Operator checkCovering(ArgumentList args)
    {
        SCPHandler solutionHandler = args.next(SCPHandler.class);
        
        return () -> {
            solutionHandler.itemCoveringUniverse();
        };
    }
    
    public Operator printSolutionFinish (ArgumentList args)
    {
        SCPHandler solutionBuildHandler = args.next(SCPHandler.class);
        
        return () -> {
            solutionBuildHandler.printSolutionCovering();
        };
    }
}