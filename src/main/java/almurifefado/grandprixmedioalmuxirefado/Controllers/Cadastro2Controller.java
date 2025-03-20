package almurifefado.grandprixmedioalmuxirefado.Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Cadastro2Controller {

    @FXML
    private void onClickBtnVoltar(ActionEvent event) throws IOException {
        Parent loginRoot = FXMLLoader.load(getClass().getResource("/almurifefado/grandprixmedioalmuxirefado/CadastroView.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loginRoot));
        stage.setTitle("Login");
        stage.show();
    }
}