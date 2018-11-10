package com.uday.association.bionetomanyjointable.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BI_TRANSACTION")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TRANSACTION_ID")
    private int transactionId;

    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name="TRA_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private Account account;
}
