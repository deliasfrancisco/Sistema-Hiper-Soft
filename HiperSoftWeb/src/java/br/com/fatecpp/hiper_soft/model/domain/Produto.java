/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpp.hiper_soft.model.domain;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByCodProd", query = "SELECT p FROM Produto p WHERE p.codProd = :codProd")
    , @NamedQuery(name = "Produto.findByCodUniMed", query = "SELECT p FROM Produto p WHERE p.codUniMed = :codUniMed")
    , @NamedQuery(name = "Produto.findByNomeProd", query = "SELECT p FROM Produto p WHERE p.nomeProd = :nomeProd")
    , @NamedQuery(name = "Produto.findBySetorProd", query = "SELECT p FROM Produto p WHERE p.setorProd = :setorProd")
    , @NamedQuery(name = "Produto.findByFabriProd", query = "SELECT p FROM Produto p WHERE p.fabriProd = :fabriProd")
    , @NamedQuery(name = "Produto.findByValProd", query = "SELECT p FROM Produto p WHERE p.valProd = :valProd")
    , @NamedQuery(name = "Produto.findByPrecoProd", query = "SELECT p FROM Produto p WHERE p.precoProd = :precoProd")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_prod")
    private Integer codProd;
    @Basic(optional = false)
    @Column(name = "cod_uni_med")
    private int codUniMed;
    @Column(name = "nome_prod")
    private String nomeProd;
    @Column(name = "setor_prod")
    private String setorProd;
    @Column(name = "fabri_prod")
    private String fabriProd;
    @Column(name = "val_prod")
    private String valProd;
    @Basic(optional = false)
    @Column(name = "preco_prod")
    private float precoProd;

    public Produto() {
    }

    public Produto(Integer codProd) {
        this.codProd = codProd;
    }

    public Produto(Integer codProd, int codUniMed, float precoProd) {
        this.codProd = codProd;
        this.codUniMed = codUniMed;
        this.precoProd = precoProd;
    }

    public Integer getCodProd() {
        return codProd;
    }

    public void setCodProd(Integer codProd) {
        this.codProd = codProd;
    }

    public int getCodUniMed() {
        return codUniMed;
    }

    public void setCodUniMed(int codUniMed) {
        this.codUniMed = codUniMed;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getSetorProd() {
        return setorProd;
    }

    public void setSetorProd(String setorProd) {
        this.setorProd = setorProd;
    }

    public String getFabriProd() {
        return fabriProd;
    }

    public void setFabriProd(String fabriProd) {
        this.fabriProd = fabriProd;
    }

    public String getValProd() {
        return valProd;
    }

    public void setValProd(String valProd) {
        this.valProd = valProd;
    }

    public float getPrecoProd() {
        return precoProd;
    }

    public void setPrecoProd(float precoProd) {
        this.precoProd = precoProd;
    }

    @Override
    public String toString() {
        return "br.com.fatecpp.hiper_soft.model.domain.Produto[ codProd=" + codProd + " ]";
    }
    
}
