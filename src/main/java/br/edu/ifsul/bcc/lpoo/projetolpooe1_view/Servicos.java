package br.edu.ifsul.bcc.lpoo.projetolpooe1_view;

import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.dao.PersistenciaJPA;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pessoa;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pet;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.PetServico;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Servico;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Saimon AS Rocha
 */
public class Servicos extends javax.swing.JDialog {

    private Servico servico;
    private Pessoa pessoa;
    private Pet pet;
    private PetServico petServico;
    private PersistenciaJPA jpa;

    /**
     * Creates new form Servico
     */
    public Servicos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.petServico = petServico;
        jpa = new PersistenciaJPA();
        listarServico();
        listarPet();
        preencheCampos();
    }

    private void preencheCampos() {
        if (petServico != null) {
            cmbPet.setSelectedItem(petServico.getPet());
            cmbServico.setSelectedItem(petServico.getServico());
        }
    }

    //Preenche no campo da listagem de professores
    public void listarServico() {
        cmbServico.removeAllItems();
        PersistenciaJPA jpa = new PersistenciaJPA();
        List<Servico> lista = null; // Aqui estamos usando a classe Servicos do modelo
        try {
            jpa.abrirConexao();
            lista = jpa.getServico(); // Usando o objeto correto
        } catch (Exception e) {
            e.printStackTrace(); // Imprime a exceção
        } finally {
            jpa.fecharConexao();
        }

        if (lista != null) {
            for (Servico s : lista) {
                cmbServico.addItem(s); // Adicionando ao combo box
            }
        }
    }

    //Preenche no campo da listagem de professores
    public void listarPet() {
        cmbPet.removeAllItems();
        PersistenciaJPA jpa = new PersistenciaJPA();
        List<Pet> lista = null;

        try {
            jpa.abrirConexao();
            lista = jpa.getPets(); // 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jpa.fecharConexao();
        }

        if (lista != null) {
            for (Pet p : lista) {
                cmbPet.addItem(p); // Adicionando o objeto Pet ao combo box
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrar = new javax.swing.JButton();
        cmbPet = new javax.swing.JComboBox<>();
        cmbServico = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCadastrar.setText("Salvar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPet, 0, 155, Short.MAX_VALUE)
                            .addComponent(cmbServico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnCadastrar)
                        .addGap(55, 55, 55)
                        .addComponent(jButton1)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(cmbPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(cmbServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(jButton1))
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Pet selectedPet = (Pet) cmbPet.getSelectedItem();
        Servico selectedServico = (Servico) cmbServico.getSelectedItem();

        if (selectedPet != null && selectedServico != null) {
            petServico = new PetServico(selectedPet, selectedServico);

            PersistenciaJPA jpa = new PersistenciaJPA();
            try {
                jpa.abrirConexao();
                jpa.salvarPetServico(petServico); // Ajuste para salvar no banco de dados
                JOptionPane.showMessageDialog(this, "Serviço Vinculado com Sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao vincular serviço: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                jpa.fecharConexao();
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum pet ou serviço selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Servicos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servicos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servicos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servicos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Servicos dialog = new Servicos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<Pet> cmbPet;
    private javax.swing.JComboBox<Servico> cmbServico;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
