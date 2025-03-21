package almurifefado.grandprixmedioalmuxirefado.Storage;

import java.util.ArrayList;
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
}