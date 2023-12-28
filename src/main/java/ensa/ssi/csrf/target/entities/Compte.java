package ensa.ssi.csrf.target.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity @Data @NoArgsConstructor @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 8)
public abstract class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "codeClient")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "codeEmploye")
    private Employe employe;
    @OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
    private Collection<Operation> operations;

    public Compte(Date dateCreation, double solde, Client client) {
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
    }
}
