package modelo;

import java.sql.Date;

public class VentasDTO {
	int numVenta;
	int codProducto;
	String nomProducto;
	int cantidVendida;
	String fechaVenta;
	int numEmpleado;
	
	public VentasDTO(int numVenta, int codProducto, String nomProducto, int cantidVendida, String fechaVenta, int numEmpleado) {
		this.numVenta = numVenta;
		this.codProducto = codProducto;
		this.nomProducto = nomProducto;
		this.cantidVendida = cantidVendida;
		this.fechaVenta = fechaVenta;
		this.numEmpleado = numEmpleado;
	}
	
	public VentasDTO() {
		this.numVenta = 0;
		this.codProducto = 0;
		this.nomProducto = "";
		this.cantidVendida = 0;
		this.fechaVenta = "";
		this.numEmpleado = 0;
	}

	public int getNumVenta() {
		return numVenta;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public int getCantidVendida() {
		return cantidVendida;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public int getNumEmpleado() {
		return numEmpleado;
	}
}
