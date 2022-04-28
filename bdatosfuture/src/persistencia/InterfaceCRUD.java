package persistencia;

import java.util.List;

public interface InterfaceCRUD <T, PARAM>{
    void guardarObjeto(T objeto);
    List<T> obtenerDatosPorParametro(PARAM parametro);
    void eliminarObjeto(PARAM parametro);
    String getNameTabla();
}
