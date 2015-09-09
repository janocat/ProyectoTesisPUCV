/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmod.domains.ag;

import hmod.core.DataHandler;

/**
 *
 * @author Alejandro Catalan I.
 */
public interface SCPHandler extends DataHandler{
    boolean isComplete();
    void itemCoveringUniverse();
    void printSolutionCovering();
}
