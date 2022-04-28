/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


public class Acudiente {
    
    int Documento;
    String Nombres;
    String Apellidos;
    String Telcel;
    String correo;

    public Acudiente(int Documento, String Nombres, String Apellidos, String Telcel) {
        this.Documento = Documento;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telcel = Telcel;
    }

    public Acudiente() {
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

    public String getTelcel() {
        return Telcel;
    }

    public void setTelcel(String Telcel) {
        this.Telcel = Telcel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
