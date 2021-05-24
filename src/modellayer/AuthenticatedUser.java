package modellayer;

public class AuthenticatedUser {
	private static AuthenticatedUser authedUser;
	private Person currentUser;
	
	public static AuthenticatedUser getInstance() {
		if(authedUser == null)
			authedUser = new AuthenticatedUser();
		
		return authedUser;
	}
	
	public Person getCurrentUser() {
		return this.currentUser;
	}
	
	public void setCurrentUser(Person user) {
		this.currentUser = user;
	}
	
}
