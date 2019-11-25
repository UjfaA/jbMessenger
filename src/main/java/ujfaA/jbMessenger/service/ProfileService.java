package ujfaA.jbMessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ujfaA.jbMessenger.database.DatabaseClass;
import ujfaA.jbMessenger.model.Profile;

public class ProfileService {
	
	private static long profilesCreated = DatabaseClass.getProfiles().size();
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public List<Profile> getProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profilesCreated++; 
		profile.setId(profilesCreated);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
