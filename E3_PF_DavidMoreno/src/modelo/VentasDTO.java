package modelo;

import java.sql.Date;
/**
 * Clase que crea el objeto VentasDTO
 * @author David
 *
 */
public class VentasDTO {
	/**
	 * Numero de venta
	 */
	int numVenta;
	/**
	 * Codigo de producto
	 */
	int codProducto;
	/**
	 * Nombre de producto
	 */
	String nomProducto;
	/**
	 * Cantidad vendida
	 */
	int cantidVendida;
	/**
	 * Fecha de venta
	 */
	String fechaVenta;
	/**
	 * Numero de empleado
	 */
	int numEmpleado;
	/**
	 * Constructor de VentasDTO
	 * @param numVenta  Numero de venta
	 * @param codProducto Codigo de producto
	 * @param nomProducto Nombre de producto
	 * @param cantidVendida Cantidad vendida
	 * @param fechaVenta Fecha de venta
	 * @param numEmpleado Numero de empleado
	 */
	public VentasDTO(int numVenta, int codProducto, String nomProducto, int cantidVendida, String fechaVenta, int numEmpleado) {
		this.numVenta = numVenta;
		this.codProducto = codProducto;
		this.nomProducto = nomProducto;
		this.cantidVendida = cantidVendida;
		this.fechaVenta = fechaVenta;
		this.numEmpleado = numEmpleado;
	}
	/**
	 * Constructor vacio de VentasDTO
	 */
	public VentasDTO() {
		this.numVenta = 0;
		this.codProducto = 0;
		this.nomProducto = "";
		this.cantidVendida = 0;
		this.fechaVenta = "";
		this.numEmpleado = 0;
	}
	/**
	 * Devuelve el numero de venta
	 * @return numVenta
	 */
	public int getNumVenta() {
		return numVenta;
	}
	/**
	 * Devuelve el codigo de producto
	 * @return codProducto
	 */
	public int getCodProducto() {
		return codProducto;
	}
	/**
	 * Devuelve el nombre de producto
	 * @return nomProducto
	 */
	public String getNomProducto() {
		return nomProducto;
	}
	/**
	 * Devuelve la cantidad vendida
	 * @return cantidVendida
	 */
	public int getCantidVendida() {
		return cantidVendida;
	}
	/**
	 * Devuelve la fecha de venta
	 * @return fechaVenta
	 */
	public String getFechaVenta() {
		return fechaVenta;
	}
	/**
	 * Devuelve el numero de empleado
	 * @return numEmpleado
	 */
	public int getNumEmpleado() {
		return numEmpleado;
	}
}
