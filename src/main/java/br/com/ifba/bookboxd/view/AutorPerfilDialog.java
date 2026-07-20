package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.autor.controller.AutorController;
import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.livro.entity.Livro;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//exibe o perfil do autor
@Component
public class AutorPerfilDialog extends javax.swing.JDialog {
    
    private final AutorController autorController;
    
   @Autowired
    public AutorPerfilDialog(AutorController autorController) {
        super();
        setModal(true);
        setTitle("Perfil do Autor");
        this.autorController = autorController;
        initComponents();
        
        tblLivrosAutor.getColumnModel().getColumn(0).setMinWidth(0);
        tblLivrosAutor.getColumnModel().getColumn(0).setMaxWidth(0);
        tblLivrosAutor.getColumnModel().getColumn(0).setWidth(0);
    }

    public void mostrarPerfil(java.awt.Component parent, Autor autor) {
        lblNomeAutor.setText(autor.getPessoa().getNome());
        lblNacionalidade.setText("Nacionalidade: " + autor.getNacionalidade());
        lblBiografia.setText(autor.getPessoa().getBiografia() != null
                ? autor.getPessoa().getBiografia() : "Sem biografia");

        preencherTabela(autor.getLivros());
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    private void preencherTabela(java.util.List<Livro> livros) {
        DefaultTableModel modelo = (DefaultTableModel) tblLivrosAutor.getModel();
        modelo.setRowCount(0);
        for (Livro l : livros) {
            String editoraNome = l.getEditora() != null ? l.getEditora().getNome() : "Sem editora";
            String notaMedia = String.format("%.1f", l.calcularMediaAvaliacao());
            modelo.addRow(new Object[]{l.getId(), l.getTitulo(), notaMedia, editoraNome});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeAutor = new javax.swing.JLabel();
        lblNacionalidade = new javax.swing.JLabel();
        lblBiografia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivrosAutor = new javax.swing.JTable();
        btnFecharPerfilAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNomeAutor.setText("nome");

        lblNacionalidade.setText("nacionalidae");

        lblBiografia.setText("bio");

        tblLivrosAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Título", "Nota Media", "Editora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLivrosAutor);

        btnFecharPerfilAutor.setText("FECHAR");
        btnFecharPerfilAutor.addActionListener(this::btnFecharPerfilAutorActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFecharPerfilAutor)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNacionalidade)
                    .addComponent(lblNomeAutor)
                    .addComponent(lblBiografia, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblNomeAutor)
                .addGap(28, 28, 28)
                .addComponent(lblNacionalidade)
                .addGap(18, 18, 18)
                .addComponent(lblBiografia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFecharPerfilAutor)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharPerfilAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharPerfilAutorActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharPerfilAutorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFecharPerfilAutor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBiografia;
    private javax.swing.JLabel lblNacionalidade;
    private javax.swing.JLabel lblNomeAutor;
    private javax.swing.JTable tblLivrosAutor;
    // End of variables declaration//GEN-END:variables
}
