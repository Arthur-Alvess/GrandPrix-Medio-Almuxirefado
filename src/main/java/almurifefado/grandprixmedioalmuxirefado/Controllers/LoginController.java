package almurifefado.grandprixmedioalmuxirefado.Controllers;

import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class LoginController {
    @FXML
    private Label LabelMessage;

    @FXML
    protected void onHelloButtonClick() {
        LabelMessage.setText("Cala boca mininin");
        LabelMessage.setStyle("-fx-text-fill: red;");
    }

}