package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.MemberType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "MemberType", description = "A DTO that represents the AccountType of the Member")
public class MemberTypeDto implements Serializable {
    private static final long serialVersionUID = -534685320648289868L;

    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    public MemberTypeDto() {
    }

    public MemberTypeDto(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public MemberTypeDto(MemberType memberType) {
        this.setAccountTypeName(memberType.getAccountTypeName());
        this.setCreationDate(memberType.getCreationDate());
        this.setMnemonic(memberType.getMnemonic());
    }

    @ApiModelProperty(position = 1,
            value = "MemberType Mnemnic", name = "Mnemonic", notes = "The name of the MemberType", dataType = "java.lang.String",
            example = "Miles", allowEmptyValue = false, required = true)

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position = 2, value = "MemberType Name", name = "Name", notes = "This is the name of the MemberType",
            dataType = "java.lang.String", example = "Miles", allowEmptyValue = false, required = true)

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @ApiModelProperty(position = 3, value = "MemberType Creation Date", name = "CreationDate",
            notes = "This is the date on which the MemberType was created", dataType = "java.lang.String",
            example = "2021-02-01", allowEmptyValue = true, required = false)

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberTypeDto that = (MemberTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @JsonIgnore
    public MemberType getMemberType(){
        return new MemberType(getMnemonic(), getAccountTypeName(), getCreationDate());
    }
    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "MemberTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
