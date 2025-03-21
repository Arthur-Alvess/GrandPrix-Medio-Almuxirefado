package almurifefado.grandprixmedioalmuxirefado.Storage;

import java.util.ArrayList;
import almurifefado.grandprixmedioalmuxirefado.Models.Item;

public class ItensRetirados {
    private ArrayList<Item> itens;

    public ItensRetirados() {
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
}