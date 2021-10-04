package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**Setting up my database entities!!!**/
@Entity
@Table(name = "MEMBER")

public class MemberType implements Serializable {
    private static final long serialVersion = 1420294317019175746L;

    private Long memberID;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    public MemberType(Long memberID,String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.memberID = memberID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public MemberType(String mnemonic, String accountTypeName, LocalDate creationDate) {
    }

    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic(){ return mnemonic;}

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName(){ return accountTypeName;}

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate(){ return creationDate;}

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public void setMnemonic(){this.mnemonic = mnemonic;}

    public void setAccountTypeName(){this.accountTypeName = accountTypeName;}

    public void setCreationDate(){this.creationDate = creationDate;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberType that = (MemberType) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "MemberType{" +
                "memberID=" + memberID +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
