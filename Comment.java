package application;

public class Comment {
	Profile author;
	String text;
	
	Comment(Profile author, String text){
		this.author = author;
		this.text = text;
	}
	
	void edit(Profile author, String text) {
		if(checkAuthor(author)) {
			this.text = text;
		}
	}
	
	boolean checkAuthor(Profile author) {
		return this.author.equals(author);
	}
	
}
