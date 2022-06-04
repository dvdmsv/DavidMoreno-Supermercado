package modelo;
/**
 * Clase que crea el objeto InventarioDTO
 * @author David
 *
 */
public class InventarioDTO {
	/**
	 * Codigo del producto
	 */
	private int codProducto;
	/**
	 * Nombre del producto
	 */
	private String nomProducto;
	/**
	 * Familia del producto
	 */
	private String famProducto;
	/**
	 * Cantidad del producto
	 */
	private int cantidProducto;
	/**
	 * Precio del producto
	 */
	private double  precioProducto;
	/**
	 * IVA del producto
	 */
	private double ivaProducto;
	/**
	 * Constructor de InventarioDTO
	 * @param codProducto Codigo del producto
	 * @param nomProducto Nombre del producto
	 * @param famProducto Familia del producto
	 * @param cantidProducto Cantidad del producto
	 * @param precioProducto Precio del producto
	 * @param ivaProducto IVA del producto
	 */
	public InventarioDTO(int codProducto, String nomProducto, String famProducto, int cantidProducto, double  precioProducto, double ivaProducto) {
		this.codProducto=codProducto;
		this.nomProducto=nomProducto;
		this.famProducto=famProducto;
		this.cantidProducto=cantidProducto;
		this.precioProducto=precioProducto;
		this.ivaProducto=ivaProducto;
	}
	
	/**
	 * Constructor vacio de InventarioDTO
	 */
	public InventarioDTO() {
		this.codProducto=0;
		this.nomProducto="";
		this.famProducto="";
		this.cantidProducto=0;
		this.precioProducto=0;
		this.ivaProducto=0;
	}
	/**
	 * Devuelve el codigo del producto
	 * @return codProducto
	 */
	public int getCodProducto() {
		return codProducto;
	}
	/**
	 * Devuelve el nombre del producto
	 * @return nomProducto
	 */
	public String getNomProducto() {
		return nomProducto;
	}
	/**
	 * Devuelve la familia del producto
	 * @return famProducto
	 */
	public String getFamProducto() {
		return famProducto;
	}
	/**
	 * Devuelve la cantidad del producto
	 * @return cantidProducto
	 */
	public int getCantidProducto() {
		return cantidProducto;
	}
	/**
	 * Devuelve el precio del producto
	 * @return precioProducto
	 */
	public double getPrecioProducto() {
		return precioProducto;
	}
	/**
	 * Devuelve el IVA del producto
	 * @return ivaProducto
	 */
	public double getIvaProducto() {
		return ivaProducto;
	}

	
}
