package modelo;

import java.sql.Date;

public class VentasDTO {
	int numVenta;
	String codProducto;
	String nomProducto;
	String cantidVendida;
	String fechaVenta;
	String numEmpleado;
	
	public VentasDTO(int numVenta, String codProducto, String nomProducto, String cantidVendida, String fechaVenta, String numEmpleado) {
		this.numVenta = numVenta;
		this.codProducto = codProducto;
		this.nomProducto = nomProducto;
		this.cantidVendida = cantidVendida;
		this.fechaVenta = fechaVenta;
		this.numEmpleado = numEmpleado;
	}
	
	public VentasDTO() {
		this.numVenta = 0;
		this.codProducto = "0";
		this.nomProducto = "";
		this.cantidVendida = "0";
		this.fechaVenta = "";
		this.numEmpleado = "0";
	}

	public String getCodProducto() {
		return codProducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public String getCantidVendida() {
		return cantidVendida;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public String getNumEmpleado() {
		return numEmpleado;
	}
}
