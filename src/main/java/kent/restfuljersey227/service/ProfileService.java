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
import kent.restfuljersey227.model.Profile;

/**
 *
 * @author kent_chen
 */
public class ProfileService {
    
    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
        profiles.put("Tim", new Profile(1L, "Tim", "Tim", "Jones"));
        profiles.put("David", new Profile(2L, "David", "David", "Smith"));
    }
    
    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values()); 
    }
    
    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }
    
    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        
        return profile;
    }
    
    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().isEmpty()) {
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
    
    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }
    
}
