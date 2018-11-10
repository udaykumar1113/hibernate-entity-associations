package com.uday.association.bionetomanyjointable.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="BUDGET")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BUDGET_ID")
    private int budgetId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="BUDGET_TRANSACTION",
            joinColumns = @JoinColumn(name="BUDGET_ID"),
            inverseJoinColumns = @JoinColumn(name="TRANSACTION_ID")
    )
    private List<Transactions> transactions=new ArrayList<Transactions>();

    private String budgetName;
}
