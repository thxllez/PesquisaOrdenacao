package Objetos;

public class Vaga {
	private String cargo, empresa, siglaEstado;

	public Vaga(String cargo, String empresa, String siglaEstado) {
		this.cargo = cargo;
		this.empresa = empresa;
		this.siglaEstado = siglaEstado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	@Override
	public String toString() {
		return "Vaga [cargo=" + cargo + ", empresa=" + empresa + ", siglaEstado=" + siglaEstado + "]";
	}
	
}
