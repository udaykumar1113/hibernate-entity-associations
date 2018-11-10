package com.uday.association.bionetomany;

import com.uday.association.bionetomany.entities.Account;
import com.uday.association.bionetomany.entities.Transactions;
import com.uday.association.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class BidirectionalOneToManyMapping {

    public static void main(String args[]){

        SessionFactory sessionFactory= ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Account account=new Account();
        account.setBalance(15000);
        account.setLastOpened(new Date());
        account.setName("DAVID");

        Transactions transactions1=new Transactions();
        transactions1.setTransactionDate(new Date());
        transactions1.setAccount(account);

        Transactions transactions2=new Transactions();
        transactions2.setTransactionDate(new Date());
        transactions2.setAccount(account);

        account.getTransactions().add(transactions1);
        account.getTransactions().add(transactions2);

        session.save(account);
        transaction.commit();
        session.flush();
        session.close();
    }
}
