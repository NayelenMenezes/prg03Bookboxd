package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.livro.controller.LivroController;
import br.com.ifba.bookboxd.livro.entity.Livro;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroLivroDialog extends javax.swing.JDialog {
    
    private final LivroController livroController;
    private final BuscaAutorDialog buscaAutorDialog;
    private Autor autorEscolhido;

    @Autowired
    public CadastroLivroDialog(LivroController livroController, BuscaAutorDialog buscaAutorDialog) {
        super();
        setModal(true);
        this.livroController = livroController;
        this.buscaAutorDialog = buscaAutorDialog;
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtIsbn = new javax.swing.JTextField();
        txtAnopublicacao = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSinopse = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnSelecionarAutor = new javax.swing.JButton();
        lblAutorEscolhido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Titulo");

        jLabel2.setText("ISBN");

        jLabel3.setText("Sinopse");

        jLabel4.setText("Ano Publicação");

        jLabel5.setText("Gênero");

        txtSinopse.setColumns(20);
        txtSinopse.setRows(5);
        jScrollPane1.setViewportView(txtSinopse);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnSelecionarAutor.setText("Selecionar Autor");
        btnSelecionarAutor.addActionListener(this::btnSelecionarAutorActionPerformed);

        lblAutorEscolhido.setText("Autor Escolhido");
        lblAutorEscolhido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(158, 158, 158))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelecionarAutor)
                        .addGap(18, 18, 18)
                        .addComponent(lblAutorEscolhido, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(txtIsbn)
                                    .addComponent(txtAnopublicacao)
                                    .addComponent(txtGenero)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarAutor)
                    .addComponent(lblAutorEscolhido, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void prepararParaNovoCadastro(java.awt.Frame parent) {
        limparCampos();
        this.autorEscolhido = null;
        lblAutorEscolhido.setText("Nenhum autor selecionado");
        setLocationRelativeTo(parent);
    }
    
    private void limparCampos() {
        txtTitulo.setText("");
        txtIsbn.setText("");
        txtAnopublicacao.setText("");
        txtGenero.setText("");
        txtSinopse.setText("");
    }
    // Ação do botão Salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(StringUtil.isEmpty(txtTitulo.getText())){
                JOptionPane.showMessageDialog(this,
                    "O campo Título é obrigatório.", "Campo obrigatório",
                    JOptionPane.WARNING_MESSAGE);
                txtTitulo.requestFocus();
                return;
           }

        int ano = 0;
        if(!StringUtil.isEmpty(txtAnopublicacao.getText())){
            String textoAno = txtAnopublicacao.getText().trim();
            if(!StringUtil.isNumeric(textoAno)){
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
        
        Livro livro = new Livro();
        livro.setTitulo(txtTitulo.getText().trim());
        livro.setIsbn(txtIsbn.getText().trim());
        livro.setAnoPublicacao(ano);
        livro.setGenero(txtGenero.getText().trim());
        livro.setSinopse(txtSinopse.getText().trim());
        livro.setAutor(autorEscolhido);
        
        try {
            livroController.save(livro);
            JOptionPane.showMessageDialog(this,
                    "Livro \"" + livro.getTitulo() + "\" cadastrado com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSelecionarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarAutorActionPerformed
        Autor escolhido = buscaAutorDialog.mostrarESelecionar(this);
        if (escolhido != null) {
            this.autorEscolhido = escolhido;
            lblAutorEscolhido.setText("Autor: " + escolhido.getPessoa().getNome());
        }
    }//GEN-LAST:event_btnSelecionarAutorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSelecionarAutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutorEscolhido;
    private javax.swing.JTextField txtAnopublicacao;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextArea txtSinopse;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
