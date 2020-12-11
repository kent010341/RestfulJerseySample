/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.restfuljersey227.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import kent.restfuljersey227.model.Message;
import kent.restfuljersey227.service.MessageService;

/**
 *
 * @author kent_chen
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces( value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class MessageResource {
    
    MessageService messageService = new MessageService();
    
    @GET
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }
    
    @GET
    @Path("/{messageId}")
    public Response getMessage(@PathParam("messageId") long id) {
        return messageService.getMessage(id);
    }
    
    @POST
    public Response addMessage(Message message) {
        Message newMessage = messageService.addMessage(message);
        return Response.status(Status.CREATED)
                       .entity(newMessage)
                       .build();
    }
    
    @PUT
    @Path("/{messageId}")
    public Message updateMessage(
            @PathParam("messageId") long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }
    
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id) {
        messageService.removeMessage(id);
    }
}
