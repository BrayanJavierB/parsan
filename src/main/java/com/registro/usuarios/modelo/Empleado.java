package com.registro.usuarios.modelo;





import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;






@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
    private int id_empleado;
    private String nombre;
    private String apellido;
    private String edad;
    private String genero;
    private BigInteger telefono;
    private String cargo;
    private String salario;
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public BigInteger getTelefono() {
		return telefono;
	}
	public void setTelefono(BigInteger telefono) {
		this.telefono = telefono;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", nombre=" + nombre + ", apellido=" + apellido + ", edad="
				+ edad + ", genero=" + genero + ", telefono=" + telefono + ", cargo=" + cargo + ", salario=" + salario
				+ "]";
	}
    
    

    
}

		