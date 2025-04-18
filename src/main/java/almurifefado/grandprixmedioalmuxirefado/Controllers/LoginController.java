package almurifefado.grandprixmedioalmuxirefado.Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Label LabelMessage;

    @FXML
    private void onClickBtnCadastro(ActionEvent event) throws IOException {
        Parent cadastroRoot = FXMLLoader.load(getClass().getResource("/almurifefado/grandprixmedioalmuxirefado/CadastroView.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(cadastroRoot));
        stage.setTitle("Cadastro");
        stage.show();
    }

}