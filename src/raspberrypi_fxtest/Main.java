package raspberrypi_fxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("page1.fxml"));
			Scene scene = new Scene(root,320,240);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
		primaryStage.showingProperty().addListener((observable, oldValue, newValue) -> {
		    if (oldValue == true && newValue == false) {
		    }
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}