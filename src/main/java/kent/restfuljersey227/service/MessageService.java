/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.restfuljersey227.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import kent.restfuljersey227.database.DatabaseClass;
import kent.restfuljersey227.model.Message;

/**
 *
 * @author kent_chen
 */
public class MessageService {
    
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1, "I'm Tim.", "Tim"));
        messages.put(2L, new Message(2, "I'm Tina.", "Tina"));
    }
    
    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }
    
    public Response getMessage(long id) {
        Status status;
        Object entity;
        Message message = messages.get(id);
        if (message != null) {
            entity = messages.get(id);
            status = Status.OK;
        } else {
            entity = "Can't find any data with id: " + id;
            status = Status.NOT_FOUND;
        }
        
        return Response.status(status).entity(entity).build();
    }
    
    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        
        return message;
    }
    
    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        
        return message;
    }
    
    public void removeMessage(long id) {
        messages.remove(id);
    }
    
}
