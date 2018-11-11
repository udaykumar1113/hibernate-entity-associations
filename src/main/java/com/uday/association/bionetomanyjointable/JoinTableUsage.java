package com.uday.association.bionetomanyjointable;

import com.uday.association.bionetomanyjointable.entities.Account;
import com.uday.association.bionetomanyjointable.entities.Budget;
import com.uday.association.bionetomanyjointable.entities.Transactions;
import com.uday.association.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class JoinTableUsage {

    public static void main(String args[]){

        SessionFactory sessionFactory= ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Account account=new Account();
        account.setBalance(20000);
        account.setLastOpened(new Date());
        account.setName("WALLACE");

        Transactions transactions1=new Transactions();
        transactions1.setTransactionDate(new Date());
        transactions1.setAccount(account);

        Transactions transactions2=new Transactions();
        transactions2.setTransactionDate(new Date());
        transactions2.setAccount(account);

        Budget budget=new Budget();
        budget.setBudgetName("STATIONARY PURCHASE");
        budget.getTransactions().add(transactions1);
        budget.getTransactions().add(transactions2);

        session.save(budget);
        transaction.commit();

        session.close();
    }
}
