package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Account_Type", schema = "VITRSA_SANDBOX")

public class AccountTransaction{
    private static final long serialVersion = 1420294317019175740L;
    private Long totalAmount;
    private LocalDate date;
    private Long accountID;
    private Long memberID;

    @ManyToOne
    @JoinColumn(name = "account_type_ID")
    private MemberType memberType;

    public AccountTransaction(){

    }

    public AccountTransaction(Long accountID, MemberType memberType, Long memberID, Long totalAmount, LocalDate date){
        this.accountID = accountID;
        this.memberType = memberType;
        this.memberID = memberID;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    @Id
    public Long getAccountID(){
        return accountID;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }
}
