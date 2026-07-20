package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.editora.contoller.EditoraController;
import br.com.ifba.bookboxd.editora.entity.Editora;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//telinha que faz a busca de editoras
@Component
public class BuscaEditoraDialog extends javax.swing.JDialog {
    
    private final EditoraController editoraController;
    private Editora editoraSelecionado;
    
    @Autowired
    public BuscaEditoraDialog(EditoraController editoraController) {
        super();
        setModal(true);
        setTitle("Selecionar Editora");
        this.editoraController = editoraController;
        initComponents();
        
        tblEditorasBusca.getColumnModel().getColumn(0).setMinWidth(0);
        tblEditorasBusca.getColumnModel().getColumn(0).setMaxWidth(0);
        tblEditorasBusca.getColumnModel().getColumn(0).setWidth(0);
    }

    public Editora mostrarESelecionar(java.awt.Component parent) {
        this.editoraSelecionado = null;
        txtBuscaEditora.setText("");
        carregarTodos();
        setLocationRelativeTo(parent);
        setVisible(true);
        return editoraSelecionado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscaEditora = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEditorasBusca = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        btnCancelarBusca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tblEditorasBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nome", "Site"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEditorasBusca);

        btnSelecionar.setText("SELECIONAR");
        btnSelecionar.addActionListener(this::btnSelecionarActionPerformed);

        btnCancelarBusca.setText("CANCELAR");
        btnCancelarBusca.addActionListener(this::btnCancelarBuscaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnBuscar)
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarBusca)
                .addGap(142, 142, 142)
                .addComponent(btnSelecionar)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarBusca)
                    .addComponent(btnSelecionar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termo = txtBuscaEditora.getText().trim();
        if(StringUtil.isEmpty(termo)){
            carregarTodos();
            return;
        }

        try {
            List<Editora> resultados = editoraController.findByNome(termo);
            preencherTabela(resultados);
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        int linha = tblEditorasBusca.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma editora na tabela.",
                "Nenhuma editora selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblEditorasBusca.getModel();
        Long id = (Long) modelo.getValueAt(linha, 0);

        try {
            this.editoraSelecionado = editoraController.findById(id).orElse(null);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnCancelarBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBuscaActionPerformed
        this.editoraSelecionado = null;
        dispose();
    }//GEN-LAST:event_btnCancelarBuscaActionPerformed

    private void carregarTodos() {
        try {
            preencherTabela(editoraController.findAll());
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }

    private void preencherTabela(List<Editora> editores) {
        DefaultTableModel modelo = (DefaultTableModel) tblEditorasBusca.getModel();
        modelo.setRowCount(0);
        for (Editora e : editores) {
            modelo.addRow(new Object[]{e.getId(), e.getNome(), e.getSite()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelarBusca;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEditorasBusca;
    private javax.swing.JTextField txtBuscaEditora;
    // End of variables declaration//GEN-END:variables
}
