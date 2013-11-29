/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JRandom.java
 *
 * Created on 29-nov-2013, 14:17:38
 */

package cl.jrandom.principal;

import cl.jrandom.modelo.Grupo;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author profesor
 */
public class JRandom extends javax.swing.JFrame {
    private List<Grupo> grupos;
    private List<Grupo> gruposAleatorio;
    private boolean estado;

    /*Contador utilizado para generar los numeros de los grupos*/
    private int contador;

    /** Creates new form JRandom */
    public JRandom() {
        initComponents();
        grupos = new ArrayList<Grupo>();
        contador = 1;
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreGrupo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaGrafica = new javax.swing.JList();
        btnGenerarOrden = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPausa = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreGrupoActionPerformed(evt);
            }
        });
        txtNombreGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreGrupoKeyReleased(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaGrafica);

        btnGenerarOrden.setText("Generar orden");
        btnGenerarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarOrdenActionPerformed(evt);
            }
        });

        jLabel1.setText("Pausa en milis:");

        txtPausa.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGenerarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerarOrden)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        guardarGrupo();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGenerarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarOrdenActionPerformed
        if(btnGenerarOrden.getText().equalsIgnoreCase("Generar orden")){
            btnGenerarOrden.setText("Detener generación");
            estado = true;
            new Thread(new Runnable() {

                public void run() {
                    while(estado){
                        try {
                            generarOrden();
                            Thread.sleep(Integer.parseInt(txtPausa.getValue().toString()));
                        } catch (InterruptedException ex) {
                            Logger.getLogger(JRandom.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }).start();
        }else{
            estado = false;
            btnGenerarOrden.setText("Generar orden");
        }

        
    }//GEN-LAST:event_btnGenerarOrdenActionPerformed

    private void txtNombreGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreGrupoActionPerformed

    }//GEN-LAST:event_txtNombreGrupoActionPerformed

    private void txtNombreGrupoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreGrupoKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            guardarGrupo();
        }
    }//GEN-LAST:event_txtNombreGrupoKeyReleased

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JRandom().setVisible(true);
            }
        });
    }

    private void agregarGrupo(Grupo nuevo){
        grupos.add(nuevo);
    }

    private void agregarGrupoAListaAleatoria(Grupo nuevo){
        gruposAleatorio.add(nuevo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGenerarOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaGrafica;
    private javax.swing.JTextField txtNombreGrupo;
    private javax.swing.JSpinner txtPausa;
    // End of variables declaration//GEN-END:variables

    private void listarGrupos(final List<Grupo> lista) {

        /*Asi es como se hace para mostrar
         datos en una lista grafica. Si se fijan, yo
         puse una lista de objetos grupo en una lista.
         Para ello tengo que establecer el modelo*/

        listaGrafica.setModel(new ListModel() {

            /*Obtiene el largo de la lista*/
            public int getSize() {
                return lista.size();
            }

            /*Obtiene el elemento de la lista en un indice
             determinado. Lo que retornará es un objeto, o sea,
             un grupo.*/
            public Object getElementAt(int index) {
                return lista.get(index);
            }

            public void addListDataListener(ListDataListener l) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void removeListDataListener(ListDataListener l) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }

    /*Método para verificar si existe un grupo determinado
     en la lista de grupos aleatorios*/
    private boolean estaEnGrupoAleatorio(int numeroGrupo){
        /*Recorro los grupos*/
        for(Grupo grupo : gruposAleatorio){
            /*Si el grupo es distinto de null*/
            if(grupo != null){
                /*si es el grupo que ando buscando, es porque
                 esta en la lista*/
                if(grupo.getNumero() == numeroGrupo){
                    return true;
                }
            }
        }

        /*Si se sale del ciclo, quiere decir que
         no encontro ese grupo*/
        return false;
    }


    /*Obtiene un grupo de la lista a partir de su numero*/
    private Grupo getGrupo(int numero){
        for(Grupo grupo : grupos){
            if(grupo.getNumero() == numero){
                return grupo;
            }
        }

        return null;
    }

    /*Método para gruardar un grupo en la lista. Esta hecho como
     método porque lo llamo desde el evento key enter y desde el botón
     agregar*/
    private void guardarGrupo() {
        Grupo nuevo;
        String nombre;

        nombre = txtNombreGrupo.getText();

        nuevo = new Grupo(contador, nombre);

        contador++;

        /*Agrego el nuevo grupo a la lista de grupos*/
        agregarGrupo(nuevo);

        /*Muestro esos grupos de forma gráfica*/
        listarGrupos(grupos);

        txtNombreGrupo.setText("");
        txtNombreGrupo.requestFocus();
    }

    private void generarOrden() {
        /*Cada vez que presiono el botón
         debo crear una nueva lista de grupos, la que
         se va a encargar de almacenar los grupos
         pero de forma aleatoria*/
        gruposAleatorio = new ArrayList<Grupo>();

        /*Clase que me permite generar numeros aleatorios*/
        Random random = new Random();


        /*Contador que me permite ir recorriendo
         todos los grupos*/
        int cont = 0;

        /*Variable que almacenara el numero aleatorio generado*/
        int numeroAleatorio;

        /*Cantidad de grupos*/
        int cantidadDeGrupos = grupos.size();


        /*ciclo para recorrer todos los grupos*/
        while(cont < cantidadDeGrupos){
            do{
                /*Genero un numero aleatorio y le sumo 1.
                 Esto es para que no comience de cero, si no de 1*/
                numeroAleatorio = random.nextInt(cantidadDeGrupos) + 1;

                /*Si el número generado ya esta en la lista de
                 grupos aleatorios, volverá a generar otro número*/
            }while(estaEnGrupoAleatorio(numeroAleatorio));

            /*En este punto, se ha generado un numero que no esta
             en la lista, por ende, debo rescatar a ese grupo*/
            Grupo grupo = getGrupo(numeroAleatorio);


            /*y luego lo agrtego a la otra lista. La lista de
             grupos aleatorios*/
            agregarGrupoAListaAleatoria(grupo);


            /*Aumento el contador para seguir recorriendo
             los grupos*/
            cont++;
        }


        /*Una vez afuera del ciclo, o sea, una vez terminado
         listo los grupos, pero ahora los grupos de forma aleatoria*/
        listarGrupos(gruposAleatorio);
    }

}
