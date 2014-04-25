package domain;


import java.awt.Image;
import java.security.MessageDigest;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import validation.OnPasswordUpdate;
import validation.ValidPassword;
import validation.ValidUsername;

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
@SecondaryTable(name = "USER_PASSWORD")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})

public class User{
    @Id
    @ValidUsername
    private String username;
    private String fullname;
    
    @NotNull
    //@Pattern(regexp="[A-Za-z0-9]{8}+")
    @ValidPassword(groups = OnPasswordUpdate.class)
    private String password;
    
    
    
    
    private String fotoURL;

    

    public User() {
    }

    public User(String fullname, String username, String password, String fotoURL) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.fotoURL = fotoURL;
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
        this.password = password;
        
    }
}
