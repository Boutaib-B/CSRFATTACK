package ensa.ssi.csrf.target.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "codeSub")
    private Employe employeSub;
    @ManyToMany
    @JoinTable(name = "groupeEmployes")
    private Collection<Groupe> groupes;

    public Employe(String nom) {
        this.nom = nom;
    }
}
