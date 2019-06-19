package br.com.fatecpp.hiper_soft.model.dao;

import br.com.fatecpp.hiper_soft.model.domain.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DiegoFrancisco
 */
public class ClienteDAO implements DAOGenerico<Cliente>{

    private static ClienteDAO unicaInstancia;//Instância única da classe ClienteDAO
    private EntityManager em;//Objeto responsável por gerenciar a conexão com o banco de dados
    
    private ClienteDAO() {//Método que estabelece conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaHiperSoftWebPU"); //Retorna os dados do arquivo persistence.xml para estabelecer conexão com BD
        if (em == null) {//Caso nenhuma conexão tenha sido feita ainda, ela é efetivada
            em = emf.createEntityManager();
        }
    }
    
    public static ClienteDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new ClienteDAO();
        }
        return unicaInstancia;
    }

    @Override
    public boolean inserir(Cliente entidade) {
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
    public boolean alterar(Cliente entidade) {
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
    public boolean excluir(Cliente entidade) {
        try{
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            Cliente c = em.find(Cliente.class, entidade.getCodCli());//Atualiza o objeto no banco de dados
            em.remove(c);//Exclui o objeto no banco de dados
            em.getTransaction().commit();//Confirma (atualiza) a inserção dos dados
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());//Caso acontece algum erro, ele é exibido na tela
            em.getTransaction().rollback();//Cancela a transação que foi iniciada
            return false;
        }
    }

    @Override
    public List<Cliente> consultar(String opcao, String parametro) {//A variável opcao foi criada apenas para poder diferenciar qual tipo de consulta queremos fazer A variável q armazena o resultado da consulta
        
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Cliente.findAll");
        } else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Cliente.findByCodCli");
        q.setParameter("codCli", parametro);
        } else if (opcao.equals("consultarPorNome")){
        q = em.createNamedQuery("Cliente.findByNome");
        q.setParameter("nome", "%" + parametro + "%");
        } else if (opcao.equals("consultarPorEndereco")){
        q = em.createNamedQuery("Cliente.findByEndereco");
        q.setParameter("endereco", "%" + parametro + "%");
        }else if (opcao.equals("consultarPorCidade")){
        q = em.createNamedQuery("Cliente.findByCidade");
        q.setParameter("cidade", "%" + parametro + "%");
        }
        return q.getResultList();

    }

}
