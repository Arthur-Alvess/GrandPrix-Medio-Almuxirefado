package almurifefado.grandprixmedioalmuxirefado.Storage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

    public void salvarDados() {
        try (FileWriter writer = new FileWriter("src/main/java/almurifefado/grandprixmedioalmuxirefado/ConsoleApplication/Jsons/listaFuncionarios.json")) {
            Gson gson = new Gson();
            gson.toJson(funcionarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDados() {
        try (FileReader reader = new FileReader("src/main/java/almurifefado/grandprixmedioalmuxirefado/ConsoleApplication/Jsons/listaFuncionarios.json")) {
            Gson gson = new Gson();
            funcionarios = gson.fromJson(reader, new TypeToken<ArrayList<Funcionário>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}