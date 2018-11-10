package com.uday.association.bionetomany.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BI_TRANSACTION")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name="TRA_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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
}
