package br.com.lynnick.projeto.model;

public enum Status {

	ABERTO(1),
	FECHADA(2);
	
	public int valorStatus;
	
	Status(int valor){
		valorStatus=valor;
	}
}
