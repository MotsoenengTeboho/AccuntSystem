package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Miles")

public class Miles implements Serializable {
    private static final long serialVersion = 1530294317029175846L;

    private Long milesID;
    private Long memberID;
    private Number numberOfMiles;

    public Miles(Long milesID, Long memberID, Number numberOfMiles){
        this.milesID = milesID;
        this.memberID = memberID;
        this.numberOfMiles = numberOfMiles;
    }

    public Miles(){
    }

    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
    @Column(name = "MILES_ID")
    public Long getMilesID() {
        return milesID;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    @Column(name = "NUMBER_OF_MILES")
    public Number getNumberOfMiles() {
        return numberOfMiles;
    }

    public void setMilesID(Long milesID) {
        this.milesID = milesID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public void setNumberOfMiles(Number numberOfMiles) {
        this.numberOfMiles = numberOfMiles;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Miles that = (Miles) o;
        return Objects.equals(milesID, that.milesID) && Objects.equals(memberID, that.memberID) && Objects.equals(numberOfMiles, that.numberOfMiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(milesID, memberID, numberOfMiles);
    }

    @Override
    public String toString() {
        return "Miles{" +
                "milesID=" + milesID +
                ", memberID=" + memberID +
                ", numberOfMiles=" + numberOfMiles +
                '}';
    }
}
