package br.com.fatecpp.hiper_soft.model.dao;

import br.com.fatecpp.hiper_soft.model.domain.Compra;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DiegoFrancisco
 */
public class CompraDAO implements DAOGenerico <Compra>{

    private static CompraDAO unicaInstancia;//Instância única da classe CompraDAO
    private EntityManager em;//Objeto responsável por gerenciar a conexão com o banco de dados
    
    private CompraDAO() {//Método que estabelece conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaHiperSoftWebPU"); //Retorna os dados do arquivo persistence.xml para estabelecer conexão com BD
        if (em == null) {//Caso nenhuma conexão tenha sido feita ainda, ela é efetivada
            em = emf.createEntityManager();
        }
    }
    
    public static CompraDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new CompraDAO();
        }
        return unicaInstancia;
    }
    
    @Override
    public boolean inserir(Compra entidade) {
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
    public boolean alterar(Compra entidade) {
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
    public boolean excluir(Compra entidade) {
        try{
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            Compra c = em.merge(entidade);//Atualiza o objeto no banco de dados
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
    public List<Compra> consultar(String opcao, String parametro) {
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Compra.findAll");
        } else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Compra.findByCodCom");
        q.setParameter("codCom", parametro);
        } else if (opcao.equals("consultarPorFornecedor")){
        q = em.createNamedQuery("Compra.findByFornecedorCodFor");
        q.setParameter("fornecedorCodFor", "%" + parametro + "%");
        } else if (opcao.equals("consultarPorData")){
        q = em.createNamedQuery("Compra.findByDataCom");
        q.setParameter("dataCom", "%" + parametro + "%");
        }
        return q.getResultList();
    }
    
}
