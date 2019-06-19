package br.com.fatecpp.hiper_soft.model.dao;

import br.com.fatecpp.hiper_soft.model.domain.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DiegoFrancisco
 */
public class FornecedorDAO implements DAOGenerico<Fornecedor>{

    private static FornecedorDAO unicaInstancia;//Instância única da classe FornecedorDAO
    private EntityManager em;//Objeto responsável por gerenciar a conexão com o banco de dados
    
    private FornecedorDAO() {//Método que estabelece conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaHiperSoftWebPU"); //Retorna os dados do arquivo persistence.xml para estabelecer conexão com BD
        if (em == null) {//Caso nenhuma conexão tenha sido feita ainda, ela é efetivada
            em = emf.createEntityManager();
        }
    }
    public static FornecedorDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new FornecedorDAO();
        }
        return unicaInstancia;
    }
    
    @Override
    public boolean inserir(Fornecedor entidade) {
        try {
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            em.persist(entidade);//Salva o objeto no banco de dados
            em.getTransaction().commit();//Confirma (atualiza) a inserção dos dados
            return true;
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());//Caso acontece algum erro, ele é exibido na tela
            em.getTransaction().rollback();//Cancela a transação que foi iniciada
            return false;
        }
    }

    @Override
    public boolean alterar(Fornecedor entidade) {
        try {
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            em.merge(entidade);//Atualiza o objeto no banco de dados
            em.getTransaction().commit(); //Confirma (atualiza) a inserção dos dados
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//Caso acontece algum erro, ele é exibido na tela
            em.getTransaction().rollback();//Cancela a transação que foi iniciada
            return false;
        }
    }

    @Override
    public boolean excluir(Fornecedor entidade) {
        try{
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            em.remove(entidade);//Exclui o objeto no banco de dados
            em.merge(entidade);//Atualiza o objeto no banco de dados
            em.getTransaction().commit();//Confirma (atualiza) a inserção dos dados
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());//Caso acontece algum erro, ele é exibido na tela
            em.getTransaction().rollback();//Cancela a transação que foi iniciada
            return false;
        }
    }

    @Override
    public List<Fornecedor> consultar(String opcao, String parametro) {
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Fornecedor.findAll");
        } else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Fornecedor.findByCodFor");
        q.setParameter("codFor", parametro);
        } else if (opcao.equals("consultarPorNome")){
        q = em.createNamedQuery("Fornecedor.findByNomeFor");
        q.setParameter("nomeFor", "%" + parametro + "%");
        } else if (opcao.equals("consultarPorCnpj")){
        q = em.createNamedQuery("Fornecedor.findByCnpjFor");
        q.setParameter("cnpjFor", "%" + parametro + "%");
        }
        return q.getResultList();
    }
    
}
