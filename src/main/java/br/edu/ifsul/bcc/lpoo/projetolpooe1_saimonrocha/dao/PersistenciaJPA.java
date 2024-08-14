package br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.dao;

import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pessoa;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Pet;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.PetServico;
import br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model.Servico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Classe para gerenciar a persistência de dados usando JPA. Autor: Saimon AS
 * Rocha
 */
public class PersistenciaJPA {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public PersistenciaJPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu_pet");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Boolean conexaoAberta() {
        return entityManager.isOpen();
    }

    public void abrirConexao() {
        if (!conexaoAberta()) {
            entityManager = entityManagerFactory.createEntityManager();
        }
    }

    public void fecharConexao() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    public Object find(Class<?> c, Object id) throws Exception {
        return entityManager.find(c, id);
    }

    public void persist(Object o) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(o);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public void remover(Object o) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Object managedObject = entityManager.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            entityManager.remove(managedObject); // Remove o objeto gerenciado
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = null;
        try {
            if (!conexaoAberta()) {
                abrirConexao();
            }
            entityManager.getTransaction().begin();
            pessoas = entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return pessoas;
    }

    public void merge(Object obj) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(obj);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public List<Pet> getPet(Pessoa pessoa) throws Exception {
        if (!conexaoAberta()) {
            abrirConexao(); // Garante que a conexão esteja aberta
        }
        Query query = entityManager.createQuery("SELECT p FROM Pet p WHERE p.pessoa = :pessoa", Pet.class);
        query.setParameter("pessoa", pessoa);
        return query.getResultList();
    }

    public List<Pet> getPets() throws Exception {
        if (!conexaoAberta()) {
            abrirConexao(); // Garante que a conexão esteja aberta
        }
        // Consulta para obter todos os pets que têm uma pessoa associada
        Query query = entityManager.createQuery(
                "SELECT p FROM Pet p WHERE p.pessoa IS NOT NULL", Pet.class);
        return query.getResultList();
    }

    public List<Servico> getServico() throws Exception {
        if (!conexaoAberta()) {
            abrirConexao(); // Garante que a conexão esteja aberta
        }
        TypedQuery<Servico> query = entityManager.createQuery(
                "SELECT s FROM Servico s", Servico.class);
        return query.getResultList();
    }

    public void salvarPetServico(PetServico petServico) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            // Adicione a lógica para salvar a associação PetServico
            entityManager.persist(petServico);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Servico buscarServicoPorNome(String nome) throws Exception {
        if (!conexaoAberta()) {
            abrirConexao(); // Garante que a conexão esteja aberta
        }
        TypedQuery<Servico> query = entityManager.createQuery(
                "SELECT s FROM Servico s WHERE s.nome = :nome", Servico.class);
        query.setParameter("nome", nome);
        List<Servico> servicos = query.getResultList();
        return servicos.isEmpty() ? null : servicos.get(0); // Retorna o primeiro resultado ou null se não encontrado
    }

    public void atualizarPetServico(PetServico petServico) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(petServico);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
}
