package br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pessoas")
@NamedQueries({
    @NamedQuery(name = "Pessoa.orderById", query = "SELECT p FROM Pessoa p ORDER BY p.idPessoa")
})
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pet> pets = new ArrayList<>();

    // Métodos getters e setters
    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setPessoa(this); // Associa o pet à pessoa
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
        pet.setPessoa(null); // Desassocia o pet da pessoa
    }
}
