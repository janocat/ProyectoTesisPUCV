/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmod.domains.ag;

import static flexbuilders.basic.BasicBuilders.builderFor;
import flexbuilders.core.NestedBuilder;
import flexbuilders.graph.BuilderGraph;
import hmod.core.Step;
import hmod.loader.graph.AlgorithmBuilders;
import static hmod.loader.graph.AlgorithmBuilders.NOT;

/**
 *
 * @author Alejandro Catalan I.
 */

public class SCPSolutionLoader {
    public static NestedBuilder<Step> load(BuilderGraph graph)
    {
        SetCoveringOperatorFactory scOps = SetCoveringOperatorFactory.getInstance();
        
        NestedBuilder <SCPHandler> setCovering = builderFor(new DefaultSCPHandler ());
        
        return AlgorithmBuilders.
                algorithmBlock().
                    While(NOT(scOps::checkSolutionIsComplete, setCovering)). 
                        run(scOps::checkCovering, setCovering).
                    end().
                    run(scOps::printSolutionFinish, setCovering);
    }
}