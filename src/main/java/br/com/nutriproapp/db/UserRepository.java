package br.com.nutriproapp.db;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.nutriproapp.model.ActivityLevel;
import br.com.nutriproapp.model.User;
import br.com.nutriproapp.model.User.Gender;

public class UserRepository {
	
	private List<User> users;
	
	public UserRepository() {
		User MAS = new User("Marcelo", 29, Gender.MALE, 173, 73.4, ActivityLevel.SEDENTARY);
        User MCL = new User("Matheus", 15, Gender.MALE, 170, 65.0, ActivityLevel.LOW_ACTIVE);
        User FCV = new User("Fernanda", 13, Gender.FEMALE, 151, 47.5, ActivityLevel.VERY_ACTIVE);
        User FAA = new User("Leticia", 23, Gender.FEMALE, 160, 52.1, ActivityLevel.ACTIVE);
        
        users = Arrays.asList(MAS, MCL, FCV, FAA);
	}
	
	public User findByUsername(String username) {
		
		Optional<User> requestedUser = users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
		if (requestedUser.isPresent()) {
			return requestedUser.get();
		}
		return null;
	}

}
