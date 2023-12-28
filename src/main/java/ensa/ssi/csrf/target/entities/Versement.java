package ensa.ssi.csrf.target.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("ver")
public class Versement extends Operation {
    public Versement(Date date, double montant, Compte compte) {
        super(date, montant, compte);
    }
}
