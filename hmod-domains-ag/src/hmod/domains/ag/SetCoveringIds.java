/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmod.domains.ag;

import flexbuilders.graph.GraphFactory;
import flexbuilders.graph.NodeId;
import hmod.core.Step;

/**
 *
 * @author Alejandro Catalan I.
 */
public class SetCoveringIds {
    SetCoveringOperatorFactory scOps = SetCoveringOperatorFactory.getInstance();
    
    public static final NodeId<Step> SETCOVERING_ID = GraphFactory.nodeId(
        "SetCoveringIds.SETCOVERING_ID"
    );
}