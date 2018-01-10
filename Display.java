package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.util.Duration;

public class Display {
	
	private Stage stage;
	
	private Scene profileScene;
	
	private BorderPane root;
	
	private HBox desk;
	private VBox deskButtons;
	private GridPane statistic;
	private VBox description;
	private HBox formatButtons;
	private GridPane posts;
	
	private HBox topPane;
	private HBox bottomPane;

	private VBox generalPane;
	
	private Button options;
	private Label userName;

	private Button newsFeed;
	private Button search;
	private Button addPhoto;
	private Button notification;
	private Button profile;
	
	private Button editProfile;
	
	private Button bPosts;
	private Button bFollowers;
	private Button bFollowing;
	
	private Button grid;
	private Button ribbon;
	private Button tagPhoto;
	
	Label fullName;
	Label descrip;
	
	private Image profilePhotoImg;
	private Circle profilePhoto;
	
	Display(Stage stage) {
		this.stage = stage;
		setProfileScene();
	}

	public void setProfileScene() {
		
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.BLUE);
		
		DropShadow shadow_gray = new DropShadow();
		shadow_gray.setColor(Color.GRAY);
		
		root = new BorderPane();
		topPane = new HBox();
		generalPane = new VBox();
		bottomPane = new HBox();
		
		profileScene = new Scene(root, 500, 750);
		profileScene.getStylesheets().add(getClass().getResource("profile.css").toExternalForm());
		
		root.setTop(topPane);
		root.setCenter(generalPane);
		root.setBottom(bottomPane);
		
		topPane.setSpacing(10);
		topPane.setId("topPane");
		
		generalPane.setSpacing(10);
		generalPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		bottomPane.setSpacing(40);
		bottomPane.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		userName = new Label("User_name");
		topPane.getChildren().add(userName);
		userName.setId("userName");
		userName.setMaxHeight(50);
		userName.setPadding(new Insets(10, 10, 10, 10));
		userName.setFont(Font.font(14));
		
		options = new Button();
		topPane.getChildren().add(options);
		options.setId("options");
		options.setTranslateX(355);
		options.setTranslateY(5);
		options.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> options.setEffect(shadow_gray));
		options.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> options.setEffect(null));
		options.setOnAction((event) -> new LogIn(stage).setLoginScene());
		
		desk = new HBox();
		generalPane.getChildren().add(desk);
		
		profilePhotoImg = new Image("file:///C:/Users/Denis/Desktop/Instagram_images/add_photo.png");
		
		profilePhoto = new Circle(65); 
		profilePhoto.setStroke(Color.WHITE); 
		profilePhoto.setTranslateX(25);
		profilePhoto.setTranslateY(15);
		profilePhoto.setEffect(new DropShadow(+25d, 0d, +2d, Color.CORNFLOWERBLUE));
		
		profilePhoto.setFill(new ImagePattern(profilePhotoImg));

		desk.getChildren().add(profilePhoto);
		
		deskButtons = new VBox();
		deskButtons.setTranslateX(profilePhoto.getTranslateX() * 2 + profilePhoto.getStrokeWidth());
		desk.getChildren().add(deskButtons);
		
		statistic  = new GridPane();
		statistic.setHgap(70);
		statistic.setVgap(0);
		statistic.setAlignment(Pos.CENTER);
		statistic.setPadding(new Insets(15,25,0,0));
		deskButtons.getChildren().add(statistic);
		deskButtons.setSpacing(25);
			
		bPosts = new Button("100");
		bPosts.setId("statisticButtons");
		Label lPosts = new Label("   posts");
		lPosts.setId("statisticLabels");
		bFollowers = new Button("100");
		bFollowers.setId("statisticButtons");
		Label lFollowers = new Label("followers");
		lFollowers.setId("statisticLabels");
		bFollowing = new Button("100");
		bFollowing.setId("statisticButtons");
		Label lFollowing = new Label("following");
		lFollowing.setId("statisticLabels");
		
		statistic.add(bPosts,0,0);
		statistic.add(bFollowers,1,0);
		statistic.add(bFollowing,2,0);
		statistic.add(lPosts,0,1);
		statistic.add(lFollowers,1,1);
		statistic.add(lFollowing,2,1);
		
		
		editProfile = new Button("Edit Profile");
		editProfile.setId("editProfile");
		editProfile.setMaxWidth(profileScene.getWidth() - 2 * profilePhoto.getTranslateX() - 2 * profilePhoto.getRadius() - 10);
		
		
		editProfile.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> editProfile.setEffect(shadow_gray));
		editProfile.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> editProfile.setEffect(null));
		deskButtons.getChildren().add(editProfile);
		
		
		description = new VBox();
		description.setTranslateX(25);
		description.setTranslateY(profilePhoto.getTranslateY());
		generalPane.getChildren().add(description);
		fullName = new Label("Full name");
		fullName.setId("fullName");
		description.getChildren().add(fullName);
		descrip = new Label("Desription");
		descrip.setId("description");
		description.getChildren().add(descrip);
		
		formatButtons = new HBox();
		formatButtons.setTranslateY(description.getTranslateY());
		generalPane.getChildren().add(formatButtons);
		formatButtons.setId("formatButtonsBox");
		
		grid = new Button();
		grid.setId("grid");
		grid.setTranslateX(50);
		formatButtons.getChildren().add(grid);
		grid.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> grid.setEffect(shadow));
		grid.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> grid.setEffect(null));
		
		ribbon = new Button();
		ribbon.setId("ribbon");
		ribbon.setTranslateX(grid.getTranslateX() + 110);
		formatButtons.getChildren().add(ribbon);
		ribbon.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> ribbon.setEffect(shadow));
		ribbon.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> ribbon.setEffect(null));
		
		tagPhoto = new Button();
		tagPhoto.setId("tag_photo");
		tagPhoto.setTranslateX(ribbon.getTranslateX() + 110);
		formatButtons.getChildren().add(tagPhoto);
		tagPhoto.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> tagPhoto.setEffect(shadow));
		tagPhoto.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> tagPhoto.setEffect(null));
		
		posts = new GridPane();
		generalPane.getChildren().add(posts);
		
		
		
		
		newsFeed = new Button();
		newsFeed.setId("news_feed");
		newsFeed.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> newsFeed.setEffect(shadow));
		newsFeed.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> newsFeed.setEffect(null));
		
		search = new Button();
		search.setId("search");
		search.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> search.setEffect(shadow));
		search.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> search.setEffect(null));
		
		addPhoto = new Button();
		addPhoto.setId("addPhoto");
		addPhoto.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> addPhoto.setEffect(shadow));
		addPhoto.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> addPhoto.setEffect(null));
		
		notification = new Button();
		notification.setId("notification");
		notification.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> notification.setEffect(shadow));
		notification.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> notification.setEffect(null));
		
		profile = new Button();
		profile.setId("profile");
		profile.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> profile.setEffect(shadow));
		profile.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> profile.setEffect(null));

		bottomPane.getChildren().add(newsFeed);
		bottomPane.getChildren().add(search);
		bottomPane.getChildren().add(addPhoto);
		bottomPane.getChildren().add(notification);
		bottomPane.getChildren().add(profile);
		
		
		
		

		
		stage.setScene(profileScene);
		stage.show();
		stage.setOnCloseRequest((t) -> System.exit(0));
		
	}
	

	
}
