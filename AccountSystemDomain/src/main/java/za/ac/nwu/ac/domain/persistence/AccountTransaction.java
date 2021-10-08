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
    private Long transactionID;

    @ManyToOne
    @JoinColumn(name = "account_type_ID")
    private MemberType memberType;

    public AccountTransaction(){

    }

    public AccountTransaction(Long accountID, MemberType memberType, Long memberID, Long totalAmount, LocalDate date, Long transactionID){
        this.accountID = accountID;
        this.memberType = memberType;
        this.memberID = memberID;
        this.totalAmount = totalAmount;
        this.date = date;
        this.transactionID = transactionID;
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

    public Long getTransactionID(){
        return transactionID;
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

    public void setTransactionID(Long transactionID){
        this.transactionID = transactionID;
    }


    @Override
    public String toString() {
        return "AccountTransaction{" +
                "totalAmount=" + totalAmount +
                ", date=" + date +
                ", accountID=" + accountID +
                ", memberID=" + memberID +
                ", transactionID=" + transactionID +
                ", memberType=" + memberType +
                '}';
    }
}
