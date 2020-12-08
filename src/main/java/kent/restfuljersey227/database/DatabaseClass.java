/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.restfuljersey227.database;

import java.util.HashMap;
import java.util.Map;
import kent.restfuljersey227.model.Message;
import kent.restfuljersey227.model.Profile;

/**
 *
 * @author kent_chen
 */
public class DatabaseClass {
    
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();
    
    public static Map<Long, Message> getMessages() {
        return messages;
    }
    
    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
    
}
