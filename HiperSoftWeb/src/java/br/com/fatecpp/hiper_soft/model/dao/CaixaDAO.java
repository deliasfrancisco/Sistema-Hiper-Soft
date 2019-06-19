package br.com.fatecpp.hiper_soft.model.dao;

import br.com.fatecpp.hiper_soft.model.domain.Caixa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DiegoFrancisco
 */
public class CaixaDAO implements DAOGenerico<Caixa>{

     private static CaixaDAO unicaInstancia;//Instância única da classe CaixaDAO
    private EntityManager em;//Objeto responsável por gerenciar a conexão com o banco de dados
    
    private CaixaDAO() {//Método que estabelece conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaHiperSoftWebPU"); //Retorna os dados do arquivo persistence.xml para estabelecer conexão com BD
        if (em == null) {//Caso nenhuma conexão tenha sido feita ainda, ela é efetivada
            em = emf.createEntityManager();
        }
    }
    
    public static CaixaDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new CaixaDAO();
        }
        return unicaInstancia;
    }
    
    @Override
    public boolean inserir(Caixa entidade) {
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
    public boolean alterar(Caixa entidade) {
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
    public boolean excluir(Caixa entidade) {
        try{
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            Caixa c = em.merge(entidade);//Atualiza o objeto no banco de dados
            em.remove(entidade);//Exclui o objeto no banco de dados
            em.getTransaction().commit();//Confirma (atualiza) a inserção dos dados
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());//Caso acontece algum erro, ele é exibido na tela
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<Caixa> consultar(String opcao, String parametro) {
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Caixa.findAll");
        } else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Caixa.findByCxCod");
        q.setParameter("cxCod", parametro);
        } else if (opcao.equals("consultarPorUsuario")){
        q = em.createNamedQuery("Caixa.findByCodUsu");
        q.setParameter("CodUsu", "%" + parametro + "%");
        }
        return q.getResultList();
    }

    
}
