package Metodos;

import Objetos.NoArvore;
import Objetos.Vaga;

public class ABB {
	
	 private NoArvore raiz;
	 
	 public ABB(){
		 this.raiz = null;
	 }
	 
	 //MÉTODOS DE INSERÇÃO
	public boolean insere (Vaga elem){
		
		//Considerando que podemos ter elementos com as três chaves iguais
		/*boolean existe;

		existe = this.pesquisa (elem.getChave());
		if (existe) {
			return false;
		}*/
		
		this.raiz = this.insere (elem, this.raiz);
		return true;
	}
	
	private NoArvore insere (Vaga elem, NoArvore no){
		NoArvore novo;

		if (no == null){
			novo = new NoArvore(elem);
			return novo;
		}
		else {
			//if (elem.getCargo() < no.getInfo().getCargo()){
			if (elem.getCargo().compareToIgnoreCase(no.getInfo().getCargo()) < 0) {
				no.setEsq(this.insere (elem, no.getEsq()));
				return no;
			}
			else{
				no.setDir(this.insere (elem, no.getDir()));
				return no;
			}
		}
		
		}
	
	//METODOS DE REMOÇÃO
	private NoArvore remove (String chave, NoArvore arv){
		if (arv == null) {
			return arv;
		}
		else{
			//if (chave < arv.getInfo().getCargo())
			if(chave.compareToIgnoreCase(arv.getInfo().getCargo()) < 0) {
				arv.setEsq(this.remove (chave, arv.getEsq()));
			}
			//else if (chave > arv.getInfo(). getCargo())
			else if(chave.compareToIgnoreCase(arv.getInfo().getCargo()) > 0) {
				arv.setDir(this.remove (chave, arv.getDir()));
			}
			else if (arv.getDir() == null) {
				return arv.getEsq();
			}
			else if (arv.getEsq() == null) {
				return arv.getDir();
			}
			else {
				arv.setEsq(this.arruma (arv, arv.getEsq()));
			}
		}
			return arv;
		}
	
	private NoArvore arruma (NoArvore Q, NoArvore R){
		if (R.getDir() != null) {
			R.setDir(this.arruma (Q, R.getDir()));
		}
		else{
			Q.setInfo(R.getInfo());
			R = R.getEsq();
		}
		return R;
	}
	
	//MÉTODOS DE PESQUISA
	public boolean pesquisa (String cargo){
		NoArvore temp;

		temp = this.pesquisa (cargo, this.raiz);
		
		if (temp != null) {
			return true;

		}else {
			return false;
		}
	}
	
	private NoArvore pesquisa (String cargo, NoArvore no){
		NoArvore temp;
		temp = no;

		if (temp != null){
			//if (chave < temp.getInfo().getChave()) {
			if (cargo.compareToIgnoreCase(temp.getInfo().getCargo()) < 0) {
				temp = this.pesquisa (cargo, temp.getEsq());
			}
			else{
				//if (chave > temp.getInfo().getChave())
				if (cargo.compareToIgnoreCase(temp.getInfo().getCargo()) > 0) {
					temp = this.pesquisa (cargo, temp.getDir());
				}
			}
		}
		
		return temp;
		
		}
	
	}
