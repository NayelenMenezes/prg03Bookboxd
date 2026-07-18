package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.autor.controller.AutorController;
import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscaAutorDialog extends javax.swing.JDialog {
    
    private final AutorController autorController;
    private Autor autorSelecionado;
    
    @Autowired
    public BuscaAutorDialog(AutorController autorController) {
        super();
        setModal(true);
        setTitle("Selecionar Autor");
        this.autorController = autorController;
        initComponents();
        
        tblAutoresBusca.getColumnModel().getColumn(0).setMinWidth(0);
        tblAutoresBusca.getColumnModel().getColumn(0).setMaxWidth(0);
        tblAutoresBusca.getColumnModel().getColumn(0).setWidth(0);
    }
    
    public Autor mostrarESelecionar(java.awt.Component parent) {
        this.autorSelecionado = null;
        txtBuscaAutor.setText("");
        carregarTodos();
        setLocationRelativeTo(parent);
        setVisible(true);
        return autorSelecionado;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscaAutor = new javax.swing.JTextField();
        btnBuscarAutor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAutoresBusca = new javax.swing.JTable();
        btnSelecionarAutor = new javax.swing.JButton();
        btnCancelarBuscaAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnBuscarAutor.setText("BUSCAR");
        btnBuscarAutor.addActionListener(this::btnBuscarAutorActionPerformed);

        tblAutoresBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Nacionalidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAutoresBusca);

        btnSelecionarAutor.setText("SELECIONAR");
        btnSelecionarAutor.addActionListener(this::btnSelecionarAutorActionPerformed);

        btnCancelarBuscaAutor.setText("CANCELAR");
        btnCancelarBuscaAutor.addActionListener(this::btnCancelarBuscaAutorActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnBuscarAutor)
                        .addGap(0, 101, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnSelecionarAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarBuscaAutor)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAutor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarAutor)
                    .addComponent(btnCancelarBuscaAutor))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarAutorActionPerformed
        int linha = tblAutoresBusca.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um autor na tabela.",
                    "Nenhum autor selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblAutoresBusca.getModel();
        Long id = (Long) modelo.getValueAt(linha, 0);
        
        try {
            this.autorSelecionado = autorController.findById(id).orElse(null);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSelecionarAutorActionPerformed

    private void btnCancelarBuscaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBuscaAutorActionPerformed
        this.autorSelecionado = null;
        dispose();
    }//GEN-LAST:event_btnCancelarBuscaAutorActionPerformed

    private void btnBuscarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutorActionPerformed
        String termo = txtBuscaAutor.getText().trim();
        if(StringUtil.isEmpty(termo)){
            carregarTodos();
            return;
        }
        
        try {
            List<Autor> resultados = autorController.findByNacionalide(termo);
            preencherTabela(resultados);
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }//GEN-LAST:event_btnBuscarAutorActionPerformed

    private void carregarTodos() {
        try {
            preencherTabela(autorController.findAll());
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }

    private void preencherTabela(List<Autor> autores) {
        DefaultTableModel modelo = (DefaultTableModel) tblAutoresBusca.getModel();
        modelo.setRowCount(0);
        for (Autor a : autores) {
            modelo.addRow(new Object[]{a.getId(), a.getPessoa().getNome(), a.getNacionalidade()});
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAutor;
    private javax.swing.JButton btnCancelarBuscaAutor;
    private javax.swing.JButton btnSelecionarAutor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAutoresBusca;
    private javax.swing.JTextField txtBuscaAutor;
    // End of variables declaration//GEN-END:variables
}
