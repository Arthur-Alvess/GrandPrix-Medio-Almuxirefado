package almurifefado.grandprixmedioalmuxirefado.Storage;

import java.util.ArrayList;
import almurifefado.grandprixmedioalmuxirefado.Models.Funcionário;

public class ListaFuncionários {
    private ArrayList<Funcionário> funcionarios;

    public ListaFuncionários() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionário funcionario) {
        funcionarios.add(funcionario);
    }

    public ArrayList<Funcionário> getFuncionarios() {
        return funcionarios;
    }

    public Funcionário buscarFuncionario(String cpf) {
        for (Funcionário funcionario : funcionarios) {
            if (funcionario.getCpf().toString().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public void removerFuncionario(Funcionário funcionario) {
        funcionarios.remove(funcionario);
    }
}