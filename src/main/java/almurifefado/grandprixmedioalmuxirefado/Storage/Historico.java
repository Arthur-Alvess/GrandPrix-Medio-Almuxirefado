package almurifefado.grandprixmedioalmuxirefado.Storage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Historico {
    private ArrayList<String> registros;

    public Historico() {
        this.registros = new ArrayList<>();
    }

    public void adicionarRegistro(String registro) {
        registros.add(registro);
    }

    public ArrayList<String> getRegistros() {
        return registros;
    }

    public void salvarDados() {
        try (FileWriter writer = new FileWriter("src/main/java/almurifefado/grandprixmedioalmuxirefado/ConsoleApplication/Jsons/historico.json")) {
            Gson gson = new Gson();
            gson.toJson(registros, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDados() {
        try (FileReader reader = new FileReader("src/main/java/almurifefado/grandprixmedioalmuxirefado/ConsoleApplication/Jsons/historico.json")) {
            Gson gson = new Gson();
            registros = gson.fromJson(reader, new TypeToken<ArrayList<String>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}