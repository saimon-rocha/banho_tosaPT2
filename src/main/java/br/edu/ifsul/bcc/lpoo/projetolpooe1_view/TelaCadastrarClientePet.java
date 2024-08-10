/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.edu.ifsul.bcc.lpoo.projetolpooe1_view;

import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.dao.PersistenciaJPA;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pessoa;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Saimon AS Rocha
 */
public class TelaCadastrarClientePet extends javax.swing.JDialog {

    private Pessoa pessoa;
    private Pet pet;
    private PersistenciaJPA jpa;
    private Cliente telaPrincipal;

    /**
     * Creates new form TelaCadastrarClientePet
     */
    public TelaCadastrarClientePet(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.telaPrincipal = telaPrincipal;
    }

    // Novo construtor com Pessoa e PersistenciaJPA
    public TelaCadastrarClientePet(java.awt.Frame parent, boolean modal, Pessoa cliente, PersistenciaJPA jpa) throws Exception {
        super(parent, modal);
        this.pessoa = cliente;
        this.jpa = jpa;
        initComponents();
        preencherFormulario();
        listaPet();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblNome = new javax.swing.JTextField();
        lblCPF = new javax.swing.JTextField();
        lblPet = new javax.swing.JTextField();
        lblRaca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CPF");

        jLabel2.setText("NOME");

        jLabel3.setText("PET");

        jLabel4.setText("RAÇA");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPet, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lblPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void preencherFormulario() {
        if (pessoa != null) {
            lblNome.setText(pessoa.getNome());
            lblCPF.setText(pessoa.getCpf());

            if (pessoa.getPets() != null && !pessoa.getPets().isEmpty()) {
                Pet primeiroPet = pessoa.getPets().get(0); // Pega o primeiro pet ou altere a lógica conforme necessário
                lblPet.setText(primeiroPet.getNome());
                lblRaca.setText(primeiroPet.getRaca());
            }
        }
    }

    private void listaPet() throws Exception {
        if (jpa == null) {
            throw new IllegalStateException("PersistenciaJPA não está inicializada.");
        }
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não pode ser null.");
        }
        List<Pet> lista = jpa.getPet(pessoa);
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        PersistenciaJPA jpa = new PersistenciaJPA();

        try {
            jpa.conexaoAberta();

            if (pessoa == null) {
                // Criando nova pessoa
                pessoa = new Pessoa();
                pessoa.setNome(lblNome.getText());
                pessoa.setCpf(lblCPF.getText());

                // Adicionando novos Pets
                Pet pet = new Pet();
                pet.setNome(lblPet.getText());
                pet.setRaca(lblRaca.getText());
                pet.setPessoa(pessoa); // Associando o Pet à Pessoa

                // Adicionando o Pet à lista de Pets da Pessoa
                pessoa.getPets().add(pet);

                // Persistindo a nova pessoa e seus Pets
                jpa.persist(pessoa);
                JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!");
            } else {
                // Edição da pessoa existente
                Pessoa pessoaEdt = (Pessoa) jpa.find(Pessoa.class, pessoa.getIdPessoa());
                pessoaEdt.setNome(lblNome.getText());
                pessoaEdt.setCpf(lblCPF.getText());

                // Atualizando os Pets da Pessoa
                // Exemplo: Atualizando apenas um Pet para simplificar
                if (pessoaEdt.getPets() != null && !pessoaEdt.getPets().isEmpty()) {
                    Pet petEdt = pessoaEdt.getPets().get(0); // Supondo que há pelo menos um Pet
                    petEdt.setNome(lblPet.getText());
                    petEdt.setRaca(lblRaca.getText());
                    petEdt.setPessoa(pessoaEdt); // Atualizando a associação
                }

                jpa.merge(pessoaEdt); // Atualiza a Pessoa existente
                JOptionPane.showMessageDialog(this, "Pessoa editada com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar pessoa: " + e.getMessage());
            e.printStackTrace();
        } finally {
            jpa.fecharConexao();
            dispose();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastrarClientePet.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarClientePet.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarClientePet.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarClientePet.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastrarClientePet dialog = new TelaCadastrarClientePet(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField lblCPF;
    private javax.swing.JTextField lblNome;
    private javax.swing.JTextField lblPet;
    private javax.swing.JTextField lblRaca;
    // End of variables declaration//GEN-END:variables
}
