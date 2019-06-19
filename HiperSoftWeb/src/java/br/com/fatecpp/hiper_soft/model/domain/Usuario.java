package br.com.fatecpp.hiper_soft.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Diego Francisco
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuCod", query = "SELECT u FROM Usuario u WHERE u.usuCod = :usuCod")
    , @NamedQuery(name = "Usuario.findByUsuNome", query = "SELECT u FROM Usuario u WHERE u.usuNome = :usuNome")
    , @NamedQuery(name = "Usuario.consultarPorUsername", query = "SELECT u FROM Usuario u WHERE u.usuNome = :usuUsername")
  
    , @NamedQuery(name = "Usuario.findByUsernameSenha", query = "SELECT u "
                                                              + "FROM Usuario u "
                                                              + "WHERE u.usuUsername = :usuUsername AND"
                                                                   + " u.usuSenha = :usuSenha")
})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_cod")
    private int usuCod;
    @Column(name = "usu_nome")
    private String usuNome;
    @Column(name = "usu_senha")
    private String usuSenha;
    @Column(name = "usu_username")
    private String usuUsername;

    public Usuario() {
    }

    public Usuario(int usuCod) {
        this.usuCod = usuCod;
    }

    public int getUsuCod() {
        return usuCod;
    }

    public void setUsuCod(int usuCod) {
        this.usuCod = usuCod;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }
    
    public String getUsuUsername() {
        return usuUsername;
    }

    public void setUsuUsername(String usuUsername) {
        this.usuUsername = usuUsername;
    }

    @Override
    public String toString() {
        return "br.com.fatecpp.hiper_soft.model.domain.Usuario[ usuCod=" + usuCod + " ]";
    }
    
}
