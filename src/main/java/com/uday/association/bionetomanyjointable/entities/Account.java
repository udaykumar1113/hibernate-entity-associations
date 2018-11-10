package com.uday.association.bionetomanyjointable.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="BI_ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    private int accountId;
    private String name;
    private int balance;

    @Temporal(TemporalType.DATE)
    private Date lastOpened;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transactions> transactions=new ArrayList<Transactions>();
}

