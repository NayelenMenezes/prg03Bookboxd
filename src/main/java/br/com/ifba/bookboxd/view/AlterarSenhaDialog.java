package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.usuario.controller.UsuarioController;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//telinha para alterar a senha
@Component
public class AlterarSenhaDialog extends javax.swing.JDialog {

    private final UsuarioController usuarioController;
    private Long usuarioId;

    @Autowired
    public AlterarSenhaDialog(UsuarioController usuarioController) {
        super();
        setModal(true);
        setTitle("Alterar Senha");
        this.usuarioController = usuarioController;
        initComponents();
    }
    
    public void mostrarParaAlterar(java.awt.Component parent, Long usuarioId) {
        this.usuarioId = usuarioId;
        txtSenhaAtual.setText("");
        txtNovaSenha.setText("");
        txtConfirmarSenha.setText("");
        setLocationRelativeTo(parent);
        setVisible(true);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSenhaAtual = new javax.swing.JPasswordField();
        txtNovaSenha = new javax.swing.JPasswordField();
        txtConfirmarSenha = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblSenhaAntiga = new javax.swing.JLabel();
        lblSenhaNova = new javax.swing.JLabel();
        lblConfirmar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtSenhaAtual.setText("jPasswordField1");

        txtNovaSenha.setText("jPasswordField2");

        txtConfirmarSenha.setText("jPasswordField3");

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        lblSenhaAntiga.setText("SENHA ANTIGA");

        lblSenhaNova.setText("NOVA SENHA");

        lblConfirmar.setText("CONFIRMAR SENHA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSenhaAntiga)
                    .addComponent(lblSenhaNova)
                    .addComponent(lblConfirmar))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenhaAntiga))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenhaNova))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmar))
                .addGap(44, 44, 44)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String senhaAtual = new String(txtSenhaAtual.getPassword());
        String novaSenha = new String(txtNovaSenha.getPassword());
        String confirmarSenha = new String(txtConfirmarSenha.getPassword());

        if (StringUtil.isEmpty(senhaAtual) || StringUtil.isEmpty(novaSenha) || StringUtil.isEmpty(confirmarSenha)) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.",
                    "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!novaSenha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(this, "A nova senha e a confirmação não coincidem.",
                    "Senhas diferentes", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            usuarioController.alterarSenha(usuarioId, senhaAtual, novaSenha);
            JOptionPane.showMessageDialog(this, "Senha alterada com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao alterar senha", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblSenhaAntiga;
    private javax.swing.JLabel lblSenhaNova;
    private javax.swing.JPasswordField txtConfirmarSenha;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JPasswordField txtSenhaAtual;
    // End of variables declaration//GEN-END:variables
}
