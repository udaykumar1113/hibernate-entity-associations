package com.uday.association.unimanytomany.entities;

import com.uday.association.unimanytomany.entities.FIN_USER;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="FIN_ACCOUNT")
public class FIN_ACCOUNT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    private int accountId;
    private String bankName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="USERS_ACCOUNTS",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
            inverseJoinColumns = @JoinColumn(name="USER_ID")
    )
    private List<FIN_USER> users=new ArrayList<FIN_USER>();

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

    public List<FIN_USER> getUsers() {
        return users;
    }

    public void setUsers(List<FIN_USER> users) {
        this.users = users;
    }
}
