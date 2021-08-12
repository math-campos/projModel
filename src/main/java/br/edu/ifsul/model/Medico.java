/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author matheus
 */
@Entity
@Table(name = "medico")
public class Medico extends Paciente {
    
    @NotBlank(message = "O crm deve ser informado")
    @Length(max = 10, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "crm", length = 10, nullable = false)  
    private String crm;
    
    @NotNull(message = "Especialidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "especialidade_id", referencedColumnName = "id", nullable = false)    
    private Especialidade especialidade;
    
    public Medico(){
        
    }
    /**
     * @return the crm
     */
    public String getCrm() {
        return crm;
    }

    /**
     * @param crm the crm to set
     */
    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.crm);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.crm, other.crm)) {
            return false;
        }
        return true;
    }

    /**
     * @return the especialidade
     */
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    
    
}
