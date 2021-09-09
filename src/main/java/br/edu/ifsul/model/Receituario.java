/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "receituario")
public class Receituario implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_receituario", sequenceName = "seq_receituario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_receituario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    //texto sem limite de caracteres
    @Column(name = "posologia", columnDefinition = "text")
    private String posologia;
    
    @NotNull(message = "A data de cadastro deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "validade", nullable = false)
    private Calendar validade;
    
    @NotNull(message = "A consulta deve ser informada")
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false)      
    private Consulta consulta;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "medicamentos",
            joinColumns = 
                    @JoinColumn(name = "receituario_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "medicamento_id", referencedColumnName = "id", nullable = false))
    private Set<Medicamento> medicamentos = new HashSet<>();
    
    public Receituario(){
        
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
     * @return the posologia
     */
    public String getPosologia() {
        return posologia;
    }

    /**
     * @param posologia the posologia to set
     */
    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Receituario other = (Receituario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @param validade the validade to set
     */

    /**
     * @return the consulta
     */
    public Consulta getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    /**
     * @param medicamentos the medicamentos to set
     */
    public void setMedicamentos(Set<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    /**
     * @return the medicamentos
     */
    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    /**
     * @return the validade
     */
    public Calendar getValidade() {
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(Calendar validade) {
        this.validade = validade;
    }
    
    
}
