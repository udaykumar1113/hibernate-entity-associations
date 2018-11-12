package com.uday.association.bimanytomany;

import com.uday.association.bimanytomany.entities.BankAccount;
import com.uday.association.bimanytomany.entities.BankUser;
import com.uday.association.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class BidirectionalManyToManyMapping {
    public static void main(String args[]){

        SessionFactory sessionFactory=ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        BankUser bankUser_1=new BankUser();
        bankUser_1.setUserName("EDWARD");
        bankUser_1.setLastChangedDate(new Date());

        BankUser bankUser_2=new BankUser();
        bankUser_2.setUserName("HARRY");
        bankUser_2.setLastChangedDate(new Date());

        BankAccount bankAccount_1=new BankAccount();
        bankAccount_1.setBankName("WELLS FARGO");

        BankAccount bankAccount_2=new BankAccount();
        bankAccount_2.setBankName("DCU Bank");

        bankUser_1.getBankAccountList().add(bankAccount_1);
        bankUser_1.getBankAccountList().add(bankAccount_2);
        bankUser_2.getBankAccountList().add(bankAccount_2);
        bankUser_2.getBankAccountList().add(bankAccount_1);

        bankAccount_1.getUsers().add(bankUser_1);
        bankAccount_1.getUsers().add(bankUser_2);
        bankAccount_2.getUsers().add(bankUser_1);
        bankAccount_2.getUsers().add(bankUser_2);

        session.save(bankUser_1);
        session.save(bankUser_2);
        session.save(bankAccount_1);
        session.save(bankAccount_2);

        transaction.commit();

        System.out.println("User with id 1 accounts are: "+ session.get(BankUser.class,1).getBankAccountList().get(0).getBankName()
                            +", "+session.get(BankUser.class,1).getBankAccountList().get(1).getBankName());

        session.close();
    }
}
