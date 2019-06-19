package br.com.fatecpp.hiper_soft.controller;

import br.com.fatecpp.hiper_soft.model.dao.FornecedorDAO;
import br.com.fatecpp.hiper_soft.model.domain.Fornecedor;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Diego Francisco
 */
public class FornecedorController {
    private static FornecedorController unicaInstancia;
        
    public static FornecedorController getUnicaInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new FornecedorController();
        } 
        return unicaInstancia;
    }
        
    public boolean inserir(Fornecedor fornecedor) {
        try {
            return FornecedorDAO.getUnicaInstancia().inserir(fornecedor);
        } catch(Exception ex) {
            return false;
        }
    }

    public boolean alterar(Fornecedor fornecedor) {
          try {
            return FornecedorDAO.getUnicaInstancia().alterar(fornecedor);
        } catch(Exception ex) {
            return false;
        }
    }

    public boolean excluir(Fornecedor fornecedor) {
          try {
            return FornecedorDAO.getUnicaInstancia().excluir(fornecedor);
        } catch(Exception ex) {
            return false;
        }
    }

    public List<Fornecedor> consultar(String opcao, String parametro) {
      
        List<Fornecedor> resultado = null;
        
        switch (opcao) {
            case "":
                resultado = FornecedorDAO.getUnicaInstancia().consultar("consultarTodos", "");
                break;
            case "Id":
                resultado = FornecedorDAO.getUnicaInstancia().consultar("consultarPorId", parametro);
                break;
            case "Nome":
                resultado = FornecedorDAO.getUnicaInstancia().consultar("consultarPorNome", parametro);
                break;
            case "Email":
                resultado = FornecedorDAO.getUnicaInstancia().consultar("consultarPorEmail", parametro);
                break;
            default:
                break;
        }

        return resultado;
    } 
}
