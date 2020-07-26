package raspberrypi_fxtest;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class page1 {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button bt1;
    @FXML
    private Label lb1;

    boolean flg = false;
    MediaPlayer mp;
    @FXML
    void onBt1(ActionEvent event) {
    	if( !flg ) {
    		flg= true;
	    	Platform.runLater(() ->lb1.setText("PLAY!"));

			//ファイルを読み込み
			Media m = new Media(new File("sample2.wav").toURI().toString());

			//音声の再生等の操作を実行できるオブジェクト
			mp = new MediaPlayer(m);

			//再生開始
			mp.play();
    	}else {
    		flg=false;
    		mp.stop();
	    	Platform.runLater(() ->lb1.setText("STOP"));
    	}
    }

    @FXML
    void initialize() {
        assert bt1 != null : "fx:id=\"bt1\" was not injected: check your FXML file 'main.fxml'.";
        assert lb1 != null : "fx:id=\"lb1\" was not injected: check your FXML file 'main.fxml'.";

    }
}

