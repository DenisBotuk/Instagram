package application;

import java.util.*;

import javafx.scene.image.Image;

public class Post {
	Image[] images;
	String location;
	Profile[] tagPeople;
	String caption;
	
	ArrayList <Profile> likes;
	ArrayList <Comment> comments;
	
	Post(Image[] images, String location, String caption, Profile[] tagPeople){
		this.images = images;
		this.location = location;
		this.caption = caption;
		tagPeople(tagPeople);
		likes = new ArrayList<Profile>();
		comments = new ArrayList<Comment>();
	}
	
	void tagPeople(Profile[] tagPeople) {
		this.tagPeople = tagPeople;
		for(Profile profile : tagPeople) {
			profile.tagIn(this);
		}
	}
	
	void like(Profile profile) {
		likes.add(profile);
	}
	
	void comment(Profile profile, String text) {
		Comment comm = new Comment(profile, text);
		comments.add(comm);
	}
}
