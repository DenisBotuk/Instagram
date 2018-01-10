package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignUp {
	
	Stage stage;

	private VBox registerLO;

	private Scene registerScene;

	private Image registerImg;
	private ImageView register;
	
	private Image addPhotoImg;
	private Circle addPhoto;

	private String photoUrl;
	
	private TextField email;
	private TextField fullName;
	private TextField password;
	private TextField photo;
	
	private Label titleReg;
	private Label title;
	private Label subtitle;

	private Button button;
	
	private Hyperlink hLogIn;
	
	private Label wrongMessage;
	
	SignUp(Stage stage){
		this.stage = stage;
		setRegisterScene_first();
	}
	
	public void setRegisterScene_first() {
		registerLO = new VBox();
		registerLO.setSpacing(10);
		registerLO.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		registerScene = new Scene(registerLO, 500, 750);
		registerScene.getStylesheets().add(getClass().getResource("sign_up.css").toExternalForm());

		registerImg = new Image("file:///C:/Users/Denis/Desktop/Instagram_images/register_img.png");
		register = new ImageView(registerImg);

		registerLO.getChildren().add(register);
		register.setTranslateX((registerScene.getWidth() - registerImg.getWidth()) / 2.);
		register.setTranslateY((registerScene.getHeight()) / 2. - registerImg.getHeight());
		
		email = new TextField();
		email.setPromptText("Email");
		email.setId("email");
		email.setFocusTraversable(false);
		registerLO.getChildren().add(email);
		email.setPadding(new Insets(10, 10, 10, 10));
		email.setTranslateX(50);
		email.setTranslateY(register.getTranslateY());
		email.setMaxWidth(registerScene.getWidth() - 2 * email.getTranslateX());
		Tooltip tooltip_email = new Tooltip("Enter email");
		tooltip_email.setShowDelay(new Duration(10));
		email.setTooltip(tooltip_email);
		
		button = new Button("Next");
		button.setFocusTraversable(false);
		registerLO.getChildren().add(button);
		button.setPadding(new Insets(10, 10, 10, 10));
		button.setTranslateX(50);
		button.setTranslateY(email.getTranslateY());
		button.setMaxWidth(registerScene.getWidth() - 2 * button.getTranslateX());
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.BLUE);
		button.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> button.setEffect(shadow));
		button.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> button.setEffect(null));
		button.setOnAction((event) -> setRegisterScene_second());
		
		wrongMessage = new Label("You haven't input email!!!");
		wrongMessage.setFocusTraversable(false);
		registerLO.getChildren().add(wrongMessage);
		wrongMessage.setId("wrongMessage");
		wrongMessage.setTranslateX(50);
		wrongMessage.setTranslateY(button.getTranslateY());
		wrongMessage.setTextFill(Color.RED);
		wrongMessage.setVisible(false);
		
		hLogIn = new Hyperlink("Already have an account? Log in.");
		hLogIn.setFocusTraversable(false);
		hLogIn.setId("logIn");
		registerLO.getChildren().add(hLogIn);
		hLogIn.setTranslateY(button.getTranslateY() + 200.5);
		hLogIn.setMaxWidth(registerScene.getWidth());
		hLogIn.setAlignment(Pos.CENTER);
		hLogIn.setFont(Font.font(14));
		hLogIn.setTextFill(Color.GRAY);
		
		hLogIn.setOnAction((event) -> new LogIn(stage).setLoginScene());
		
		stage.setScene(registerScene);
		stage.show();
		stage.setOnCloseRequest((t) -> System.exit(0));
	}
	
	public void setRegisterScene_second() {
		registerLO = new VBox();
		registerLO.setSpacing(10);
		registerLO.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		registerScene = new Scene(registerLO, 500, 750);
		registerScene.getStylesheets().add(getClass().getResource("sign_up.css").toExternalForm());
		
		titleReg = new Label("ENTER NAME AND PASSWORD");
		titleReg.setId("titleReg");
		registerLO.getChildren().add(titleReg);
		titleReg.setTranslateX(50);
		titleReg.setTranslateY(registerScene.getWidth() / 2. - 2 * titleReg.getHeight());
		titleReg.setMaxWidth(registerScene.getWidth() - 2 * titleReg.getTranslateX());
		titleReg.setAlignment(Pos.CENTER);
		titleReg.setFont(Font.font(18));
		titleReg.setTextFill(Color.GRAY);
		
		fullName = new TextField();
		fullName.setPromptText("Full name");
		fullName.setId("fullName");
		fullName.setFocusTraversable(false);
		registerLO.getChildren().add(fullName);
		fullName.setPadding(new Insets(10, 10, 10, 10));
		fullName.setTranslateX(50);
		fullName.setTranslateY(titleReg.getTranslateY());
		fullName.setMaxWidth(registerScene.getWidth() - 2 * fullName.getTranslateX());
		Tooltip tooltip_full_name = new Tooltip("Enter full name");
		tooltip_full_name.setShowDelay(new Duration(10));
		fullName.setTooltip(tooltip_full_name);
		
		password = new TextField();
		password.setPromptText("Password");
		password.setId("password");
		password.setFocusTraversable(false);
		registerLO.getChildren().add(password);
		password.setPadding(new Insets(10, 10, 10, 10));
		password.setTranslateX(50);
		password.setTranslateY(fullName.getTranslateY());
		password.setMaxWidth(registerScene.getWidth() - 2 * password.getTranslateX());
		Tooltip tooltip_password = new Tooltip("Enter password");
		tooltip_password.setShowDelay(new Duration(10));
		password.setTooltip(tooltip_password);
		
		button = new Button("Next");
		button.setFocusTraversable(false);
		registerLO.getChildren().add(button);
		button.setPadding(new Insets(10, 10, 10, 10));
		button.setTranslateX(50);
		button.setTranslateY(password.getTranslateY());
		button.setMaxWidth(registerScene.getWidth() - 2 * button.getTranslateX());
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.BLUE);
		button.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> button.setEffect(shadow));
		button.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> button.setEffect(null));
		button.setOnAction((event) -> setRegisterScene_addPhoto());
		
		wrongMessage = new Label("You haven't input full name or password!!!");
		wrongMessage.setFocusTraversable(false);
		registerLO.getChildren().add(wrongMessage);
		wrongMessage.setId("wrongMessage");
		wrongMessage.setTranslateX(50);
		wrongMessage.setTranslateY(button.getTranslateY());
		wrongMessage.setTextFill(Color.RED);
		wrongMessage.setVisible(false);
		
		hLogIn = new Hyperlink("Already have an account? Log in.");
		hLogIn.setFocusTraversable(false);
		hLogIn.setId("logIn");
		registerLO.getChildren().add(hLogIn);
		hLogIn.setTranslateY(button.getTranslateY() + 251);
		hLogIn.setMaxWidth(registerScene.getWidth());
		hLogIn.setAlignment(Pos.CENTER);
		hLogIn.setFont(Font.font(14));
		hLogIn.setTextFill(Color.GRAY);
		
		hLogIn.setOnAction((event) -> new LogIn(stage).setLoginScene());
		
		stage.setScene(registerScene);
		stage.show();
		stage.setOnCloseRequest((t) -> System.exit(0));
	}
	
	public void setRegisterScene_addPhoto() {
		registerLO = new VBox();
		registerLO.setSpacing(10);
		registerLO.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		registerScene = new Scene(registerLO, 500, 750);
		registerScene.getStylesheets().add(getClass().getResource("sign_up.css").toExternalForm());

		addPhotoImg = new Image("file:///C:/Users/Denis/Desktop/Instagram_images/add_photo.png");
		
		addPhoto = new Circle(175,(registerScene.getHeight()) / 2. - 125, 125); 
		addPhoto.setStroke(Color.BLACK); 
		addPhoto.setStrokeWidth(5);
		addPhoto.setEffect(new DropShadow(+25d, 0d, +2d, Color.CORNFLOWERBLUE));
		
		addPhoto.setFill(new ImagePattern(addPhotoImg));

		registerLO.getChildren().add(addPhoto);
		
		addPhoto.setTranslateX((registerScene.getWidth() - addPhotoImg.getWidth()) / 2.);
		addPhoto.setTranslateY((registerScene.getHeight()) / 2. - addPhotoImg.getHeight());
		
		title = new Label("Add Profile Photo");
		title.setId("title");
		registerLO.getChildren().add(title);
		title.setTranslateX(50);
		title.setTranslateY(addPhoto.getTranslateY());
		title.setMaxWidth(registerScene.getWidth() - 2 * title.getTranslateX());
		title.setAlignment(Pos.CENTER);
		title.setFont(Font.font(36));
		
		subtitle = new Label("Add a profile photo so your friends know \n\t\t\t   it's you.");
		subtitle.setId("subtitle");
		registerLO.getChildren().add(subtitle);
		subtitle.setTranslateX(50);
		subtitle.setTranslateY(title.getTranslateY());
		subtitle.setMaxWidth(registerScene.getWidth() - 2 * title.getTranslateX());
		subtitle.setAlignment(Pos.CENTER);
		subtitle.setFont(Font.font(20));
		
		photo = new TextField();
		photo.setPromptText("Photo URL");
		photo.setId("photo");
		photo.setFocusTraversable(false);
		registerLO.getChildren().add(photo);
		photo.setPadding(new Insets(10, 10, 10, 10));
		photo.setTranslateX(50);
		photo.setTranslateY(subtitle.getTranslateY());
		photo.setMaxWidth(registerScene.getWidth() - 2 * photo.getTranslateX());
		Tooltip tooltip_photo = new Tooltip("Enter url of the photo");
		tooltip_photo.setShowDelay(new Duration(10));
		photo.setTooltip(tooltip_photo);
		
		button = new Button("Add a Photo");
		button.setFocusTraversable(false);
		registerLO.getChildren().add(button);
		button.setPadding(new Insets(10, 10, 10, 10));
		button.setTranslateX(50);
		button.setTranslateY(subtitle.getTranslateY());
		button.setMaxWidth(registerScene.getWidth() - 2 * button.getTranslateX());
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.BLUE);
		button.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> button.setEffect(shadow));
		button.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> button.setEffect(null));
		//button.setOnAction((event) -> setRegisterScene_second());
		
		Button skip = new Button("Skip");
		skip.setId("skip");
		skip.setFocusTraversable(false);
		registerLO.getChildren().add(skip);
		skip.setPadding(new Insets(10, 10, 10, 10));
		skip.setTranslateX(50);
		skip.setTranslateY(button.getTranslateY());
		skip.setMaxWidth(registerScene.getWidth() - 2 * skip.getTranslateX());
		skip.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> skip.setEffect(shadow));
		skip.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> skip.setEffect(null));
		skip.setAlignment(Pos.CENTER);
		skip.setOnAction((event) -> new Display(stage).setProfileScene());
		
		button.setOnAction((event) -> {
			addPhotoImg = new Image("file:///" + photo.getText());
			addPhoto.setFill(new ImagePattern(addPhotoImg));
			
			skip.setText("Next");
		});
		
		stage.setScene(registerScene);
		stage.show();
		stage.setOnCloseRequest((t) -> System.exit(0));
	}
	
}
