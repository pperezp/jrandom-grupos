/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.jrandom.modelo.listModel;

import cl.jrandom.modelo.Grupo;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author pperezp
 */
public class LMGrupo implements ListModel{
    private final List<Grupo> grupos;

    public LMGrupo(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    @Override
    public int getSize() {
        return grupos.size();
    }

    @Override
    public Object getElementAt(int indice) {
        return grupos.get(indice);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
