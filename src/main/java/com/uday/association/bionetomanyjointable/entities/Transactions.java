package com.uday.association.bionetomanyjointable.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BI_TRANSACTION_JOIN")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TRANSACTION_ID")
    private int transactionId;

    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="TRA_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private Account account;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
