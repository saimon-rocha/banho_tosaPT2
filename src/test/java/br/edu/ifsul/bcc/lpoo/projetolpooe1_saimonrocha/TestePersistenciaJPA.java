package br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha;

import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.dao.PersistenciaJPA;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pessoa;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pet;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Servico;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste para verificar a persistência usando JPA. Autor: Saimon AS
 * Rocha
 */
public class TestePersistenciaJPA {

    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaJPA() {
    }

    @Before
    public void setUp() {
        jpa.conexaoAberta();
        System.out.println("Conexão estabelecida com o banco de dados via JPA...");
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistenciaJPA() throws Exception {
        // Criar e persistir várias pessoas e pets com serviços diferentes
        cadastrarPessoaEPet(
                "01485974", 
                "Douglas",
                "Belugo", 
                "Pastor Alemao",
                Arrays.asList(Servico.BANHO, Servico.TOSA));
        cadastrarPessoaEPet(
                "01485975",
                "Douglas",
                "Belvedere",
                "Dog Argentino",
                Arrays.asList(Servico.UNHAS, Servico.BANHO));
    }

    private void cadastrarPessoaEPet(String cpf, String nomePessoa, String nomePet, String racaPet, List<Servico> servicos) throws Exception {
        // Criar e persistir uma pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(cpf);
        pessoa.setNome(nomePessoa);

        // Persistir a pessoa primeiro
        jpa.persist(pessoa);

        double valorTotal = 0.0;

        // Iterar sobre os serviços
        for (Servico servico : servicos) {
            // Criar e persistir um pet
            Pet pet = new Pet();
            pet.setNome(nomePet);
            pet.setRaca(racaPet);
            pet.setPessoa(pessoa);
            pet.setServico(servico);
            valorTotal += pet.calcularValorTotal();

            // Persistir o pet para cada serviço
            jpa.persist(pet);
        }

        // Ficha
        System.out.println("====== Ficha Pet ======");
        System.out.println("Mamae ou Papai: " + pessoa.getNome());
        System.out.println("CPF: " + pessoa.getCpf());
        System.out.println("Filhote: " + nomePet); // Ajuste para exibir o nome do pet fora do loop
        System.out.println("Origem: " + racaPet); // Ajuste para exibir a raça do pet fora do loop
        System.out.println("Descricao dos Servicos: " + servicos);
        System.out.println("Valor Total: R$ " + valorTotal);
    }

}
