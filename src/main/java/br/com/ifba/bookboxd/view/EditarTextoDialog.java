package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Component;

//tela para editar comentario ou avaliações
@Component
public class EditarTextoDialog extends javax.swing.JDialog {

    private String resultado; 

    public EditarTextoDialog() {
        super();
        setModal(true);
        initComponents();
        txtConteudo.setLineWrap(true);
        txtConteudo.setWrapStyleWord(true);
    }
    
    public String mostrarParaEditar(java.awt.Component parent, String tituloJanela, String textoAtual) {
        setTitle(tituloJanela);
        this.resultado = null;
        txtConteudo.setText(textoAtual);
        setLocationRelativeTo(parent);
        setVisible(true);
        return resultado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtConteudo = new javax.swing.JTextArea();
        btnSalvarTexto = new javax.swing.JButton();
        btnCancelarTexto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtConteudo.setColumns(20);
        txtConteudo.setRows(5);
        jScrollPane1.setViewportView(txtConteudo);

        btnSalvarTexto.setText("SALVAR");
        btnSalvarTexto.addActionListener(this::btnSalvarTextoActionPerformed);

        btnCancelarTexto.setText("CANCELAR");
        btnCancelarTexto.addActionListener(this::btnCancelarTextoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnCancelarTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvarTexto)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarTexto)
                    .addComponent(btnCancelarTexto))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarTextoActionPerformed
        if (StringUtil.isEmpty(txtConteudo.getText())) {
            JOptionPane.showMessageDialog(this, "O texto não pode ficar vazio.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.resultado = txtConteudo.getText().trim();
        dispose();
    }//GEN-LAST:event_btnSalvarTextoActionPerformed

    private void btnCancelarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTextoActionPerformed
        this.resultado = null;
        dispose();
    }//GEN-LAST:event_btnCancelarTextoActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarTexto;
    private javax.swing.JButton btnSalvarTexto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtConteudo;
    // End of variables declaration//GEN-END:variables
}
