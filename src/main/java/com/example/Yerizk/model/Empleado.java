package com.example.Yerizk.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="correo")
    private String correo;

    //@Column(name="empresa")
    //private String empresa;

    @Column(name="rol")
    private String rol;

    @ManyToOne()
    private Empresa empresa;

    @JsonIgnore
    @OneToMany(mappedBy = "empleado")
    private List<MovimientoDinero> movimientosDinero;


    public Empleado(){}


    public Empleado(String nombre, String correo, String rol, Empresa empresa, List<MovimientoDinero> movimientosDinero) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.empresa = empresa;
        this.movimientosDinero = movimientosDinero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<MovimientoDinero> getMovimientosDinero() {
        return movimientosDinero;
    }

    public void setMovimientosDinero(List<MovimientoDinero> movimientosDinero) {
        this.movimientosDinero = movimientosDinero;
    }

    public static void main(String[] args) {

    }

}

