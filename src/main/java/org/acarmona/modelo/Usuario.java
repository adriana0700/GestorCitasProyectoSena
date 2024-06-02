package org.acarmona.modelo;

import java.util.Date;

public class Usuario {
    private Long id;
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private Integer edad;
    private String fechaCita;

    @Override
    public String toString() {
        return id +
                " | " +
                nombre +
                " | " +
                edad +
                " | " +
                tipoDocumento +
                "|" +
                numeroDocumento +
                "|" +
                fechaCita;
    }
    public Usuario() {
    }

    public Usuario(Long id, String nombre, String tipoDocumento, String numeroDocumento, Integer edad, String fechaCita) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.edad = edad;
        this.fechaCita = fechaCita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }
}
