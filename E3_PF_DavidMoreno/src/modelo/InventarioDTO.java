package modelo;

public class InventarioDTO {
	private int codProducto;
	private String nomProducto;
	private String famProducto;
	private int cantidProducto;
	private double  precioProducto;
	private double ivaProducto;
	
	public InventarioDTO(int codProducto, String nomProducto, String famProducto, int cantidProducto, double  precioProducto, double ivaProducto) {
		this.codProducto=codProducto;
		this.nomProducto=nomProducto;
		this.famProducto=famProducto;
		this.cantidProducto=cantidProducto;
		this.precioProducto=precioProducto;
		this.ivaProducto=ivaProducto;
	}
	
	public InventarioDTO() {
		this.codProducto=0;
		this.nomProducto="";
		this.famProducto="";
		this.cantidProducto=0;
		this.precioProducto=0;
		this.ivaProducto=0;
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

	public int getCantidProducto() {
		return cantidProducto;
	}

	public void setCantidProducto(int cantidProducto) {
		this.cantidProducto = cantidProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public double getIvaProducto() {
		return ivaProducto;
	}

	public void setIvaProducto(double ivaProducto) {
		this.ivaProducto = ivaProducto;
	}

}
