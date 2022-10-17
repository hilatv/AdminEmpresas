package com.example.Yerizk.model;
import javax.persistence.*;

@Entity
@Table(name="MovimientoDinero")

public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="montoDinero")
    private String montoDinero;

    @Column(name="montoPositivo")
    private String montoPositivo;

    @Column(name="montoNegativo")
    private String montoNegativo;

    @Column(name="conceptoMovimiento")
    private String conceptoMovimiento;

    //@Column(name="usuarioEncargado")
    //private String usuarioEncargado;

    @ManyToOne()
    private Empleado empleado;

    public MovimientoDinero(){}


    public MovimientoDinero(String montoDinero, String montoPositivo, String montoNegativo, String conceptoMovimiento, Empleado empleado) {
        this.montoDinero = montoDinero;
        this.montoPositivo = montoPositivo;
        this.montoNegativo = montoNegativo;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleado = empleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMontoDinero() {
        return this.montoDinero;
    }

    public void setMontoDinero(String montoDinero) {
        this.montoDinero = montoDinero;
    }

    public String getMontoPositivo() {
        return this.montoPositivo;
    }

    public void setMontoPositivo(String montoPositivo) {
        this.montoPositivo = montoPositivo;
    }

    public String getMontoNegativo() {
        return this.montoNegativo;
    }

    public void setMontoNegativo(String montoNegativo) {
        this.montoNegativo = montoNegativo;
    }

    public String getConceptoMovimiento() {
        return this.conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public static void main(String[] args) {

    }

}
