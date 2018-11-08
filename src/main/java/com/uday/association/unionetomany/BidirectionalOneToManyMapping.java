package com.uday.association.unionetomany;

import com.uday.association.unionetomany.entities.Account;
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
        account.setBalance(10000);
        account.setName("JOHN");
        account.setLastOpened(new Date());

        com.uday.association.unionetomany.entities.Transaction transaction1=new com.uday.association.unionetomany.entities.Transaction();
        transaction1.setTransactionDate(new Date());

        com.uday.association.unionetomany.entities.Transaction transaction2=new com.uday.association.unionetomany.entities.Transaction();
        transaction2.setTransactionDate(new Date());

        account.getTransactions().add(transaction1);
        account.getTransactions().add(transaction2);

        session.save(account);

        transaction.commit();

        session.close();
    }
}
