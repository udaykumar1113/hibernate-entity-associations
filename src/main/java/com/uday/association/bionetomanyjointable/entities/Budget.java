package com.uday.association.bionetomanyjointable.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="BUDGET_JOIN")
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

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }
}
