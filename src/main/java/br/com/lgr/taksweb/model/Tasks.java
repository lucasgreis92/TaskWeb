/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lgr.taksweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t where t.dtExclusao is null"),
    @NamedQuery(name = "Tasks.findById", query = "SELECT t FROM Tasks t WHERE t.id = :id"),
    @NamedQuery(name = "Tasks.findByIdStatus", query = "SELECT t FROM Tasks t WHERE t.idStatus.id = :idStatus and t.dtExclusao is null"),
    @NamedQuery(name = "Tasks.findByDescricao", query = "SELECT t FROM Tasks t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tasks.findByDtCriacao", query = "SELECT t FROM Tasks t WHERE t.dtCriacao = :dtCriacao"),
    @NamedQuery(name = "Tasks.findByDtEdicao", query = "SELECT t FROM Tasks t WHERE t.dtEdicao = :dtEdicao"),
    @NamedQuery(name = "Tasks.findByDtExclusao", query = "SELECT t FROM Tasks t WHERE t.dtExclusao = :dtExclusao"),
    @NamedQuery(name = "Tasks.findByConclusao", query = "SELECT t FROM Tasks t WHERE t.conclusao = :conclusao"),
    @NamedQuery(name = "Tasks.findByTitulo", query = "SELECT t FROM Tasks t WHERE t.titulo = :titulo")})
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "dt_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCriacao;
    @Column(name = "dt_edicao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEdicao;
    @Column(name = "dt_exclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtExclusao;
    @Size(max = 255)
    @Column(name = "conclusao")
    private String conclusao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Status idStatus;

    public Tasks() {
    }

    public Tasks(Integer id) {
        this.id = id;
    }

    public Tasks(Integer id, String descricao, Date dtCriacao, String titulo) {
        this.id = id;
        this.descricao = descricao;
        this.dtCriacao = dtCriacao;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Date getDtEdicao() {
        return dtEdicao;
    }

    public void setDtEdicao(Date dtEdicao) {
        this.dtEdicao = dtEdicao;
    }

    public Date getDtExclusao() {
        return dtExclusao;
    }

    public void setDtExclusao(Date dtExclusao) {
        this.dtExclusao = dtExclusao;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Status getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lgr.taksweb.model.Tasks[ id=" + id + " ]";
    }

}
