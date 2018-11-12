package com.uday.association.unimanytomany;

import com.uday.association.unimanytomany.entities.FIN_ACCOUNT;
import com.uday.association.unimanytomany.entities.FIN_USER;
import com.uday.association.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class UnidirectionalManyToManyMapping {
    public static void main(String args[]){

        SessionFactory sessionFactory= ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transactions=session.beginTransaction();

        FIN_ACCOUNT account1=new FIN_ACCOUNT();
        account1.setBankName("BANK OF AMERICA");

        FIN_ACCOUNT account2=new FIN_ACCOUNT();
        account2.setBankName("CHASE BANK");

        FIN_USER user1=new FIN_USER();
        user1.setUserName("JOHN");
        user1.setLastChangedDate(new Date());

        FIN_USER user2=new FIN_USER();
        user2.setUserName("DAVID");
        user2.setLastChangedDate(new Date());

        account1.getUsers().add(user1);
        account1.getUsers().add(user2);

        account2.getUsers().add(user2);
        account2.getUsers().add(user1);

        session.save(account1);
        session.save(account2);

        transactions.commit();
        session.close();
    }
}
