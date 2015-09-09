/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmod.domains.ag;

import flexbuilders.graph.ExtensibleGraph;
import static flexbuilders.graph.GraphFactory.graph;
import hmod.core.Algorithm;

/**
 *
 * @author Alejandro Catalan I.
 */
public class SingleGraphTest {
     public static void main (String [ ] args) 
     {
         ExtensibleGraph graph = graph();
         graph.setValue(SetCoveringIds.SETCOVERING_ID, SCPSolutionLoader.load(graph));
         Algorithm.create(graph.node(SetCoveringIds.SETCOVERING_ID).build()).start();
     }
}
