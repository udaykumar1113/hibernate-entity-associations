package com.uday.association.bionetoone;

import com.uday.association.bionetoone.entities.Credential;
import com.uday.association.bionetoone.entities.User;
import com.uday.association.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BidirectionalOneToOneMapping {

    public static void main(String args[]){

        SessionFactory sessionFactory= ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user= new User();
        user.setFirstName("JOHN");
        user.setLastName("DOE");

        Credential credential=new Credential();
        credential.setUserName("JOHN.DOE");
        credential.setPassword("johndoe#");
        credential.setUser(user);

        session.save(user);
        session.save(credential);
        transaction.commit();

        User retrivedUser=session.get(User.class,1);

        System.out.println("User id:"+retrivedUser.getUserId()
                +" credentials are userName:"+retrivedUser.getCredential().getUserName());

        System.out.println("User id:"+retrivedUser.getUserId()
                +" credentials are Password:"+retrivedUser.getCredential().getPassword());

        session.close();

    }
}
