/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmod.domains.ts;
import hmod.core.Condition;
import hmod.loader.graph.ArgumentList;

/**
 *
 * @author Alejandro
 */
public class TabuSearchOperatorFactory {
    private static TabuSearchOperatorFactory instance;
    
    public static TabuSearchOperatorFactory getInstance() {
        if(instance == null)
            instance = new TabuSearchOperatorFactory();
        
        return instance;
    }
    
    public Condition checkSolutionIsComplete(ArgumentList args)
    {
        TSPHandler solutionHandler = args.next(TSPHandler.class);
        
        return () -> {
            return solutionHandler.isFinishied(); 
        };
    }
}
