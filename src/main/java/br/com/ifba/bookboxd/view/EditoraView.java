package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.editora.contoller.EditoraController;
import br.com.ifba.bookboxd.editora.entity.Editora;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditoraView extends javax.swing.JFrame {
    
    private final EditoraController editoraController;
    private final CadastroEditoraDialog cadastroEditoraDialog;
    private final EdicaoEditoraDialog edicaoEditoraDialog;
    private final VerLivrosEditoraDialog verLivrosEditoraDialog;
    
    @Autowired
    public EditoraView(EditoraController editoraController, CadastroEditoraDialog cadastroEditoraDialog,
                        EdicaoEditoraDialog edicaoEditoraDialog, VerLivrosEditoraDialog verLivrosEditoraDialog) {
        
        this.editoraController = editoraController;
        this.cadastroEditoraDialog = cadastroEditoraDialog;
        this.edicaoEditoraDialog = edicaoEditoraDialog;
        this.verLivrosEditoraDialog = verLivrosEditoraDialog;
        initComponents();
        
        tblEditoras.getColumnModel().getColumn(0).setMinWidth(0);
        tblEditoras.getColumnModel().getColumn(0).setMaxWidth(0);
        tblEditoras.getColumnModel().getColumn(0).setWidth(0);

        carregarTodasEditoras();
    }
    
    public void atualizarLista() {
        txtBuscaEditora.setText("");
        carregarTodasEditoras();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerLivros = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblEditora = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscaEditora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEditoras = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnVerLivros.setText("VER LIVROS");
        btnVerLivros.addActionListener(this::btnVerLivrosActionPerformed);

        lblEditora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEditora.setText("EDITORA");

        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(this::btnCadastrarActionPerformed);

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnDeletar.setText("DELETAR");
        btnDeletar.addActionListener(this::btnDeletarActionPerformed);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tblEditoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nome", "Site", "Qtd. Livros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEditoras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(lblEditora))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addGap(18, 161, Short.MAX_VALUE)
                                .addComponent(txtBuscaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerLivros)))))
                .addGap(31, 31, 31))
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEditora)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnCadastrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnEditar)
                    .addComponent(btnVerLivros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerLivrosActionPerformed
        Editora selecionada = getEditoraSelecionada();
        if (selecionada == null) return;

        verLivrosEditoraDialog.mostrarLivros(this, selecionada);
    }//GEN-LAST:event_btnVerLivrosActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastroEditoraDialog.prepararParaNovoCadastro(this);
        cadastroEditoraDialog.setVisible(true);
        carregarTodasEditoras();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Editora selecionada = getEditoraSelecionada();
        if (selecionada == null) return;
        
        edicaoEditoraDialog.prepararParaEdicao(this, selecionada);
        edicaoEditoraDialog.setVisible(true);
        carregarTodasEditoras();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Editora selecionada = getEditoraSelecionada();
        if (selecionada == null) return;
        
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja deletar a editora:\n\"" + selecionada.getNome() + "\"?\n\n" +
                "Os livros associados a ela não serão apagados, apenas ficarão sem editora vinculada.",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                editoraController.delete(selecionada.getId());
                JOptionPane.showMessageDialog(this, "Editora deletada com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                carregarTodasEditoras();
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao deletar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termo = txtBuscaEditora.getText().trim();
        if (StringUtil.isEmpty(termo)) {
            carregarTodasEditoras();
            return;
        }
        try {
            List<Editora> resultados = editoraController.findByNome(termo);
            preencherTabela(resultados);
        } catch (RuntimeException e) {
            preencherTabela(List.of());
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Busca sem resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    
    private Editora getEditoraSelecionada() {
        int linha = tblEditoras.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma editora na tabela primeiro.",
                    "Nenhuma editora selecionada", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        DefaultTableModel modelo = (DefaultTableModel) tblEditoras.getModel();
        Long id = (Long) modelo.getValueAt(linha, 0);

        try {
            return editoraController.findById(id).orElse(null);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void carregarTodasEditoras() {
        try {
            preencherTabela(editoraController.findAll());
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }

    private void preencherTabela(List<Editora> editoras) {
        DefaultTableModel modelo = (DefaultTableModel) tblEditoras.getModel();
        modelo.setRowCount(0);
        for (Editora e : editoras) {
            modelo.addRow(new Object[]{
                e.getId(),
                e.getNome(),
                e.getSite(),
                e.getLivros().size() + " livro(s)"
            });
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVerLivros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEditora;
    private javax.swing.JTable tblEditoras;
    private javax.swing.JTextField txtBuscaEditora;
    // End of variables declaration//GEN-END:variables
}
