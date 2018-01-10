package application;

import java.util.*;

import javafx.scene.image.Image;

public class Profile {
	
	Account account;
	String subtitle;
	Image image;
	
	ArrayList <Post> posts;
	ArrayList <Profile> followers;
	ArrayList <Profile> following;
	ArrayList <Post> taggedIn;
	
	Profile(Account account, String subtitle, Image image){
		this.account = account;
		this.subtitle = subtitle;
		this.image = image;
		posts = new ArrayList<Post>();
		followers = new ArrayList<Profile>();
		following = new ArrayList<Profile>();
		taggedIn = new ArrayList<Post>();
	}
	
	boolean equals(Profile other) {
		return this.account.equals(other.getAccount());
	}
	
	Account getAccount() {
		return account;
	}
	
	void tagIn(Post post) {
		taggedIn.add(post);
	}
	
	
}
