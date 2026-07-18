package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.avaliacao.controller.AvaliacaoController;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.livro.entity.Livro;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NovaAvaliacaoDialog extends javax.swing.JDialog {
    
    private final AvaliacaoController avaliacaoController;
    private Long usuarioId;
    private Livro livro;
    private boolean salvouComSucesso;
    
    @Autowired
    public NovaAvaliacaoDialog(AvaliacaoController avaliacaoController) {
        super();
        setModal(true);
        setTitle("Avaliar Livro");
        this.avaliacaoController = avaliacaoController;
        initComponents();
    }
    
    public boolean mostrarParaCriar(java.awt.Component parent, Long usuarioId, Livro livro){
        this.usuarioId = usuarioId;
        this.livro = livro;
        this.salvouComSucesso = false;
        
        lblLivroSelecionado.setText("Avaliando: " + livro.getTitulo());
        txtTexto.setText("");
        cbNota.setSelectedIndex(4);
        chkSpoiler.setSelected(false);
        
        setLocationRelativeTo(parent);
        setVisible(true);
        return salvouComSucesso;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLivroSelecionado = new javax.swing.JLabel();
        cbNota = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        chkSpoiler = new javax.swing.JCheckBox();
        btnSalvarAvaliacao = new javax.swing.JButton();
        btnCancelarAvaliacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblLivroSelecionado.setText("livro");

        cbNota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);

        chkSpoiler.setText("Contém Spoiler");

        btnSalvarAvaliacao.setText("SALVAR");
        btnSalvarAvaliacao.addActionListener(this::btnSalvarAvaliacaoActionPerformed);

        btnCancelarAvaliacao.setText("CANCELAR");
        btnCancelarAvaliacao.addActionListener(this::btnCancelarAvaliacaoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chkSpoiler))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvarAvaliacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarAvaliacao))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLivroSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLivroSelecionado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkSpoiler)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarAvaliacao)
                    .addComponent(btnCancelarAvaliacao))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAvaliacaoActionPerformed
        if(StringUtil.isEmpty(txtTexto.getText())){
            JOptionPane.showMessageDialog(this, "Escreva um texto para a avaliação.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int nota = Integer.parseInt((String)cbNota.getSelectedItem());
        boolean spoiler = chkSpoiler.isSelected();
        
        try {
            avaliacaoController.criarAvaliacao(usuarioId, livro.getId(), nota, txtTexto.getText().trim(), spoiler);
            JOptionPane.showMessageDialog(this, "Avaliação publicada com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            salvouComSucesso = true;
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao avaliar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarAvaliacaoActionPerformed

    private void btnCancelarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAvaliacaoActionPerformed
        salvouComSucesso = false;
        dispose();
    }//GEN-LAST:event_btnCancelarAvaliacaoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarAvaliacao;
    private javax.swing.JButton btnSalvarAvaliacao;
    private javax.swing.JComboBox<String> cbNota;
    private javax.swing.JCheckBox chkSpoiler;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLivroSelecionado;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
