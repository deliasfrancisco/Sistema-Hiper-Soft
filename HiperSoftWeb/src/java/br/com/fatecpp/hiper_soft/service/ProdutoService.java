package br.com.fatecpp.hiper_soft.service;

import br.com.fatecpp.hiper_soft.controller.ProdutoController;
import br.com.fatecpp.hiper_soft.model.domain.Produto;

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
@WebServlet(name = "ProdutosService", urlPatterns = {"/Produto"})
public class ProdutoService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = new Produto();
        String acao = request.getParameter("action");
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String urlDestino = "jsp/ProdutoView.jsp";
        String msg  = "";        
      
        if (acao != null) {
            if (acao.equals("editU")) {
                List<Produto> list = ProdutoController.getUnicaInstancia().consultar("Id", id);
                produto.setCodProd(list.get(0).getCodProd());
                produto.setNomeProd(list.get(0).getNomeProd());

                request.setAttribute("action", "editU");
                request.setAttribute("id", produto.getCodProd());
                request.setAttribute("nome", produto.getNomeProd());
                
            } else if (acao.equals("editD")) {
                List<Produto> list = ProdutoController.getUnicaInstancia().consultar("Id", id);
                produto.setCodProd(list.get(0).getCodProd());
                produto.setNomeProd(list.get(0).getNomeProd());

                request.setAttribute("action", "editD");
                request.setAttribute("id", produto.getCodProd());
                request.setAttribute("nome", produto.getNomeProd());
                
            } else if (acao.equals("add")) {
                produto.setCodProd(0);
                produto.setNomeProd(nome);

                if (ProdutoController.getUnicaInstancia().inserir(produto)) {
                    msg = "Produto inserido com sucesso!";
                } else {
                    msg = "Erro na inclusão do produto - Não incluiu!";
                }
                request.setAttribute("id", "");
                request.setAttribute("nome", "");
                request.setAttribute("qtdAtual", "");
                
            } else if (acao.equals("update")) {
                produto.setCodProd(Integer.parseInt(id));
                produto.setNomeProd(nome);

                if (ProdutoController.getUnicaInstancia().alterar(produto)) {
                    msg = "Produto alterado com sucesso!";
                } else {
                    msg = "Erro na alteração do produto - Não alterou!";
                }
                request.setAttribute("id", "");
                request.setAttribute("nome", "");
                request.setAttribute("qtdAtual", "");
                
            } else if (acao.equals("delete")) {
                produto.setCodProd(Integer.parseInt(id));
                produto.setNomeProd(nome);
                
                if (ProdutoController.getUnicaInstancia().excluir(produto)) {
                    msg = "Produto excluido com sucesso!";
                } else {
                    msg = "Erro na exclusão do produto - Não excluiu!";
                }
                request.setAttribute("id", "");
                request.setAttribute("nome", "");
                request.setAttribute("qtdAtual", "");
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
