package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.editora.entity.Editora;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.livro.controller.LivroController;
import br.com.ifba.bookboxd.livro.entity.Livro;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//tela para editar livros
@Component
public class EdicaoLivroDialog extends javax.swing.JDialog {
    
    private final LivroController livroController;
    private final BuscaAutorDialog buscaAutorDialog;
    private final BuscaEditoraDialog buscaEditoraDialog;
    private Autor autorEscolhido;
    private Editora editoraEscolhida;
    private Livro livroOriginal; 
    
    @Autowired
    public EdicaoLivroDialog(LivroController livroController, BuscaAutorDialog buscaAutorDialog,
                                BuscaEditoraDialog buscaEditoraDialog) {
        super();
        setModal(true);
        setTitle("Editar Livro");
        this.livroController = livroController;
        this.buscaAutorDialog = buscaAutorDialog;
        this.buscaEditoraDialog = buscaEditoraDialog;
        initComponents();
        
        txtSinopse.setLineWrap(true);
        txtSinopse.setWrapStyleWord(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtSinopse = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnSalvarAlteracao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtIsbn = new javax.swing.JTextField();
        txtAnopublicacao = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        lblAutorEscolhido = new javax.swing.JLabel();
        btnSelecionarEditora = new javax.swing.JButton();
        lblEditoraEscolhida = new javax.swing.JLabel();
        btnSelecionarAutor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtSinopse.setColumns(20);
        txtSinopse.setRows(5);
        jScrollPane1.setViewportView(txtSinopse);

        jLabel1.setText("Titulo");

        btnSalvarAlteracao.setText("SALVAR ALTERAÇÃO");
        btnSalvarAlteracao.addActionListener(this::btnSalvarAlteracaoActionPerformed);

        jLabel2.setText("ISBN");

        jLabel3.setText("Sinopse");

        jLabel4.setText("Ano Publicação");

        jLabel5.setText("Gênero");

        lblAutorEscolhido.setText("Autor Escolhido");
        lblAutorEscolhido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSelecionarEditora.setText("Selecionar Editora");
        btnSelecionarEditora.addActionListener(this::btnSelecionarEditoraActionPerformed);

        lblEditoraEscolhida.setText("Editora Escolhida");
        lblEditoraEscolhida.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSelecionarAutor.setText("Selecionar Autor");
        btnSelecionarAutor.addActionListener(this::btnSelecionarAutorActionPerformed);

        jButton1.setText("CANCELAR");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSelecionarEditora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSelecionarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAutorEscolhido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEditoraEscolhida, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIsbn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnopublicacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGenero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalvarAlteracao)
                        .addGap(125, 125, 125))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtAnopublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarAutor)
                    .addComponent(lblAutorEscolhido, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarEditora)
                    .addComponent(lblEditoraEscolhida))
                .addGap(27, 27, 27)
                .addComponent(btnSalvarAlteracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void prepararParaEdicao(java.awt.Frame parent, Livro livro) {
        this.livroOriginal = livro;
        preencherCampos();
        setLocationRelativeTo(parent);
    }
    
    // salvar a edição e chama o update
    private void btnSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracaoActionPerformed
        if (StringUtil.isEmpty(txtTitulo.getText())) {
            JOptionPane.showMessageDialog(this, "O campo Título é obrigatório.", "Campo obrigatório",
                    JOptionPane.WARNING_MESSAGE);
            txtTitulo.requestFocus();
            return;
        }
        
        int ano = 0;
        if (!StringUtil.isEmpty(txtAnopublicacao.getText())) {
            String textoAno = txtAnopublicacao.getText().trim();
            if (!StringUtil.isNumeric(textoAno)) {
                JOptionPane.showMessageDialog(this,
                        "Ano de Publicação deve ser um número inteiro.", "Valor inválido",
                        JOptionPane.WARNING_MESSAGE);
                txtAnopublicacao.requestFocus();
                return;
            }
            ano = Integer.parseInt(textoAno);
        }
        
        if (autorEscolhido == null) {
            JOptionPane.showMessageDialog(this, "Selecione um autor para o livro.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (editoraEscolhida == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma editora para o livro.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int opcao = JOptionPane.showConfirmDialog(
                this,
                "Confirmar alterações no livro \"" + txtTitulo.getText().trim() + "\"?",
                "Confirmar edição",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (opcao != JOptionPane.YES_OPTION) return;
        
        livroOriginal.setTitulo(txtTitulo.getText().trim());
        livroOriginal.setIsbn(txtIsbn.getText().trim());
        livroOriginal.setAnoPublicacao(ano);
        livroOriginal.setGenero(txtGenero.getText().trim());
        livroOriginal.setSinopse(txtSinopse.getText().trim());
        livroOriginal.setAutor(autorEscolhido);
        livroOriginal.setEditora(editoraEscolhida);
        
        try {
            livroController.update(livroOriginal);
            JOptionPane.showMessageDialog(this, "Livro atualizado com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao atualizar", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSalvarAlteracaoActionPerformed

    private void btnSelecionarEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarEditoraActionPerformed
        Editora escolhida = buscaEditoraDialog.mostrarESelecionar(this);
        if (escolhida != null){
            this.editoraEscolhida = escolhida;
            lblEditoraEscolhida.setText("Editora: " + escolhida.getNome());
        }
    }//GEN-LAST:event_btnSelecionarEditoraActionPerformed

    private void btnSelecionarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarAutorActionPerformed
        Autor escolhido = buscaAutorDialog.mostrarESelecionar(this);
        if (escolhido != null) {
            this.autorEscolhido = escolhido;
            lblAutorEscolhido.setText("Autor: " + escolhido.getPessoa().getNome());
        }
    }//GEN-LAST:event_btnSelecionarAutorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    // popula a tela de edição tratando possíveis valores nulos
    private void preencherCampos() {
        if(livroOriginal.getAutor() != null){
            autorEscolhido = livroOriginal.getAutor();
        }
        if(livroOriginal.getEditora() != null){
            editoraEscolhida = livroOriginal.getEditora();
        }
        
        txtTitulo.setText(livroOriginal.getTitulo());
        txtIsbn.setText(livroOriginal.getIsbn() != null ? livroOriginal.getIsbn() : "");
        txtAnopublicacao.setText(String.valueOf(livroOriginal.getAnoPublicacao()));
        txtGenero.setText(livroOriginal.getGenero() != null ? livroOriginal.getGenero() : "");
        txtSinopse.setText(livroOriginal.getSinopse() != null ? livroOriginal.getSinopse() : "");
        lblAutorEscolhido.setText(autorEscolhido.getPessoa().getNome());
        lblEditoraEscolhida.setText(livroOriginal.getEditora().getNome());
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvarAlteracao;
    private javax.swing.JButton btnSelecionarAutor;
    private javax.swing.JButton btnSelecionarEditora;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutorEscolhido;
    private javax.swing.JLabel lblEditoraEscolhida;
    private javax.swing.JTextField txtAnopublicacao;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextArea txtSinopse;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
