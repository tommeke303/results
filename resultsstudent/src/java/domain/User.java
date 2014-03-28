package domain;


import java.awt.Image;
import java.security.MessageDigest;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thomas
 */


@Entity
@Table(name = "TBL_USER")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})

public class User{
    @Id
    private String username;
    private String fullname, password;
    private String fotoURL;
    @Transient
    private int passwordLength;

    

    public User() {
    }

    public User(String fullname, String username, String password, String fotoURL) {
        this.fullname = fullname;
        this.username = username;
        this.password = getPasswordHash(password);
        this.fotoURL = fotoURL;
    }

    private String getPasswordHash(String password) {
        passwordLength = password.length();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public int getPasswordLength() {
        return passwordLength;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }
    public void setPassword(String password){
        this.password = getPasswordHash(password);
    }
    public boolean passwordEmpty(){
        return password.isEmpty();
    }
}
