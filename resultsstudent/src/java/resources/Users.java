/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resources;

import domain.User;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author thomas
 */
@Path("users")
@Transactional(dontRollbackOn = {BadRequestException.class, NotFoundException.class})
public class Users{
    
    @PersistenceContext
    private EntityManager em;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers(){
        TypedQuery tQuery = em.createNamedQuery("User.findAll", User.class);
        List<User> list = tQuery.getResultList();
        return list;
    }
    
    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("username") String username){
        if (username.isEmpty()){
            throw new BadRequestException("De gebruikersnaam is niet ingevuld");
        }
        User u = em.find(User.class, username);
        if (u == null){
            throw new NotFoundException();
        }
        
        return u;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User u){
        if (u.getUserName() == null){
            throw new BadRequestException("ongeldige username");
        }
        if (u.passwordEmpty() && u.getPasswordLength() >= 8){
            throw new BadRequestException("ongeldig passwoord");
        }
        
        u.setUserName(u.getUserName().trim());
        
        em.persist(u);
        return Response.created(URI.create("/" + u.getUserName())).build();
    }
    
    @DELETE
    @Path("{username}")
    public void removeUser(@PathParam("username") String username){
        if (em.find(User.class, username) == null){
            throw new NotFoundException();
        }
        em.remove(em.find(User.class, username));
    }
    
    @PUT
    @Path("{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("username") String username, InputStream in){
        User u = em.find(User.class, username);
        if (u == null){
            throw new NotFoundException();
        }
        
        try (JsonReader reader = Json.createReader(in)){
            JsonObject userUpdate = reader.readObject();
            
            if (userUpdate.getString("fullName") != null){
                u.setFullname(userUpdate.getString("fullName", null));
            }
            
            if (userUpdate.getString("fotoURL") != null){
                u.setFotoURL(userUpdate.getString("fotoURL", null));
            }
            
            //if (userUpdate.getString("password", null))
        }
        
    }
}
