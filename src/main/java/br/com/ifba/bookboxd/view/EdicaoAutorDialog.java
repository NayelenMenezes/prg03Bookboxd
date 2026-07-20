package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.autor.controller.AutorController;
import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Telinha para fazer edições em autor
@Component
public class EdicaoAutorDialog extends javax.swing.JDialog {
    
    private final AutorController autorController;
    private Autor autorOriginal;

    @Autowired
    public EdicaoAutorDialog(AutorController autorController) {
        super();
        setModal(true);
        setTitle("Editar Autor");
        this.autorController = autorController;
        initComponents();
        
        txtBiografia.setLineWrap(true);
        txtBiografia.setWrapStyleWord(true);
    }

    public void prepararParaEdicao(java.awt.Frame parent, Autor autor) {
        this.autorOriginal = autor;
        txtNome.setText(autor.getPessoa().getNome());
        txtBiografia.setText(autor.getPessoa().getBiografia());
        txtNacionalidade.setText(autor.getNacionalidade());
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBiografia = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvarEdicaoAutor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBiografia = new javax.swing.JTextArea();
        txtNacionalidade = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblNacionalidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblBiografia.setText("BIOGRAFIA");

        btnSalvarEdicaoAutor.setText("SALVAR");
        btnSalvarEdicaoAutor.addActionListener(this::btnSalvarEdicaoAutorActionPerformed);

        txtBiografia.setColumns(20);
        txtBiografia.setRows(5);
        jScrollPane1.setViewportView(txtBiografia);

        lblNome.setText("NOME");

        lblNacionalidade.setText("NACIONALIDADE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(btnSalvarEdicaoAutor)
                .addGap(148, 148, 148))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBiografia)
                            .addComponent(lblNacionalidade))
                        .addGap(1, 1, 1)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNacionalidade, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNacionalidade))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblBiografia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(btnSalvarEdicaoAutor)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarEdicaoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEdicaoAutorActionPerformed
        if (StringUtil.isEmpty(txtNome.getText())) {
            JOptionPane.showMessageDialog(this, "O nome é obrigatório.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (StringUtil.isEmpty(txtNacionalidade.getText())) {
            JOptionPane.showMessageDialog(this, "A nacionalidade é obrigatória.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        autorOriginal.getPessoa().setNome(txtNome.getText().trim());
        autorOriginal.getPessoa().setBiografia(txtBiografia.getText().trim());
        autorOriginal.setNacionalidade(txtNacionalidade.getText().trim());
        
        try {
            autorController.update(autorOriginal);
            JOptionPane.showMessageDialog(this, "Autor atualizado com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao atualizar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarEdicaoAutorActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvarEdicaoAutor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBiografia;
    private javax.swing.JLabel lblNacionalidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextArea txtBiografia;
    private javax.swing.JTextField txtNacionalidade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
