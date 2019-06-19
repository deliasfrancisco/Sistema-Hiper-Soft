package br.com.fatecpp.hiper_soft.model.dao;

import br.com.fatecpp.hiper_soft.model.domain.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DiegoFrancisco
 */
public class ProdutoDAO implements DAOGenerico<Produto>{

    private static ProdutoDAO unicaInstancia;//Instância única da classe ProdutoDAO
    private EntityManager em;//Objeto responsável por gerenciar a conexão com o banco de dados
    
    private ProdutoDAO() {//Método que estabelece conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaHiperSoftWebPU"); //Retorna os dados do arquivo persistence.xml para estabelecer conexão com BD
        if (em == null) {//Caso nenhuma conexão tenha sido feita ainda, ela é efetivada
            em = emf.createEntityManager();
        }
    }
    
    public static ProdutoDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new ProdutoDAO();
        }
        return unicaInstancia;
    }
    
    @Override
    public boolean inserir(Produto entidade) {
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
    public boolean alterar(Produto entidade) {
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
    public boolean excluir(Produto entidade) {
        try{
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            Produto p = em.merge(entidade);//Atualiza o objeto no banco de dados
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
    public List<Produto> consultar(String opcao, String parametro) {
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Produto.findAll");
        } else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Produto.findByCodProd");
        q.setParameter("codProd", parametro);
        } else if (opcao.equals("consultarPorNome")){
        q = em.createNamedQuery("Produto.findByNomeProd");
        q.setParameter("nomeProd", "%" + parametro + "%");
        } else if (opcao.equals("consultarPorSetor")){
        q = em.createNamedQuery("Produto.findBySetorProd");
        q.setParameter("setorProd", "%" + parametro + "%");
        }
        return q.getResultList();
    }
}
