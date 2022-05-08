package modelo;

public class UsuarioDTO {
	private String nomUsu;
	private int numEmpl;
	private String contr;
	private String usuAdmin;
	
	public UsuarioDTO(String nomUsu, int numEmpl, String contr, String usuAdmin) {
		this.nomUsu=nomUsu;
		this.numEmpl=numEmpl;
		this.contr=contr;
		this.usuAdmin=usuAdmin;
	}
	
	public UsuarioDTO() {
		this.nomUsu="";
		this.numEmpl=0;
		this.contr="";
		this.usuAdmin="";
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public int getNumEmpl() {
		return numEmpl;
	}

	public void setNumEmpl(int numEmpl) {
		this.numEmpl = numEmpl;
	}

	public String getContr() {
		return contr;
	}

	public void setContr(String contr) {
		this.contr = contr;
	}

	public String getUsuAdmin() {
		return usuAdmin;
	}

	public void setUsuAdmin(String usuAdmin) {
		this.usuAdmin = usuAdmin;
	}
}
