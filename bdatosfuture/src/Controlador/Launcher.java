package Controlador;

import vista.BuscarJugadora;
import vista.Menu;
import vista.Registrar;

public class Launcher {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Registrar registrar = new Registrar();
        BuscarJugadora buscar = new BuscarJugadora();
        Controlador control = new Controlador(menu, registrar, buscar);

    }

}
