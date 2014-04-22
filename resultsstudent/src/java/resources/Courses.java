/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resources;

import domain.Course;
import domain.User;
import java.io.InputStream;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author thomas
 */

//@Path("users/{username}/Courses")
//@Transactional(dontRollbackOn = {BadRequestException.class, NotFoundException.class})
public class Courses {
    /*
    @PersistenceContext
    private EntityManager em;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses(@PathParam("username") String username){
        if (em.find(User.class, username) == null){
            throw new NotFoundException();
        }
        //return em.find(User.class, username).getVakken();
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCourse(@PathParam("username") String username, Course c){
        if (em.find(User.class, username) == null){
            throw new NotFoundException();
        }
        User u = em.find(User.class, username);
        /*if (u.getVakken().contains(c)){
            throw new BadRequestException("het vak bestaat al.");
        }*/
        
        //u.addVak(c);
        
    /*}
/*
    @DELETE
    @Path("{coursename}")
    public void removeCourse(@PathParam("username") String username, @PathParam("coursename") String coursename){
        if (em.find(User.class, username) == null){
            throw new NotFoundException();
        }
        User u = em.find(User.class, username);
        /*if (!u.getVakken().contains(em.find(Course.class, coursename))){
            throw new BadRequestException("het vak bestaat nog niet.");
        }*/
        //u.removeVak(em.find(Course.class, coursename));
    /*}
    /*
    @PUT
    @Path("{coursename}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("username") String username, @PathParam("coursename") String coursename, InputStream in){
        User u = em.find(User.class, username);
        if (u == null){
            throw new NotFoundException();
        }
        
        //dit moet gedaan worden via query. Er zal een where statement moeten worden ingestoken worden.
        //Course c = u.getVakken();
        
    }
    */
}
