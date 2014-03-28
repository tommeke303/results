/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package json;

import domain.User;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author thomas
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class UserReader implements MessageBodyReader<User>{

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public User readFrom(Class<User> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try (JsonReader in = Json.createReader(entityStream)){
            User u = new User();
            JsonObject jsonUser = in.readObject();
            u.setUserName(jsonUser.getString("username", null));
            u.setFullname(jsonUser.getString("fullName", null));
            u.setPassword(jsonUser.getString("password", null));
            u.setFotoURL(jsonUser.getString("fotoURL", null));
            return u;
        }
        catch(JsonException | ClassCastException ex){
            throw new BadRequestException("Ongeldige JSON invoer");
        }
    }
    
}
