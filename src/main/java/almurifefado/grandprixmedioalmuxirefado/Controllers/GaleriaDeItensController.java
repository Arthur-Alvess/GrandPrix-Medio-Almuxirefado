package almurifefado.grandprixmedioalmuxirefado.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;

public class GaleriaDeItensController {

        @FXML
        private TextField usernameField;
        @FXML
        private PasswordField passwordField;

        @FXML
        public void handleLoginButtonClick() {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Erro", "Usuário e senha não podem estar vazios!");
            } else {
                System.out.println("Usuário: " + username + " - Senha: " + password);
            }
        }

        private void showAlert(String title, String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }
