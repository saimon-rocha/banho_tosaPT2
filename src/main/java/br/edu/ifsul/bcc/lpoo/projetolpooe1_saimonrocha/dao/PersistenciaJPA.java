package br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Saimon AS Rocha
 */
public class PersistenciaJPA {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu_pet");
        entity = factory.createEntityManager();
    }

    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    public void fecharConexao() {
        entity.close();
    }

    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    public void persist(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
    }

    public void remover(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
    }
}
