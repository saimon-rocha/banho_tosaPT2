package br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha;

import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.dao.PersistenciaJPA;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pessoa;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pet;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Servico;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.ServicoEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestePersistenciaJPA {

    private PersistenciaJPA jpa;

    @Before
    public void setUp() {
        jpa = new PersistenciaJPA();
        jpa.conexaoAberta();
        System.out.println("Conexão estabelecida com o banco de dados via JPA...");
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testCadastrarPessoaEPet() {
        try {
            cadastrarPessoaEPet("12345678900", "João da Silva", "Rex", "Labrador",
                    Arrays.asList(ServicoEnum.BANHO, ServicoEnum.TOSA));
        } catch (Exception e) {
            e.printStackTrace();
            // Fail the test if an exception occurs
            assert false;
        }
    }

    private void cadastrarPessoaEPet(String cpf, String nomePessoa, String nomePet, String racaPet, List<ServicoEnum> servicosEnum) throws Exception {
        // Criar e persistir uma pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(cpf);
        pessoa.setNome(nomePessoa);
        jpa.persist(pessoa);

        // Criar um pet
        Pet pet = new Pet();
        pet.setNome(nomePet);
        pet.setRaca(racaPet);
        pet.setPessoa(pessoa);

        double valorTotal = 0.0;

        // Iterar sobre os serviços
        for (ServicoEnum servicoEnum : servicosEnum) {
            // Buscar o serviço correspondente no banco de dados
            Servico servico = jpa.buscarServicoPorNome(servicoEnum.name());

            if (servico == null) {
                // Caso o serviço não exista, criar e persistir
                servico = new Servico(servicoEnum.name(), servicoEnum.getValor());
                jpa.persist(servico);
            }

            // Associar o serviço ao pet
            pet.getServicos().add(servico);
            valorTotal += servico.getValor(); // Adicionar o valor do serviço ao total
        }

        // Persistir o pet uma única vez após adicionar todos os serviços
        jpa.persist(pet);

        // Ficha
        System.out.println("====== Ficha Pet ======");
        System.out.println("Mamae ou Papai: " + pessoa.getNome());
        System.out.println("CPF: " + pessoa.getCpf());
        System.out.println("Filhote: " + nomePet);
        System.out.println("Origem: " + racaPet);
        System.out.println("Descricao dos Servicos: " + pet.getServicos());
        System.out.println("Valor Total: R$ " + valorTotal);
    }
}
