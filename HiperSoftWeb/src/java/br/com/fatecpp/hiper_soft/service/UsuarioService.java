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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioService", urlPatterns = {"/Login"})
public class UsuarioService extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException, LoginException {

        Usuario usuario = new Usuario();    
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String urlDestino = "jsp/menu.jsp";
        String msg = "";
        
        if (username == null || (username.equals("")) || (senha == null) || (senha.equals(""))){
            throw new LoginException("Por favor, informe todos os dados.");

        }
        else{
            usuario.setUsuUsername(username);
            usuario.setUsuSenha(senha);
            request.getSession().setAttribute("username", username);
                
            if(UsuarioController.getUnicaInstancia().consultaLoginUsernameSenha(username, senha) == true){
                msg = "Usuário autenticado.";
                request.setAttribute("msg", msg);
                RequestDispatcher dispatcher = request.getRequestDispatcher(urlDestino);
                dispatcher.forward(request, response);
                //response.sendRedirect(urlDestino);                
            }
            else {
                msg = "Usuário e senha inválidos!";
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/LoginView.jsp");
                dispatcher.forward(request, response);
                //response.sendRedirect(urlDestino);       
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (LoginException ex) {
            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (LoginException ex) {
            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
