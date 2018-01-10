package application;

public class Account {
	String login;
	String password;
	String fullName;
	
	Account(String login, String password, String fullName){
		this.login = login;
		this.password = password;
		this.fullName = fullName;
	}
	
	boolean equals(Account other) {
		return this.login.equals(other.getLogin());
	}
	
	String getLogin() {
		return login;
	}
}
