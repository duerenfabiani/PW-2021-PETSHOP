/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "pet")
public class Pet implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_pet", sequenceName = "seq_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pet", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "o Nome ter mais que {max} caracqueter")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar nacimento;
    @Column(name = "peso", nullable = false, precision = 2)
    private Double peso;
    @NotBlank(message = "A Especie não pode ser em branco")
    @Length(max = 50, message = "A Especie ter mais que {max} caracqueter")
    @Column(name = "especie", nullable = false, length = 50)
    private String especie;
    @ManyToOne
    @JoinColumn(name = "raca", referencedColumnName = "id", nullable = false)
    private Raca raca;

    public Pet() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNacimento() {
        return nacimento;
    }

    public void setNacimento(Calendar nacimento) {
        this.nacimento = nacimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Pet other = (Pet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
