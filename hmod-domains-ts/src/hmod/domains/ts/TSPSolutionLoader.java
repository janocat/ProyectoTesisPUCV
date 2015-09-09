/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmod.domains.ts;
import flexbuilders.core.NestedBuilder;
import flexbuilders.graph.BuilderGraph;
import hmod.core.Step;
import hmod.loader.graph.AlgorithmBuilders;
/**
 *
 * @author Alejandro
 */
public class TSPSolutionLoader {
    public static NestedBuilder<Step> load(BuilderGraph graph)
    {
        TabuSearchOperatorFactory tsOps = TabuSearchOperatorFactory.getInstance();
        NestedBuilder solutionData = graph.node(TabuSearchIds.SOLUTION_DATA);
        
        return  AlgorithmBuilders.
                    algorithmBlock().
                        While(tsOps::checkSolutionIsComplete, solutionData).
                            call(graph.node(TabuSearchIds.ITERATION_START)).
                            call(graph.node(TabuSearchIds.CALL_BASIC_TABU)).
                            call(graph.node(TabuSearchIds.CALL_INTENSIFICATION)).
                            call(graph.node(TabuSearchIds.CALL_DIVERSIFICATION)).
                            call(graph.node(TabuSearchIds.FINISH_TABU_SEARCH)); 
    }
}
