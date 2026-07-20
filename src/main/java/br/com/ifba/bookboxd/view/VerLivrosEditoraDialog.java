package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.editora.entity.Editora;
import br.com.ifba.bookboxd.livro.entity.Livro;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.springframework.stereotype.Component;

//tela que exiba os livros ligados aquela editora
@Component
public class VerLivrosEditoraDialog extends javax.swing.JDialog {
    
    public VerLivrosEditoraDialog() {
        super();
        setModal(true);
        setTitle("Livros da Editora");
        initComponents();

        tblLivrosEditora.getColumnModel().getColumn(0).setMinWidth(0);
        tblLivrosEditora.getColumnModel().getColumn(0).setMaxWidth(0);
        tblLivrosEditora.getColumnModel().getColumn(0).setWidth(0);
    }

    public void mostrarLivros(java.awt.Component parent, Editora editora) {
        lblNomeEditora.setText(editora.getNome());
        preencherTabela(editora.getLivros());
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void preencherTabela(List<Livro> livros) {
        DefaultTableModel modelo = (DefaultTableModel) tblLivrosEditora.getModel();
        modelo.setRowCount(0);
        for (Livro l : livros) {
            String notaMedia = String.format("%.1f", l.calcularMediaAvaliacao());
            modelo.addRow(new Object[]{l.getId(), l.getTitulo(), l.getGenero(), notaMedia});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeEditora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivrosEditora = new javax.swing.JTable();
        btnFecharPerfilAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNomeEditora.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblNomeEditora.setText("nome");

        tblLivrosEditora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Título", "Genero", "Nota Media"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLivrosEditora);

        btnFecharPerfilAutor.setText("FECHAR");
        btnFecharPerfilAutor.addActionListener(this::btnFecharPerfilAutorActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(lblNomeEditora)
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnFecharPerfilAutor)
                            .addGap(33, 33, 33)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblNomeEditora)
                .addContainerGap(328, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnFecharPerfilAutor)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharPerfilAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharPerfilAutorActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharPerfilAutorActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFecharPerfilAutor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNomeEditora;
    private javax.swing.JTable tblLivrosEditora;
    // End of variables declaration//GEN-END:variables
}
