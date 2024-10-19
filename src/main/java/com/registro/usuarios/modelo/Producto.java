package com.registro.usuarios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="productos")
public class Producto {
    @Id
    @Min(value = 1, message = "El ID del producto debe ser mayor que 0")
    private int id_producto;
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Column(name = "nombre")
    private String nombre;
    private String precio;
    @NotBlank(message = "La clase no puede estar en blanco")
    @Size(min = 3, max = 50, message = "La clase debe tener entre 3 y 50 caracteres")
    @Column(name = "clase")
    private String clase;

    public Producto() {
        super();
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", precio=" + precio + ", clase="
                + clase + "]";
    }
}
