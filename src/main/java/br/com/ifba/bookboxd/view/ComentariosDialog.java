package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.avaliacao.controller.AvaliacaoController;
import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComentariosDialog extends javax.swing.JDialog {
    
    private final AvaliacaoController avaliacaoController;
    private Long avaliacaoId;
    private Long usuarioLogadoId;
    
    @Autowired
    public ComentariosDialog(AvaliacaoController avaliacaoController) {
        super();
        setModal(true);
        setTitle("Comentários");
        this.avaliacaoController = avaliacaoController;
        initComponents();

        tblComentarios.getColumnModel().getColumn(0).setMinWidth(0);
        tblComentarios.getColumnModel().getColumn(0).setMaxWidth(0);
        tblComentarios.getColumnModel().getColumn(0).setWidth(0);
    }

    public void mostrarComentarios(java.awt.Component parent, Long avaliacaoId, Long usuarioLogadoId) {
        this.avaliacaoId = avaliacaoId;
        this.usuarioLogadoId = usuarioLogadoId;
        txtNovoComentario.setText("");
        carregarComentarios();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    private void carregarComentarios() {
        try {
            Avaliacao avaliacao = avaliacaoController.findById(avaliacaoId).orElseThrow();
            lblAvaliacaoResumo.setText(avaliacao.getUsuario().getPessoa().getNome()
                    + " avaliou com " + avaliacao.getNota() + " estrelas: \"" + avaliacao.getAvaliacao() + "\"");

            preencherTabela(avaliacao.getComentarios());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
    
    private void preencherTabela(List<Comentario> comentarios) {
        DefaultTableModel modelo = (DefaultTableModel) tblComentarios.getModel();
        modelo.setRowCount(0);
        for (Comentario c : comentarios) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getUsuario().getPessoa().getNome(),
                c.getTexto(),
                c.getDataComentario()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblComentarios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNovoComentario = new javax.swing.JTextArea();
        bntEnviar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        lblAvaliacaoResumo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblComentarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Usuario", "Texto", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComentarios);

        txtNovoComentario.setColumns(20);
        txtNovoComentario.setRows(5);
        jScrollPane2.setViewportView(txtNovoComentario);

        bntEnviar.setText("ENVIAR");
        bntEnviar.addActionListener(this::bntEnviarActionPerformed);

        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        lblAvaliacaoResumo.setText("RESUMO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(bntEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblAvaliacaoResumo)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblAvaliacaoResumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntEnviar)
                    .addComponent(btnFechar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEnviarActionPerformed
        if (StringUtil.isEmpty(txtNovoComentario.getText())) {
            JOptionPane.showMessageDialog(this, "Escreva algo para comentar.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            avaliacaoController.adicionarComentario(avaliacaoId, usuarioLogadoId, txtNovoComentario.getText().trim());
            txtNovoComentario.setText("");
            carregarComentarios();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao comentar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bntEnviarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntEnviar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvaliacaoResumo;
    private javax.swing.JTable tblComentarios;
    private javax.swing.JTextArea txtNovoComentario;
    // End of variables declaration//GEN-END:variables
}
