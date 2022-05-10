package modelo;

import java.sql.Date;

public class VentasDTO {
	int numVenta;
	int codProducto;
	String nomProducto;
	String famProducto;
	int cantidVendida;
	String fechaVenta;
	int numEmpleado;
	
	public VentasDTO(int numVenta, int codProducto, String nomProducto, String famProducto, int cantidVendida, String fechaVenta, int numEmpleado) {
		this.numVenta = numVenta;
		this.codProducto = codProducto;
		this.nomProducto = nomProducto;
		this.famProducto = famProducto;
		this.cantidVendida = cantidVendida;
		this.fechaVenta = fechaVenta;
		this.numEmpleado = numEmpleado;
	}
	
	public VentasDTO() {
		this.numVenta = 0;
		this.codProducto = 0;
		this.nomProducto = "";
		this.famProducto = "";
		this.cantidVendida = 0;
		this.fechaVenta = "";
		this.numEmpleado = 0;
	}

	public int getNumVenta() {
		return numVenta;
	}

	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public String getFamProducto() {
		return famProducto;
	}

	public void setFamProducto(String famProducto) {
		this.famProducto = famProducto;
	}

	public int getCantidVendida() {
		return cantidVendida;
	}

	public void setCantidVendida(int cantidVendida) {
		this.cantidVendida = cantidVendida;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
}
