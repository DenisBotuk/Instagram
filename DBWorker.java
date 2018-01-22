package application;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;


public class DBWorker {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	boolean boolStat;
	boolean boolRes;
	
	DBWorker() throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:/C://Users//Denis//eclipse-workspace//InstagramLite//src//application/instagram.db");
	}
	
	void showTables() throws SQLException {
		st = conn.createStatement();
		rs = st.executeQuery("SELECT name FROM sqlite_master WHERE type = \"table\"");
		while(rs.next()){//true if it is what to return 
			 System.out.println(rs.getString(1));
		}
		boolStat = true;
		boolRes = true;
	}
	/*
	void insertImage(String imageURL) throws SQLException, IOException {
		String sql = "INSERT INTO profiles (LOGIN, FULL_NAME, DESCRIPTION, PHOTO) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "denis");
		stmt.setString(2, "den");
		stmt.setString(3, "cool");

		File image = new File(imageURL);
		FileInputStream   fis = new FileInputStream(image);
		stmt.setBinaryStream(4, fis, (int) image.length());
		stmt.execute();
		
		fis.close();
	}
	
	Image getMainImage(String login) throws SQLException, IOException {
			String sql = "SELECT PHOTO FROM profiles WHERE LOGIN='" + login +"'";
			
			st=conn.createStatement(); 
			rs=st.executeQuery(sql); 
			Blob test = null;
			while (rs.next()) {
				test=rs.getBlob(5); 
			}
			int blobLength = (int) test.length(); 
			byte[] blobAsBytes = test.getBytes(1, blobLength); 

			BufferedImage imageBuf = ImageIO.read(new ByteArrayInputStream(blobAsBytes)); 
			Image image = SwingFXUtils.toFXImage(imageBuf, null);
			boolStat = true;
			boolRes = true;
			return image;

	}*/
	
	void createTable(String name, String parametres) throws SQLException, ClassNotFoundException{
		st = conn.createStatement();
		st.execute("CREATE TABLE IF NOT EXISTS " + name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + parametres + ")");
		boolStat = true;
	}
	
	void deleteTable(String name) throws SQLException {
		st = conn.createStatement();
		st.execute("DROP TABLE " + name);
		boolStat = true;
	}
	
	void register(String login, String pass) {
		try {
			st = conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		boolStat = true;
		try {
		st.execute("INSERT INTO accounts (LOGIN, PASSWORD) VALUES('" + login + "','" + pass + "')");
		} catch (SQLException e) {
			System.out.println("This login exists!");
		}
	}
	
	boolean checkPassword(String login, String pass) throws SQLException {
		st = conn.createStatement();
		rs = st.executeQuery("SELECT PASSWORD FROM accounts WHERE LOGIN='" + login + "'");
		boolStat = true;
		boolRes = true;
		if(!rs.next()) return false;
		else return (pass.equals(rs.getString(1)) ? true : false);
	}
	
	public void CloseDB() throws ClassNotFoundException, SQLException{
		if (boolRes) rs.close();
		if (boolStat) st.close();
		conn.close();
		System.out.println("Соединения закрыты");
	}
}
