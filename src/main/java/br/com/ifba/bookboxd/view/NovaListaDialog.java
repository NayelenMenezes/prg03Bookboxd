package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.usuario.controller.UsuarioController;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//telinha para criar nova lista de leituara
@Component
public class NovaListaDialog extends javax.swing.JDialog {
    
    private final UsuarioController usuarioController;
    private Long usuarioId;
    private boolean salvouComSucesso;
    
    @Autowired
    public NovaListaDialog(UsuarioController usuarioController) {
        super();
        setModal(true);
        setTitle("Nova Lista de Leitura");
        this.usuarioController = usuarioController;
        initComponents();
        
        txtDescricaoLista.setLineWrap(true);
        txtDescricaoLista.setWrapStyleWord(true);
    }

    public boolean mostrarParaCriar(java.awt.Component parent, Long usuarioId) {
        this.usuarioId = usuarioId;
        this.salvouComSucesso = false;
        txtNomeLista.setText("");
        txtDescricaoLista.setText("");
        setLocationRelativeTo(parent);
        setVisible(true);
        return salvouComSucesso;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNomeLista = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricaoLista = new javax.swing.JTextArea();
        btnSalvarLista = new javax.swing.JButton();
        btnCancelarLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNome.setText("NOME:");

        lblDescricao.setText("DESCRIÇÃO:");

        txtDescricaoLista.setColumns(20);
        txtDescricaoLista.setRows(5);
        jScrollPane1.setViewportView(txtDescricaoLista);

        btnSalvarLista.setText("SALVAR");
        btnSalvarLista.addActionListener(this::btnSalvarListaActionPerformed);

        btnCancelarLista.setText("CANCELAR");
        btnCancelarLista.addActionListener(this::btnCancelarListaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDescricao)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(txtNomeLista, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnCancelarLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvarLista)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNomeLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarLista)
                    .addComponent(btnSalvarLista))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarListaActionPerformed
        if(StringUtil.isEmpty(txtNomeLista.getText())){
            JOptionPane.showMessageDialog(this, "O nome da lista é obrigatório.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            usuarioController.criarListaLeitura(usuarioId, txtNomeLista.getText().trim(), txtDescricaoLista.getText().trim());
            JOptionPane.showMessageDialog(this, "Lista criada com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            salvouComSucesso = true;
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao criar lista", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarListaActionPerformed

    private void btnCancelarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarListaActionPerformed
        salvouComSucesso = false;
        dispose();
    }//GEN-LAST:event_btnCancelarListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarLista;
    private javax.swing.JButton btnSalvarLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextArea txtDescricaoLista;
    private javax.swing.JTextField txtNomeLista;
    // End of variables declaration//GEN-END:variables
}
