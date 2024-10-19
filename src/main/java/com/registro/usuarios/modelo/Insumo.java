package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "insumos")
public class Insumo {
    
    @Id
    @Min(value = 1, message = "El ID del insumo debe ser mayor que 0")
    private int idInsumo;
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nomInsumo;
    @Size(min = 5, max = 200, message = "La descripción debe tener entre 5 y 200 caracteres")
    private String descrip;
    private String precioDeProveedor;
    @Size(min = 3, max = 50, message = "La clase debe tener entre 3 y 50 caracteres")
    private String clase;
    private String nitPanaderia;
    @Size(min = 3, max = 20, message = "El NIT del proveedor debe tener entre 3 y 20 caracteres")
    private String nitProveedor;
    @Size(min = 3, max = 50, message = "El nombre del proveedor debe tener entre 3 y 50 caracteres")
    private String nomProveedor;
    
    
	public Insumo() {
		super();
	}
	
	public int getIdInsumo() {
		return idInsumo;
	}
	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}
	public String getNomInsumo() {
		return nomInsumo;
	}
	public void setNomInsumo(String nomInsumo) {
		this.nomInsumo = nomInsumo;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getPrecioDeProveedor() {
		return precioDeProveedor;
	}
	public void setPrecioDeProveedor(String precioDeProveedor) {
		this.precioDeProveedor = precioDeProveedor;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getNitPanaderia() {
		return nitPanaderia;
	}
	public void setNitPanaderia(String nitPanaderia) {
		this.nitPanaderia = nitPanaderia;
	}
	public String getNitProveedor() {
		return nitProveedor;
	}
	public void setNitProveedor(String nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public String getNomProveedor() {
		return nomProveedor;
	}
	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}
	@Override
	public String toString() {
		return "Insumo [idInsumo=" + idInsumo + ", nomInsumo=" + nomInsumo + ", descrip=" + descrip
				+ ", precioDeProveedor=" + precioDeProveedor + ", clase=" + clase + ", nitPanaderia=" + nitPanaderia
				+ ", nitProveedor=" + nitProveedor + ", nomProveedor=" + nomProveedor + "]";
	}
    
    
}
