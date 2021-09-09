/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author matheus
 */
@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "A data da consulta deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_consulta", nullable = false)
    private Calendar dataConsulta;

    @NotNull(message = "A hora da consulta deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hora", nullable = false)
    private Calendar hora;

    //texto sem limite de caracteres
    @Column(name = "preconsulta", columnDefinition = "text")
    private String preconsulta;

//texto sem limite de caracteres
    @Column(name = "posconsulta", columnDefinition = "text")
    private String posconsulta;

    @NotNull(message = "Paciente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;

    @NotNull(message = "CRM de medico deve ser informada")
    @ManyToOne
    @JoinColumn(name = "medico_crm", referencedColumnName = "crm", nullable = false)
    private Medico medico;

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Exame> exames = new ArrayList<>();

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Receituario> receituarios = new ArrayList<>();

    public Consulta() {

    }

    public void adicionarExame(Exame obj) {
        obj.setConsulta(this);
        this.exames.add(obj);
    }

    public void removerExame(int index){
        this.exames.remove(index);
    }
    
    public void adicionarReceituario(Receituario obj) {
        obj.setConsulta(this);
        this.receituarios.add(obj);
    }

    public void removerReceituario(int index){
        this.receituarios.remove(index);
    }

/**
 * @return the id
 */
public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the data
     */


    /**
     * @param data the data to set
     */

    /**
     * @return the hora
     */


    /**
     * @return the preconsulta
     */
    public String getPreconsulta() {
        return preconsulta;
    }

    /**
     * @param preconsulta the preconsulta to set
     */
    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    /**
     * @return the posconsulta
     */
    public String getPosconsulta() {
        return posconsulta;
    }

    /**
     * @param posconsulta the posconsulta to set
     */
    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    @Override
        public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
        public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the dataConsulta
     */
    public Calendar getDataConsulta() {
        return dataConsulta;
    }

    /**
     * @param dataConsulta the dataConsulta to set
     */
    public void setDataConsulta(Calendar dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }


    /**
     * @return the exames
     */
    public List<Exame> getExames() {
        return exames;
    }

    /**
     * @param exames the exames to set
     */
    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    /**
     * @return the receituarios
     */
    public List<Receituario> getReceituarios() {
        return receituarios;
    }

    /**
     * @param receituarios the receituarios to set
     */
    public void setReceituarios(List<Receituario> receituarios) {
        this.receituarios = receituarios;
    }

    /**
     * @return the hora
     */
    public Calendar getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Calendar hora) {
        this.hora = hora;
    }
    
    
}
