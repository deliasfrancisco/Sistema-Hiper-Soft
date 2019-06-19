package br.com.fatecpp.hiper_soft.model.dao;

import br.com.fatecpp.hiper_soft.model.domain.ItemCompra;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DiegoFrancisco
 */
public class ItemCompraDAO implements DAOGenerico<ItemCompra>{

    private static ItemCompraDAO unicaInstancia;//Instância única da classe ItemCompraDAO
    private EntityManager em;//Objeto responsável por gerenciar a conexão com o banco de dados
    
    private ItemCompraDAO() {//Método que estabelece conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaHiperSoftWebPU"); //Retorna os dados do arquivo persistence.xml para estabelecer conexão com BD
        if (em == null) {//Caso nenhuma conexão tenha sido feita ainda, ela é efetivada
            em = emf.createEntityManager();
        }
    }
    
    public static ItemCompraDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new ItemCompraDAO();
        }
        return unicaInstancia;
    }
    
    @Override
    public boolean inserir(ItemCompra entidade) {
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
    public boolean alterar(ItemCompra entidade) {
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
    public boolean excluir(ItemCompra entidade) {
        try{
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            ItemCompra ic = em.merge(entidade);//Atualiza o objeto no banco de dados
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
    public List<ItemCompra> consultar(String opcao, String parametro) {
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Cliente.findAll");
        } else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Cliente.findByIdCliente");
        q.setParameter("idCliente", parametro);
        } else if (opcao.equals("consultarPorNome")){
        q = em.createNamedQuery("Cliente.findByNome");
        q.setParameter("nome", "%" + parametro + "%");
        } else if (opcao.equals("consultarPorEmail")){
        q = em.createNamedQuery("Cliente.findByEmail");
        q.setParameter("email", "%" + parametro + "%");
        }
        return q.getResultList();
    }
    
}
