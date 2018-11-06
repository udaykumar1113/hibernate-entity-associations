package com.uday.association.unionetoone;

import com.uday.association.unionetoone.entities.Credential;
import com.uday.association.unionetoone.entities.User;
import com.uday.association.unionetoone.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UnidirectionalOneToOneMapping {

    public static void main(String args[]){

        SessionFactory sessionFactory= ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        User user=new User();
        user.setFirstName("John");
        user.setLastName("Doe");

        Credential credential=new Credential();
        credential.setUserName("john.doe");
        credential.setPassword("JohnDoe#");
        credential.setUser(user);

        session.save(credential);

        transaction.commit();

    }
}
