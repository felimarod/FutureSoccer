package logica;

public class Jugadora {

    int Documento;
    String Nombres;
    String Apellidos;
    String RH;
    String EPS;
    String Posicion;
    String Piedom;
    String Telfijo;
    String Telcel;
    int categoria;
    int DocAcudiente;

    public int getDocAcudiente() {
        return DocAcudiente;
    }

    public void setDocAcudiente(int DocAcudiente) {
        this.DocAcudiente = DocAcudiente;
    }

    public Jugadora() {
    }

    public Jugadora(int Documento, String Nombres, String Apellidos, String RH, String Posicion, String Piedom, int categoria, int DocAcudiente) {
        this.Documento = Documento;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.RH = RH;
        this.Posicion = Posicion;
        this.Piedom = Piedom;
        this.categoria = categoria;
        this.DocAcudiente = DocAcudiente;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getRH() {
        return RH;
    }

    public void setRH(String RH) {
        this.RH = RH;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String Posicion) {
        this.Posicion = Posicion;
    }

    public String getPiedom() {
        return Piedom;
    }

    public void setPiedom(String Piedom) {
        this.Piedom = Piedom;
    }

    public String getTelfijo() {
        return Telfijo;
    }

    public void setTelfijo(String Telfijo) {
        this.Telfijo = Telfijo;
    }

    public String getTelcel() {
        return Telcel;
    }

    public void setTelcel(String Telcel) {
        this.Telcel = Telcel;
    }

    public int getDocumento() {
        return Documento;
    }

    public void setDocumento(int Documento) {
        this.Documento = Documento;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

}
