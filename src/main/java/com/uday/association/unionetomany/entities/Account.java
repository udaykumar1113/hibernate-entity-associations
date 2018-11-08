package com.uday.association.unionetomany.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID", nullable =false)
    private int accountId;
    private String name;
    private int balance;
    @Temporal(TemporalType.DATE)
    private Date lastOpened;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="TRA_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private List<Transaction> transactions=new ArrayList<Transaction>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getLastOpened() {
        return lastOpened;
    }

    public void setLastOpened(Date lastOpened) {
        this.lastOpened = lastOpened;
    }
}
