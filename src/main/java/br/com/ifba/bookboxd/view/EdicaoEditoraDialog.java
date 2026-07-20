package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.editora.contoller.EditoraController;
import br.com.ifba.bookboxd.editora.entity.Editora;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//tela para editar editoras
@Component
public class EdicaoEditoraDialog extends javax.swing.JDialog {
    
    private final EditoraController editoraController;
    private Editora editoraOriginal;
    
    @Autowired
    public EdicaoEditoraDialog(EditoraController editoraController) {
        super();
        setModal(true);
        setTitle("Editar Editora");
        this.editoraController = editoraController;
        initComponents();
    }

    public void prepararParaEdicao(java.awt.Frame parent, Editora editora) {
        this.editoraOriginal = editora;
        txtNomeEditora.setText(editora.getNome());
        txtSiteEditora.setText(editora.getSite());
        setLocationRelativeTo(parent);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        txtSiteEditora = new javax.swing.JTextField();
        lblNomeEditora = new javax.swing.JLabel();
        lblSiteEditora = new javax.swing.JLabel();
        txtNomeEditora = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        lblNomeEditora.setText("NOME");

        lblSiteEditora.setText("SITE");

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblSiteEditora)
                                .addComponent(lblNomeEditora))
                            .addGap(70, 70, 70)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSiteEditora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomeEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(68, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomeEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNomeEditora))
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSiteEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSiteEditora))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                    .addComponent(btnSalvar)
                    .addGap(18, 18, 18)
                    .addComponent(btnCancelar)
                    .addGap(55, 55, 55)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(StringUtil.isEmpty(txtNomeEditora.getText())){
            JOptionPane.showMessageDialog(this, "O nome da editora é obrigatório.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (StringUtil.isEmpty(txtSiteEditora.getText())) {
            JOptionPane.showMessageDialog(this, "O site da editora é obrigatório.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        editoraOriginal.setNome(txtNomeEditora.getText().trim());
        editoraOriginal.setSite(txtSiteEditora.getText().trim());
        
        try {
            editoraController.update(editoraOriginal);
            JOptionPane.showMessageDialog(this, "Editora atualizada com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao atualizar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblNomeEditora;
    private javax.swing.JLabel lblSiteEditora;
    private javax.swing.JTextField txtNomeEditora;
    private javax.swing.JTextField txtSiteEditora;
    // End of variables declaration//GEN-END:variables
}
