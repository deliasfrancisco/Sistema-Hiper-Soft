package br.com.fatecpp.hiper_soft.controller;

import br.com.fatecpp.hiper_soft.model.dao.VendaDAO;
import br.com.fatecpp.hiper_soft.model.domain.Venda;
import java.util.List;

public class VendaController {
    private static VendaController unicaInstancia;
        
    public static VendaController getUnicaInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new VendaController();
        } 
        return unicaInstancia;
    }
        
    public boolean inserir(Venda venda) {
        try {
            return VendaDAO.getUnicaInstancia().inserir(venda);
        } catch(Exception ex) {
            return false;
        }
    }

    public boolean alterar(Venda venda) {
          try {
            return VendaDAO.getUnicaInstancia().alterar(venda);
        } catch(Exception ex) {
            return false;
        }
    }

    public boolean excluir(Venda venda) {
          try {
            return VendaDAO.getUnicaInstancia().excluir(venda);
        } catch(Exception ex) {
            return false;
        }
    }

    public List<Venda> consultar(String opcao, String parametro) {
      
        List<Venda> resultado = null;
        opcao = opcao.trim();
        parametro = parametro.trim();
                
        switch (opcao) {
            case "Id":
                try {
                    int i = Integer.parseInt(parametro);
                    resultado = VendaDAO.getUnicaInstancia().consultar("consultarPorId", parametro);
                } catch(Exception e) {
                    resultado = VendaDAO.getUnicaInstancia().consultar("consultarTodos", "");
                }
                break;
            case "Nome":
                resultado = VendaDAO.getUnicaInstancia().consultar("consultarPorNome", parametro);
                break;
            case "Email":
                resultado = VendaDAO.getUnicaInstancia().consultar("consultarPorEmail", parametro);
                break;
            default:
                resultado = VendaDAO.getUnicaInstancia().consultar("consultarTodos", "");
                break;
        }

        return resultado;
    }    
}
