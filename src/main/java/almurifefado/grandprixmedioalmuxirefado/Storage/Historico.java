package almurifefado.grandprixmedioalmuxirefado.Storage;

import java.util.ArrayList;

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
}