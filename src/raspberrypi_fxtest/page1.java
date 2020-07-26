package raspberrypi_fxtest;

import java.io.File;
import java.net.URISyntaxException;
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
    void onBt1(ActionEvent event) throws URISyntaxException {
    	if( !flg ) {
    		flg= true;
	    	Platform.runLater(() ->lb1.setText("PLAY!"));

			//再生開始
			mp.play();
    	}else {
    		flg=false;
    		mp.pause();
	    	Platform.runLater(() ->lb1.setText("STOP"));
    	}
    }

    @FXML
    void initialize() throws URISyntaxException {
		//ファイルを読み込み
        String fileName = "sample2.wav";
        File jarFile = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        String inputFilePath = jarFile.getParent() + File.separator + fileName;
        Media m = new Media(new File(inputFilePath).toURI().toString());
		//音声の再生等の操作を実行できるオブジェクト
		mp = new MediaPlayer(m);

    }
}

