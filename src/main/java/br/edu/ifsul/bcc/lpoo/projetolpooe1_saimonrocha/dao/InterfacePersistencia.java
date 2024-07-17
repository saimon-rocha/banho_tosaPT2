package br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.dao;

/**
 *
 * @author Saimon AS Rocha
 */
public interface InterfacePersistencia {

    public Boolean conexaoAberta();

    public void fecharConexao();

    public Object find(Class c, Object id) throws Exception;

    public void persist(Object o) throws Exception;

    public void remover(Object o) throws Exception;
}
