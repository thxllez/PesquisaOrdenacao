package Metodos;

import Objetos.Vaga;

public class PesquisaBinaria {
	private static int nElem;
	private static Vaga[] vetor;
	
	public PesquisaBinaria(Vaga[] vaga){
		 this.vetor = vaga;
	 }

	//MÉTODOS DE INSERÇÃO
	public boolean insere (Vaga elem){
		if (this.nElem == this.vetor.length) {
			return false;
		}
		else{
			this.vetor[this.nElem++] = elem;
			inserçãoDireta(vetor);//ordenação
		}
		return true;
	}
	
	//MÉTODOS DE REMOÇÃO
	public boolean remove (String chave){
		int i, pos;
		
		if (this.nElem == 0) {
			return false;
		}
		else{
			pos = pesqBinaria(chave);
			if (pos >= 0){
				for (i = pos + 1; i < this.nElem; i++)
				this.vetor[i-1] = this.vetor[i];
				this.nElem--;
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	//MÉTODOS DE PESQUISA
	public int pesqBinariaDupla (String cargo, String siglaEstado){
		int meio, esq, dir;
		esq = 0;
		dir = this.nElem-1;
		while (esq <= dir){
			meio = (esq + dir)/2;
			if (cargo == this.vetor[meio].getCargo() && siglaEstado == this.vetor[meio].getSiglaEstado()) {
				return meio;
			}
			else{
				//if (cargo < this.vetor[meio].getCargo()) {
				if(cargo.compareToIgnoreCase(this.vetor[meio].getCargo()) < 0) {
					dir = meio - 1;
				}
				else {
					esq = meio + 1;
				}
			}
		}
		return -1;
	}
	
	public int pesqBinaria (String cargo){
		int meio, esq, dir;
		esq = 0;
		dir = this.nElem-1;
		while (esq <= dir){
			meio = (esq + dir)/2;
			if (cargo == this.vetor[meio].getCargo()) {
				return meio;
			}
			else{
				//if (cargo < this.vetor[meio].getCargo()) {
				if(cargo.compareToIgnoreCase(this.vetor[meio].getCargo()) < 0) {
					dir = meio - 1;
				}
				else {
					esq = meio + 1;
				}
			}
		}
		return -1;
	}
	
	//INSERÇÃO DIRETA
	public void inserçãoDireta(Vaga[] vaga){
		vetor = vaga;
		nElem = vaga.length;
		
		int i, j;
		Vaga temp;
		for (i=1; i < this.nElem; i++){
			temp = this.vetor[i];
			j = i-1;
			//while ((j >= 0) && (this.vetor[j].getCargo() > temp.getCargo())){
			while ((j >= 0) && (this.vetor[j].getCargo().compareToIgnoreCase(temp.getCargo()) > 0)){
				this.vetor [j+1] = this.vetor[j];
				j--;
			}
			this.vetor [j+1] = temp;
		}
	}
}
