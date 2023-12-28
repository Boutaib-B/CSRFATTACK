package ensa.ssi.csrf.target.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
public class Groupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String nom;
    @ManyToMany
    @JoinTable(name = "groupeEmployes")
    private Collection<Employe> employes;

    public Groupe(String nom) {
        this.nom = nom;
    }
}
