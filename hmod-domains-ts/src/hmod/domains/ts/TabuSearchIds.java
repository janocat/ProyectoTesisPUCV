/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmod.domains.ts;
import flexbuilders.graph.GraphFactory;
import flexbuilders.graph.NodeId;
import hmod.core.Step;

/**
 *
 * @author Alejandro
 */
public class TabuSearchIds {
    public static final NodeId<TSPHandler> SOLUTION_DATA = GraphFactory.nodeId(
        "TabuSearchIds.SOLUTION_DATA"
    );
    
    public static final NodeId<Step> ITERATION_START = GraphFactory.nodeId(
        "TabuSearchIds.ITERATION_START"
    );
    
    public static final NodeId<Step> CALL_BASIC_TABU = GraphFactory.nodeId(
        "TabuSearchIds.CALL_BASIC_TABU"
    );
    
    public static final NodeId<Step> CALL_INTENSIFICATION = GraphFactory.nodeId(
        "TabuSearchIds.CALL_INTENSIFICATION"
    );
    
    public static final NodeId<Step> CALL_DIVERSIFICATION = GraphFactory.nodeId(
        "TabuSearchIds.CALL_DIVERSIFICATION"
    );
        
    public static final NodeId<Step> FINISH_TABU_SEARCH = GraphFactory.nodeId(
        "TabuSearchIds.FINISH_TABU_SEARCH"
    );
}
