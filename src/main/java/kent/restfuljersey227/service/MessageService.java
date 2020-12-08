/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.restfuljersey227.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    
    public Message getMessage(long id) {
        return messages.get(id);
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
    
    public Message removeMessage(long id) {
        return messages.remove(id);
    }
    
}
