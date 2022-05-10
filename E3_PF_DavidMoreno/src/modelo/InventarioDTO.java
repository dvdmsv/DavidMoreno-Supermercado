package modelo;

public class InventarioDTO {
	private int codProducto;
	private String nomProducto;
	private String famProducto;
	private int cantidProducto;
	private float  precioProducto;
	private float ivaProducto;
	
	public InventarioDTO(int codProducto, String nomProducto, String famProducto, int cantidProducto, float  precioProducto, float ivaProducto) {
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

	public float getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}

	public float getIvaProducto() {
		return ivaProducto;
	}

	public void setIvaProducto(float ivaProducto) {
		this.ivaProducto = ivaProducto;
	}

}
