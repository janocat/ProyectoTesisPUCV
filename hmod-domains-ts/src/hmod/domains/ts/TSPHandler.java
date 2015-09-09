/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmod.domains.ts;
import hmod.core.DataHandler;

/**
 *
 * @author Alejandro
 */
public interface TSPHandler extends DataHandler{
    boolean isFinishied ();
    // Búsqueda_Tabú_Principal
    void readSolutionInitial ();
    // Búsqueda_Tabú_Básico
    void searchTabuBasic ();
    void neighborMovementGE ();
    // Intensificación
    void concentrationConstructionSet ();
    void localSearchGE ();
    void localSearchOR ();
    void neighborMovementOR ();
    void localSearchCS ();
    // Diversificación
    void intensification ();    
}
