package br.com.nutriproapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.nutriproapp.db.UserRepository;
import br.com.nutriproapp.model.Diet;
import br.com.nutriproapp.model.User;

public class NutriproWS {
	
	private UserRepository userRepository;
	
	public NutriproWS() {
		userRepository = new UserRepository();
	}
	
//	@Path("diet")
//	@GET
//	@Produces({MediaType.APPLICATION_JSON})
	public Diet getDiet(@QueryParam("username") String username) {
		System.out.println("getDiet() username=" + username);
		User user = userRepository.findByUsername(username);
		if (user == null)
			return null;
			
		return Diet.getDiet(user);
		
		
	}
}
