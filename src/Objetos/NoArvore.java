package Objetos;

public class NoArvore {
	
	private Vaga info;
	private NoArvore dir, esq;
	 
	public NoArvore (Vaga _info){
		 this.info = _info;
	 }
	
	public NoArvore getDir() {
		return dir;
	}
	
	public void setDir(NoArvore dir) {
		this.dir = dir;
	}
	
	public NoArvore getEsq() {
		return esq;
	}
	
	public void setEsq(NoArvore esq) {
		this.esq = esq;
	}
	
	public Vaga getInfo() {
		return info;
	}
	
	public void setInfo(Vaga novo) {
		this.info = novo;
	}
	
	} 
