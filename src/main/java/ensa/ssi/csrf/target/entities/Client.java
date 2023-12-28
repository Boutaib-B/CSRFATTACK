package ensa.ssi.csrf.target.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String nom;
    private String username;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<Compte> comptes;

    public Client(String nom, String username) {
        this.nom = nom;
        this.username = username;
    }

    public Client(Long code) {
        this.code = code;
    }
}
