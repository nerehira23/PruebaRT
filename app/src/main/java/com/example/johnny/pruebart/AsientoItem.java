package com.example.johnny.pruebart;

public class AsientoItem {
    String id;
    String debe;
    String descripcion;
    String estado;
    String haber;
    String fecha;
    String transacion_id;
    String user_id;

    public String getId() {
        return id;
    }

    public String getHaber() {
        return haber;
    }

    public void setHaber(String haber) {
        this.haber = haber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDebe() {
        return debe;
    }

    public void setDebe(String debe) {
        this.debe = debe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTransacion_id() {
        return transacion_id;
    }

    public void setTransacion_id(String transacion_id) {
        this.transacion_id = transacion_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
