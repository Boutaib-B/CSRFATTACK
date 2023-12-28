package ensa.ssi.csrf.target.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Data @NoArgsConstructor @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 3)
public abstract class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private Date date;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "codeCompte")
    private Compte compte;
    @ManyToOne
    @JoinColumn(name = "codeEmploye")
    private Employe employe;

    public Operation(Date date, double montant, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.compte = compte;
    }
}
