package br.com.fatecpp.hiper_soft.controller;

import br.com.fatecpp.hiper_soft.model.dao.UsuarioDAO;
import br.com.fatecpp.hiper_soft.model.domain.Usuario;
import java.io.Serializable;
import java.util.List;

public class UsuarioController {
    private static UsuarioController unicaInstancia;

    public static UsuarioController getUnicaInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new UsuarioController();
        } 
        return unicaInstancia;
    }

    public boolean inserir(Usuario usuario) {
        try {
            return UsuarioDAO.getUnicaInstancia().inserir(usuario);
        } catch(Exception ex) {
            return false;
        }
    }

    public boolean alterar(Usuario usuario) {
          try {
            return UsuarioDAO.getUnicaInstancia().alterar(usuario);
        } catch(Exception ex) {
            return false;
        }
    }

    public boolean excluir(Usuario usuario) {
          try {
            return UsuarioDAO.getUnicaInstancia().excluir(usuario);
        } catch(Exception ex) {
            return false;
        }
    }

    public List<Usuario> consultar(String opcao, String parametro) {

        List<Usuario> resultado = null;
        Usuario username = null;

        switch (opcao) {
            case "":
                resultado = UsuarioDAO.getUnicaInstancia().consultar("consultarTodos", "");
                break;
            case "Id":
                resultado = UsuarioDAO.getUnicaInstancia().consultar("consultarPorId", parametro);
                break;
            case "Nome":
                resultado = UsuarioDAO.getUnicaInstancia().consultar("consultarPorNome", parametro);
                break;
            case "Username":
                resultado = UsuarioDAO.getUnicaInstancia().consultar("findByUsuUsername", parametro);
                break;
            default:
                break;
        }

        return resultado;
    }
    
    public boolean consultaLoginUsernameSenha(String username, String senha) {
        
        return UsuarioDAO.getUnicaInstancia().consultaLoginUsernameSenha(username, senha);
    }

    
        
}
