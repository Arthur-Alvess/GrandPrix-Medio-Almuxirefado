package almurifefado.grandprixmedioalmuxirefado.Storage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import almurifefado.grandprixmedioalmuxirefado.Models.Item;

public class Estoque {
    private ArrayList<Item> itens;

    public Estoque() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public Item buscarItem(String codigo) {
        for (Item item : itens) {
            if (item.getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null;
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void salvarDados() {
        try (FileWriter writer = new FileWriter("src/main/java/almurifefado/grandprixmedioalmuxirefado/ConsoleApplication/Jsons/estoque.json")) {
            Gson gson = new Gson();
            gson.toJson(itens, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDados() {
        try (FileReader reader = new FileReader("src/main/java/almurifefado/grandprixmedioalmuxirefado/ConsoleApplication/Jsons/estoque.json")) {
            Gson gson = new Gson();
            itens = gson.fromJson(reader, new TypeToken<ArrayList<Item>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}