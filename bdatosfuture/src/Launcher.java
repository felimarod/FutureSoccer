
import presentacion.*;

public class Launcher {

    public static void main(String[] args) {
        
        VistaMenu menu = new VistaMenu();
        VistaRegistrar registrar = new VistaRegistrar();
        VistaBuscarJugadora buscar = new VistaBuscarJugadora();
        new Controlador(menu, registrar, buscar);

    }

}
