package com.example.Yerizk.dto;

public class EmpresaDto {

    private long id;
    private String nombre;
    private String direccion;
    private String telefono;
    public String nit;



    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }



    public static void main(String[] args) {

    }

    public Long getId() {return this.id;}
}
