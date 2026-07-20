package br.com.ifba.bookboxd.view;

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
    private Livro livroOriginal; 
    
    @Autowired
    public EdicaoLivroDialog(LivroController livroController) {
        super();
        setModal(true);
        setTitle("Editar Livro");
        this.livroController = livroController;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtSinopse.setColumns(20);
        txtSinopse.setRows(5);
        jScrollPane1.setViewportView(txtSinopse);

        jLabel1.setText("Titulo");

        btnSalvarAlteracao.setText("Salvar Alteração");
        btnSalvarAlteracao.addActionListener(this::btnSalvarAlteracaoActionPerformed);

        jLabel2.setText("ISBN");

        jLabel3.setText("Sinopse");

        jLabel4.setText("Ano Publicação");

        jLabel5.setText("Gênero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(txtIsbn)
                            .addComponent(txtAnopublicacao)
                            .addComponent(txtGenero)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvarAlteracao)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(btnSalvarAlteracao)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void prepararParaEdicao(java.awt.Frame parent, Livro livro) {
        this.livroOriginal = livro;
        preencherCampos();
        setLocationRelativeTo(parent);
    }
    
    // Ação do botão Salvar Edição
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
        
        try {
            livroController.update(livroOriginal); // update(), não save() -- já existe e verifica se o livro existe
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
    
    // popula a tela de edição tratando possíveis valores nulos
    private void preencherCampos() {
        txtTitulo.setText(livroOriginal.getTitulo());
        txtIsbn.setText(livroOriginal.getIsbn() != null ? livroOriginal.getIsbn() : "");
        txtAnopublicacao.setText(String.valueOf(livroOriginal.getAnoPublicacao()));
        txtGenero.setText(livroOriginal.getGenero() != null ? livroOriginal.getGenero() : "");
        txtSinopse.setText(livroOriginal.getSinopse() != null ? livroOriginal.getSinopse() : "");
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvarAlteracao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAnopublicacao;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextArea txtSinopse;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
