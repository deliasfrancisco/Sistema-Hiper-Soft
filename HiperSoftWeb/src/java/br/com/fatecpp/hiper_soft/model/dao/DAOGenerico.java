package br.com.fatecpp.hiper_soft.model.dao;

import java.util.List;

/**
 *
 * @author DiegoFrancisco
 */
public interface DAOGenerico <E>{
    public boolean inserir(E entidade);
    public boolean alterar(E entidade);
    public boolean excluir(E entidade);
    public List<E> consultar(String opcao, String parametro);
}
