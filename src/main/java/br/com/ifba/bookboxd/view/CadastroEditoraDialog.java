package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.editora.contoller.EditoraController;
import br.com.ifba.bookboxd.editora.entity.Editora;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//uma telinha que faz o cadastro de novas editoras 
@Component
public class CadastroEditoraDialog extends javax.swing.JDialog {
    
    private final EditoraController editoraController;
    
    @Autowired
    public CadastroEditoraDialog(EditoraController editoraController) {
        super();
        setModal(true);
        setTitle("Cadastrar Editora");
        this.editoraController = editoraController;
        initComponents();
    }

    public void prepararParaNovoCadastro(java.awt.Frame parent) {
        txtNomeEditora.setText("");
        txtSiteEditora.setText("");
        setLocationRelativeTo(parent);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSiteEditora = new javax.swing.JTextField();
        lblNomeEditora = new javax.swing.JLabel();
        lblSiteEditora = new javax.swing.JLabel();
        txtNomeEditora = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        jLabel1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel1.setText("CADASTRAR EDITORA");

        lblNomeEditora.setText("NOME");

        lblSiteEditora.setText("SITE");

        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(this::btnCadastrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSiteEditora)
                    .addComponent(lblNomeEditora))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSiteEditora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeEditora))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSiteEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSiteEditora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (StringUtil.isEmpty(txtNomeEditora.getText())) {
            JOptionPane.showMessageDialog(this, "O nome da editora é obrigatório.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            txtNomeEditora.requestFocus();
            return;
        }
        if (StringUtil.isEmpty(txtSiteEditora.getText())) {
            JOptionPane.showMessageDialog(this, "O site da editora é obrigatório.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            txtSiteEditora.requestFocus();
            return;
        }
        
        Editora editora = new Editora();
        editora.setNome(txtNomeEditora.getText().trim());
        editora.setSite(txtSiteEditora.getText().trim());
        
        try {
            editoraController.save(editora);
            JOptionPane.showMessageDialog(this, "Editora cadastrada com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_btnCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNomeEditora;
    private javax.swing.JLabel lblSiteEditora;
    private javax.swing.JTextField txtNomeEditora;
    private javax.swing.JTextField txtSiteEditora;
    // End of variables declaration//GEN-END:variables
}
