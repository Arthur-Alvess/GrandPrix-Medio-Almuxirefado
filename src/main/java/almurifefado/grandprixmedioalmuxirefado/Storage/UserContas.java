package almurifefado.grandprixmedioalmuxirefado.Storage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import almurifefado.grandprixmedioalmuxirefado.Models.User;

public class UserContas {
    private ArrayList<User> contasCadastradas;

    public UserContas() {
        this.contasCadastradas = new ArrayList<>();
    }

    public void adicionarUsuario(User user) {
        contasCadastradas.add(user);
    }

    public User autenticar(String emailCpf, String senha) {
        for (User user : contasCadastradas) {
            if ((user.getEmail().toString().equals(emailCpf) || user.getCpf().toString().equals(emailCpf)) && user.getSenha().equals(senha)) {
                return user;
            }
        }
        return null;
    }

    public void salvarDados() {
        try (FileWriter writer = new FileWriter("src/main/java/almurifefado/grandprixmedioalmuxirefado/ConsoleApplication/Jsons/userContas.json")) {
            Gson gson = new Gson();
            gson.toJson(contasCadastradas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDados() {
        try (FileReader reader = new FileReader("src/main/java/almurifefado/grandprixmedioalmuxirefado/ConsoleApplication/Jsons/userContas.json")) {
            Gson gson = new Gson();
            contasCadastradas = gson.fromJson(reader, new TypeToken<ArrayList<User>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}