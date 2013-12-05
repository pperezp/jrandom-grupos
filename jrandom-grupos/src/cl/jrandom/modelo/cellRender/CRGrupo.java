/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.jrandom.modelo.cellRender;

import cl.jrandom.modelo.Grupo;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author pperezp
 */
public class CRGrupo extends JLabel implements ListCellRenderer{
    private final int CANTIDAD_ICONOS_USER = 11;
    @Override
    public Component getListCellRendererComponent(JList lista, Object valor, int indice, boolean isSelected, boolean cellHasFocus) {
        Grupo grupo = (Grupo) valor;
        
        this.setOpaque(true);
        this.setText(grupo.toString());
        
        indice = grupo.getNumero();
        
        while(indice > CANTIDAD_ICONOS_USER){
            indice = indice - CANTIDAD_ICONOS_USER;
        }
        
        this.setIcon(new ImageIcon(getClass().getResource("/cl/jrandom/recursos/imagenes/usuarios/user"+indice+".png")));
        
        if(isSelected){
//            this.setForeground(Color.white);
            this.setBackground(new Color(160, 247, 166));
        }else{
            this.setForeground(Color.black);
            this.setBackground(Color.white);
        }
        
        
        return this;
    }
    
}
