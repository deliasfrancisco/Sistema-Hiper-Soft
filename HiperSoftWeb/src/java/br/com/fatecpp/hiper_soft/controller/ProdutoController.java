package br.com.fatecpp.hiper_soft.controller;

import br.com.fatecpp.hiper_soft.model.dao.ProdutoDAO;
import br.com.fatecpp.hiper_soft.model.domain.Produto;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author luan_
 */
public class ProdutoController {
    
    private static ProdutoController unicaInstancia;
        
    public static ProdutoController getUnicaInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new ProdutoController();
        } 
        return unicaInstancia;
    }
        
    public boolean inserir(Produto produto) {
        try {
            return ProdutoDAO.getUnicaInstancia().inserir(produto);
        } catch(Exception ex) {
            return false;
        }
    }

    public boolean alterar(Produto produto) {
          try {
            return ProdutoDAO.getUnicaInstancia().alterar(produto);
        } catch(Exception ex) {
            return false;
        }
    }

    public boolean excluir(Produto produto) {
          try {
            return ProdutoDAO.getUnicaInstancia().excluir(produto);
        } catch(Exception ex) {
            return false;
        }
    }

    public List<Produto> consultar(String opcao, String parametro) {
      
        List<Produto> resultado = null;
        
        switch (opcao) {
            case "":
                resultado = ProdutoDAO.getUnicaInstancia().consultar("consultarTodos", "");
                break;
            case "Id":
                resultado = ProdutoDAO.getUnicaInstancia().consultar("consultarPorId", parametro);
                break;
            case "Nome":
                resultado = ProdutoDAO.getUnicaInstancia().consultar("consultarPorNome", parametro);
                break;
            case "Email":
                resultado = ProdutoDAO.getUnicaInstancia().consultar("consultarPorEmail", parametro);
                break;
            default:
                break;
        }

        return resultado;
    }
    
}
