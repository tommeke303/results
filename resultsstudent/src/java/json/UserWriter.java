/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package json;

import domain.User;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author thomas
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class UserWriter implements MessageBodyWriter<User>{

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(User t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(User t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        JsonObjectBuilder jsonUser = Json.createObjectBuilder();
        
        jsonUser.add("username", t.getUserName());
        if (t.getFullname() != null){
            jsonUser.add("fullName", t.getFullname());
        }
        
        if (t.getFotoURL() != null){
            jsonUser.add("fotoURL", t.getFotoURL());
        }
        
        try (JsonWriter out = Json.createWriter(entityStream)){
            out.writeObject(jsonUser.build());
        }
    }
    
}
