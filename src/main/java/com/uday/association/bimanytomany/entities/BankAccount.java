package com.uday.association.bimanytomany.entities;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="BANK_ACCOUNT")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    private int accountId;
    private String bankName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="USERS_ACCOUNTS_BI",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
            inverseJoinColumns = @JoinColumn(name="USER_ID")
    )
    private List<BankUser> users=new ArrayList<BankUser>();

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<BankUser> getUsers() {
        return users;
    }

    public void setUsers(List<BankUser> users) {
        this.users = users;
    }
}
