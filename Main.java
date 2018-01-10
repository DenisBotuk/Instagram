package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.sql.*;

public class Main extends Application {
	Stage generalStage;
	@Override
	public void start(Stage generalStage) {
		this.generalStage = generalStage;
		generalStage.setTitle("Instagram Lite v1.0 by Denis Botuk");
		Display display = new Display(generalStage);
		
	}

	public static void main(String[] args) {
		launch(args);
		/*Connection myConn = DriverManager.getConnection("" + "jdbc:sqlite:/C://Users//Denis//eclipse-workspace//InstagramLite//src//application/user.db");
		Statement st = myConn.createStatement();
		 String query = "CREATE TABLE IF NOT EXISTS user(id INT PRIMARY KEY, name TEXT)";
		 st.execute(query);
		 st.execute("INSERT INTO user VALUES(10,'Max')");
		 
		 ResultSet rs = st.executeQuery("SELECT * FROM user");
		 while(rs.next()){//true if it is what to return 
			 System.out.println(rs.getString(1) + "-" + rs.getString(2));
		 }
		 rs.close();
		 st.close();
		 myConn.close();
		 */
	}
}
