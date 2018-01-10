package application;

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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LogIn {
	
	private VBox loginLO;
	private Scene loginScene;

	private Image logoImg;
	private ImageView logo;

	private TextField login;
	private PasswordField password;
	
	private Button logIn;
	
	private Hyperlink signUp;
	
	private Label wrongMessage;
	
	Stage stage;
	
	LogIn(Stage stage){
		this.stage = stage;
		setLoginScene();
	}
	
	public void setLoginScene() {
		loginLO = new VBox();
		loginLO.setSpacing(10);
		loginLO.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		loginScene = new Scene(loginLO, 500, 750);
		loginScene.getStylesheets().add(getClass().getResource("log_in.css").toExternalForm());

		logoImg = new Image("file:///C:/Users/Denis/Desktop/Instagram_images/logo.png");
		logo = new ImageView(logoImg);

		loginLO.getChildren().add(logo);
		logo.setTranslateX((loginScene.getWidth() - logoImg.getWidth()) / 2);
		logo.setTranslateY((loginScene.getHeight()) / 2 - 1.5 * logoImg.getHeight());

		login = new TextField();
		login.setPromptText("Login");
		login.setFocusTraversable(false);
		loginLO.getChildren().add(login);
		login.setPadding(new Insets(10, 10, 10, 10));
		login.setTranslateX(50);
		login.setTranslateY(logo.getTranslateY());
		login.setMaxWidth(loginScene.getWidth() - 2 * login.getTranslateX());
		login.setId("login");
		Tooltip tooltip_login = new Tooltip("Enter Login");
		tooltip_login.setShowDelay(new Duration(10));
		login.setTooltip(tooltip_login);

		password = new PasswordField();
		password.setPromptText("Password");
		password.setFocusTraversable(false);
		loginLO.getChildren().add(password);
		password.setPadding(new Insets(10, 10, 10, 10));
		password.setTranslateX(50);
		password.setTranslateY(login.getTranslateY() + login.getHeight());
		password.setMaxWidth(loginScene.getWidth() - 2 * password.getTranslateX());
		password.setId("password");
		Tooltip tooltip_password = new Tooltip("Enter Password");
		tooltip_password.setShowDelay(new Duration(10));
		password.setTooltip(tooltip_password);
		//add show password
		
		logIn = new Button("Log In");
		logIn.setFocusTraversable(false);
		loginLO.getChildren().add(logIn);
		logIn.setPadding(new Insets(10, 10, 10, 10));
		logIn.setTranslateX(50);
		logIn.setTranslateY(password.getTranslateY() + password.getHeight());
		logIn.setMaxWidth(loginScene.getWidth() - 2 * logIn.getTranslateX());
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.BLUE);
		logIn.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> logIn.setEffect(shadow));
		logIn.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> logIn.setEffect(null));
		
		wrongMessage = new Label("Wrong username or password!!!");
		wrongMessage.setFocusTraversable(false);
		loginLO.getChildren().add(wrongMessage);
		wrongMessage.setId("wrongMessage");
		wrongMessage.setTranslateX(50);
		wrongMessage.setTranslateY(logIn.getTranslateY());
		wrongMessage.setTextFill(Color.RED);
		wrongMessage.setVisible(false);
				
		signUp = new Hyperlink("Don't have an account? Sign up.");
		signUp.setFocusTraversable(false);
		signUp.setId("signUp");
		loginLO.getChildren().add(signUp);
		signUp.setTranslateY(logIn.getTranslateY() + 200);
		signUp.setMaxWidth(loginScene.getWidth());
		signUp.setAlignment(Pos.CENTER);
		signUp.setFont(Font.font(14));
		signUp.setTextFill(Color.GRAY);
		
		signUp.setOnAction((event) -> new SignUp(stage).setRegisterScene_first());

		stage.setScene(loginScene);
		stage.show();
		stage.setOnCloseRequest((t) -> System.exit(0));
	}

}
