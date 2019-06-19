package br.com.fatecpp.hiper_soft.service;

import br.com.fatecpp.hiper_soft.controller.FornecedorController;
import br.com.fatecpp.hiper_soft.model.domain.Fornecedor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Diego Francisco
 */
@WebServlet(name = "FornecedorService", urlPatterns = {"/Fornecedor"})
public class FornecedorService extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Fornecedor fornecedor = new Fornecedor();
            String acao = request.getParameter("action");
            String id = request.getParameter("id");
            String razaoSocial = request.getParameter("razaoSocial");
            String nomeFantasia = request.getParameter("nomeFantasia");
            String cnpj = request.getParameter("cnpj");
            String urlDestino = "jsp/FornecedorView.jsp";
            String msg  = "";        
      
        if (acao != null) {
            if (acao.equals("editU")) {
                List<Fornecedor> list = FornecedorController.getUnicaInstancia().consultar("Id", id);
                fornecedor.setCodFor(list.get(0).getCodFor());
                fornecedor.setRzSocial(list.get(0).getRzSocial());
                fornecedor.setNomeFor(list.get(0).getNomeFor());
                fornecedor.setCnpjFor(list.get(0).getCnpjFor());

                request.setAttribute("action", "editU");
                request.setAttribute("id", fornecedor.getCodFor());
                request.setAttribute("razaoSocial", fornecedor.getRzSocial());
                request.setAttribute("nomeFantasia", fornecedor.getNomeFor());
                request.setAttribute("cnpj", fornecedor.getCnpjFor());
                
            } else if (acao.equals("editD")) {
                List<Fornecedor> list = FornecedorController.getUnicaInstancia().consultar("Id", id);
                fornecedor.setCodFor(list.get(0).getCodFor());
                fornecedor.setRzSocial(list.get(0).getRzSocial());
                fornecedor.setNomeFor(list.get(0).getNomeFor());
                fornecedor.setCnpjFor(list.get(0).getCnpjFor());

                request.setAttribute("action", "editD");
                request.setAttribute("id", fornecedor.getCodFor());
                request.setAttribute("razaoSocial", fornecedor.getRzSocial());
                request.setAttribute("nomeFantasia", fornecedor.getNomeFor());
                request.setAttribute("cnpj", fornecedor.getCnpjFor());
                
            } else if (acao.equals("add")) {
                fornecedor.setCodFor(0);
                fornecedor.setRzSocial(razaoSocial);
                fornecedor.setNomeFor(nomeFantasia);
                fornecedor.setCnpjFor(cnpj);

                if (FornecedorController.getUnicaInstancia().inserir(fornecedor)) {
                    msg = "Fornecedor inserido com sucesso!";
                } else {
                    msg = "Erro na inclusão do fornecedor - Não incluiu!";
                }
                request.setAttribute("id", "");
                request.setAttribute("razaoSocial", "");
                request.setAttribute("nomeFantasia", "");
                request.setAttribute("cnpj", "");
                
            } else if (acao.equals("update")) {
                fornecedor.setCodFor(Integer.parseInt(id));
                fornecedor.setRzSocial(razaoSocial);
                fornecedor.setNomeFor(nomeFantasia);
                fornecedor.setCnpjFor(cnpj);

                if (FornecedorController.getUnicaInstancia().alterar(fornecedor)) {
                    msg = "Fornecedor alterado com sucesso!";
                } else {
                    msg = "Erro na alteração do fornecedor - Não alterou!";
                }
                request.setAttribute("id", "");
                request.setAttribute("razaoSocial", "");
                request.setAttribute("nomeFantasia", "");
                request.setAttribute("cnpj", "");
                
            } else if (acao.equals("delete")) {
                fornecedor.setCodFor(Integer.parseInt(id));
                fornecedor.setRzSocial(razaoSocial);
                fornecedor.setNomeFor(nomeFantasia);
                fornecedor.setCnpjFor(cnpj);
                
                if (FornecedorController.getUnicaInstancia().excluir(fornecedor)) {
                    msg = "Fornecedor excluido com sucesso!";
                } else {
                    msg = "Erro na exclusão do fornecedor - Não excluiu!";
                }
                request.setAttribute("id", "");
                request.setAttribute("razaoSocial", "");
                request.setAttribute("nomeFantasia", "");
                request.setAttribute("cnpj", "");
            }            
        }

        request.setAttribute("msg", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher(urlDestino);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
