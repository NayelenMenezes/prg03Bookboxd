package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.livro.controller.LivroController;
import br.com.ifba.bookboxd.livro.entity.Livro;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//telinha que busca livros
@Component
public class BuscaLivroDialog extends javax.swing.JDialog {
    
    private final LivroController livroController;
    private Livro livroSelecionado;
    
    @Autowired
    public BuscaLivroDialog(LivroController livroController) {
        super();
        setModal(true);
        setTitle("Selecionar Livro");
        this.livroController = livroController;
        initComponents();

        tblLivrosBusca.getColumnModel().getColumn(0).setMinWidth(0);
        tblLivrosBusca.getColumnModel().getColumn(0).setMaxWidth(0);
        tblLivrosBusca.getColumnModel().getColumn(0).setWidth(0);
    }

    public Livro mostrarESelecionar(java.awt.Component parent) {
        this.livroSelecionado = null;
        txtBuscarLivro.setText("");
        carregarTodos();
        setLocationRelativeTo(parent);
        setVisible(true);
        return livroSelecionado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscarLivro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivrosBusca = new javax.swing.JTable();
        btnBuscarLivro = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnCancelarBusca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblLivrosBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Título", "Gênero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLivrosBusca);

        btnBuscarLivro.setText("BUSCAR");
        btnBuscarLivro.addActionListener(this::btnBuscarLivroActionPerformed);

        btnSelecionar.setText("SELECIONAR");
        btnSelecionar.addActionListener(this::btnSelecionarActionPerformed);

        btnCancelarBusca.setText("CANCELAR");
        btnCancelarBusca.addActionListener(this::btnCancelarBuscaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnBuscarLivro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnCancelarBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelecionar)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLivro))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnCancelarBusca))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLivroActionPerformed
        String termo = txtBuscarLivro.getText().trim();
        if(StringUtil.isEmpty(termo)){
            carregarTodos();
            return;
        }
        try{
            List<Livro> resultados = livroController.findByTitulo(termo);
            preencherTabela(resultados);
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }//GEN-LAST:event_btnBuscarLivroActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        int linha = tblLivrosBusca.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um livro na tabela.",
                    "Nenhum livro selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblLivrosBusca.getModel();
        Long id = (Long) modelo.getValueAt(linha, 0);
        
        try{
            this.livroSelecionado = livroController.findById(id).orElse(null);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnCancelarBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBuscaActionPerformed
        this.livroSelecionado = null;
        dispose();
    }//GEN-LAST:event_btnCancelarBuscaActionPerformed

    private void carregarTodos() {
        try {
            preencherTabela(livroController.findAll());
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }

    private void preencherTabela(List<Livro> livros) {
        DefaultTableModel modelo = (DefaultTableModel) tblLivrosBusca.getModel();
        modelo.setRowCount(0);
        for (Livro l : livros) {
            modelo.addRow(new Object[]{l.getId(), l.getTitulo(), l.getGenero()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarLivro;
    private javax.swing.JButton btnCancelarBusca;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLivrosBusca;
    private javax.swing.JTextField txtBuscarLivro;
    // End of variables declaration//GEN-END:variables
}
