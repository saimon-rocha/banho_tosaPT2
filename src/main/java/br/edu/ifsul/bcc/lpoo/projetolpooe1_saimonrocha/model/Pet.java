package br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPet;

    private String nome;
    private String raca;

    @ManyToOne
    @JoinColumn(name = "id_pessoa") // Adiciona a referência para a tabela Pessoa
    private Pessoa pessoa;

    @ManyToMany
    @JoinTable(name = "pet_servico", // Nome da tabela de relacionamento
            joinColumns = @JoinColumn(name = "id_pet"),
            inverseJoinColumns = @JoinColumn(name = "id_servico"))
    private List<Servico> servicos = new ArrayList<>();

    // Getters e setters
    public Integer getIdPet() {
        return idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    // Método para calcular o valor total
    public double calcularValorTotal() {
        double total = 0.0;
        for (Servico servico : servicos) {
            total += servico.getValor();
        }
        return total;
    }

    @Override
    public String toString() {
        return nome; // Retorna o nome do pet como representação textual
    }
}
