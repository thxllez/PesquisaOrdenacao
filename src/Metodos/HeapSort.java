package Metodos;

import Objetos.Vaga;

public class HeapSort { //IMPLEMENTAR MÉTODO PARA ORDENAR CHAVES SECUNDÁRIAS
	
	private static int nElem;
	private static Vaga[] vetor;
	
	public void heapSort (Vaga[] vaga){
		vetor = vaga;
		nElem = vaga.length;
		
		int dir = nElem-1;
		int esq = (dir-1)/2;
		Vaga temp;

		while (esq >= 0){
			refazHeap (esq, this.nElem-1);
			esq--;
		}
		while (dir > 0){
			temp = this.vetor[0];
			this.vetor [0] = this.vetor [dir];
			this.vetor [dir] = temp;
			dir--;
			refazHeap(0, dir);
		}
	} 
	
	private void refazHeap (int esq, int dir){
		int i = esq;
		int mF = 2*i+1; // maior filho
		Vaga raiz = this.vetor[i];
		boolean heap = false;

		while ((mF <= dir) && (!heap)){
			if ( mF < dir) {
				//if (this.vetor[mF].getCargo() < this.vetor[mF+1].getCargo()) {
				if(this.vetor[mF].getCargo().compareToIgnoreCase(this.vetor[mF+1].getCargo()) < 0) {
					mF ++;
				}
			}
			//if (raiz.getCargo() < this.vetor[mF].getCargo()) {
			if(raiz.getCargo().compareToIgnoreCase(this.vetor[mF].getCargo()) < 0) {
				this.vetor[i] = this.vetor[mF];
				i = mF;
				mF = 2*i+1;
			}
			else {
				heap = true;
			}
		}
		this.vetor[i] = raiz;
	}
}
