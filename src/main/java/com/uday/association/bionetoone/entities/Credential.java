package com.uday.association.bionetoone.entities;

import javax.persistence.*;

@Entity
@Table(name="BI_CREDENTIAL")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int credentialId;
    private String userName;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "FIN_USER_ID")
    private User user;

    public int getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(int credentialId) {
        this.credentialId = credentialId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
