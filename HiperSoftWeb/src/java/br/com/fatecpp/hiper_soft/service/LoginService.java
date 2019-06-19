package br.com.fatecpp.hiper_soft.service;

import br.com.fatecpp.hiper_soft.controller.UsuarioController;
import br.com.fatecpp.hiper_soft.model.domain.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Diego Francisco
 */
@WebServlet(name = "LoginService", urlPatterns = {"/ExeLogin"})
public class LoginService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, LoginException {

        Usuario usuario = new Usuario();    
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String urlDestino = "menu.jsp";
        String msg  = "";
        
        if (username == null || (username.equals("")) || (senha == null) || (senha.equals(""))){
            throw new LoginException("Por favor, informe todos os dados.");

        }
        else{
            usuario.setUsuUsername(username);
            usuario.setUsuSenha(senha);
            request.getSession().setAttribute("username", username);
                
            if(UsuarioController.getUnicaInstancia().consultaLoginUsernameSenha(username, senha)){
                msg = "Usuário autenticado.";
                request.setAttribute("msg", msg);
                response.sendRedirect(urlDestino);                
            }
            else {
                msg = "Usuário e senha inválidos!";
                response.sendRedirect("LoginView.jsp");       
            }
        }
        
        if (UsuarioController.getUnicaInstancia().consultaLoginUsernameSenha(username, senha)) {
            
            HttpSession oldSession = request.getSession(false);           
            if (oldSession != null) {
                oldSession.removeAttribute("user");
                oldSession.invalidate();
            }         
            
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(5*60);
            session.setAttribute("user", username);
            Cookie user = new Cookie("user", username);
            response.addCookie(user);
            urlDestino = request.getContextPath() + "/jsp/menu.jsp";
            response.sendRedirect(urlDestino);
        } else {
            request.removeAttribute(username);
            request.removeAttribute(senha);
            request.setAttribute("msg", "Usuario ou senha invalidos!");
            urlDestino = "jsp/Login.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(urlDestino);
            dispatcher.include(request, response);
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
        try {
            processRequest(request, response);
        } catch (LoginException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (LoginException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
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