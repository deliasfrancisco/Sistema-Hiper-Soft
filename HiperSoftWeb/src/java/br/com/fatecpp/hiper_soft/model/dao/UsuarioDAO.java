package br.com.fatecpp.hiper_soft.model.dao;

import br.com.fatecpp.hiper_soft.model.domain.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DiegoFrancisco
 */
public class UsuarioDAO implements DAOGenerico<Usuario>{

    private static UsuarioDAO unicaInstancia;//Instância única da classe UsuarioDAO
    private EntityManager em;//Objeto responsável por gerenciar a conexão com o banco de dados
    boolean resultado;
    
    private UsuarioDAO() {//Método que estabelece conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaHiperSoftWebPU"); //Retorna os dados do arquivo persistence.xml para estabelecer conexão com BD
        if (em == null) {//Caso nenhuma conexão tenha sido feita ainda, ela é efetivada
            em = emf.createEntityManager();
        }
    }
    
    public static UsuarioDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new UsuarioDAO();
        }
        return unicaInstancia;
    }
    
    @Override
    public boolean inserir(Usuario usuario) {
        try {
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            em.persist(usuario);//Salva o objeto no banco de dados
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
    public boolean alterar(Usuario usuario) {
        try {
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            em.merge(usuario);//Atualiza o objeto no banco de dados
            em.getTransaction().commit(); //Confirma (atualiza) a inserção dos dados
            return true;
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());//Caso acontece algum erro, ele é exibido na tela
            em.getTransaction().rollback();//Cancela a transação que foi iniciada
            return false;
        }
    }

    @Override
    public boolean excluir(Usuario usurio) {
        try{
            em.getTransaction().begin();//Inicia uma transação com o banco de dados
            Usuario u = em.merge(usurio);//Atualiza o objeto no banco de dados
            em.remove(usurio);//Exclui o objeto no banco de dados
            em.merge(usurio);//Atualiza o objeto no banco de dados
            em.getTransaction().commit();//Confirma (atualiza) a inserção dos dados
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());//Caso acontece algum erro, ele é exibido na tela
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<Usuario> consultar(String opcao, String parametro) {
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Usuario.findAll");
        } 
        else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Usuario.findByUsuCod");
        q.setParameter("usuCod", Integer.parseInt(parametro));
        } 
        else if (opcao.equals("consultarPorNome")){
        q = em.createNamedQuery("Usuario.findByUsuNome");
        q.setParameter("usuNome", "%" + parametro + "%");
        }
        else if (opcao.equals("consultarPorUsername")){
        q = em.createNamedQuery("Usuario.findByUsuUsername");
        q.setParameter("usuUsername", "%" + parametro + "%");
        }
        return q.getResultList();
    }
 
    public boolean consultaLoginUsernameSenha(String username, String senha) {
        Query q = null;
        
        if(username != null && senha != null){
            q = em.createNamedQuery("Usuario.findByUsernameSenha");
            q.setParameter("usuUsername","%" + username + "%");
            q.setParameter("usuSenha", "%" + senha + "%");

            resultado = (q.getResultList().size() > 0);
            return resultado = true;
        }
        else{
            return resultado = false; 
        }
    }
}
