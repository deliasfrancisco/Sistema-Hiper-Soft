package br.com.fatecpp.hiper_soft.model.dao;

import br.com.fatecpp.hiper_soft.model.domain.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DiegoFrancisco
 */
public class VendaDAO implements DAOGenerico<Venda>{

    private static VendaDAO unicaInstancia;//Instância única da classe VendaDAO
    private EntityManager em;//Objeto responsável por gerenciar a conexão com o banco de dados
    
    private VendaDAO() {//Método que estabelece conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaHiperSoftWebPU"); //Retorna os dados do arquivo persistence.xml para estabelecer conexão com BD
        if (em == null) {//Caso nenhuma conexão tenha sido feita ainda, ela é efetivada
            em = emf.createEntityManager();
        }
    }
    
    public static VendaDAO getUnicaInstancia() {//Método que estabelece conexão com o banco de dados
        if(unicaInstancia == null){
            unicaInstancia = new VendaDAO();
        }
        return unicaInstancia;
    }
    
    @Override
    public boolean inserir(Venda entidade) {
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
    public boolean alterar(Venda entidade) {
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
    public boolean excluir(Venda entidade) {
        try{
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            Venda v = em.merge(entidade);//Atualiza o objeto no banco de dados
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
    public List<Venda> consultar(String opcao, String parametro) {
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Venda.findAll");
        } else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Venda.findByVendaCod");
        q.setParameter("vendaCod", parametro);
        } else if (opcao.equals("consultarPorCaixa")){
        q = em.createNamedQuery("Venda.findByCaixaCxCod");
        q.setParameter("caixaCxCod", "%" + parametro + "%");
        } else if (opcao.equals("consultarPorData")){
        q = em.createNamedQuery("Venda.findByDataVen");
        q.setParameter("dataVen", "%" + parametro + "%");
        }
        return q.getResultList();
    }
    
}
