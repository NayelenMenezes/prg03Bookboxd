package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.avaliacao.controller.AvaliacaoController;
import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.listaleitura.controller.ListaLeituraController;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PerfilPublicoDialog extends javax.swing.JDialog {
    
    private final AvaliacaoController avaliacaoController;
    private final ListaLeituraController listaController;
    
    @Autowired
    public PerfilPublicoDialog(AvaliacaoController avaliacaoController, ListaLeituraController listaController) {
        super();
        setModal(true);
        setTitle("Perfil do Usuário");
        this.avaliacaoController = avaliacaoController;
        this.listaController = listaController;
        initComponents();

        tblAvaliacoesPublicas.getColumnModel().getColumn(0).setMinWidth(0);
        tblAvaliacoesPublicas.getColumnModel().getColumn(0).setMaxWidth(0);
        tblAvaliacoesPublicas.getColumnModel().getColumn(0).setWidth(0);

        tblListasPublicas.getColumnModel().getColumn(0).setMinWidth(0);
        tblListasPublicas.getColumnModel().getColumn(0).setMaxWidth(0);
        tblListasPublicas.getColumnModel().getColumn(0).setWidth(0);
    }

    public void mostrarPerfil(java.awt.Component parent, Usuario usuario) {
        lblNomeUsuario.setText(usuario.getPessoa().getNome());
        lblBiografia.setText(usuario.getPessoa().getBiografia() != null
                ? usuario.getPessoa().getBiografia() : "Sem biografia");

        carregarAvaliacoes(usuario.getId());
        carregarListas(usuario.getId());

        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    private void carregarAvaliacoes(Long usuarioId) {
        try {
            List<Avaliacao> avaliacoes = avaliacaoController.findByUsuarioId(usuarioId);
            preencherTabelaAvaliacoes(avaliacoes);
        } catch (RuntimeException e) {
            preencherTabelaAvaliacoes(List.of()); // usuário ainda não avaliou nada
        }
    }
    
    private void preencherTabelaAvaliacoes(List<Avaliacao> avaliacoes) {
        DefaultTableModel modelo = (DefaultTableModel) tblAvaliacoesPublicas.getModel();
        modelo.setRowCount(0);
        for (Avaliacao a : avaliacoes) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getLivro().getTitulo(),
                a.getNota() + " estrelas",
                a.isContemSpoiler() ? "[CONTÉM SPOILER] " + a.getAvaliacao() : a.getAvaliacao()
            });
        }
    }
    
    private void carregarListas(Long usuarioId) {
        try {
            List<ListaLeitura> listas = listaController.findByUsuarioId(usuarioId);
            preencherTabelaListas(listas);
        } catch (RuntimeException e) {
            preencherTabelaListas(List.of());
        }
    }
    
    private void preencherTabelaListas(List<ListaLeitura> listas) {
        DefaultTableModel modelo = (DefaultTableModel) tblListasPublicas.getModel();
        modelo.setRowCount(0);
        for (ListaLeitura l : listas) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getNomeLista(),
                l.getListaLivros().size() + " livro(s)"
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblNomeUsuario = new javax.swing.JLabel();
        lblBiografia = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAvaliacoesPublicas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListasPublicas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNomeUsuario.setText("nome");

        lblBiografia.setText("bio");

        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeUsuario)
                    .addComponent(lblBiografia, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblNomeUsuario)
                .addGap(18, 18, 18)
                .addComponent(lblBiografia, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("PERFIL", jPanel1);

        tblAvaliacoesPublicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Livro", "Nota", "Texto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAvaliacoesPublicas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("AVALIAÇÕES", jPanel2);

        tblListasPublicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nome", "Qtd. LIvros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListasPublicas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("LISTAS", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBiografia;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JTable tblAvaliacoesPublicas;
    private javax.swing.JTable tblListasPublicas;
    // End of variables declaration//GEN-END:variables
}
