package application;

import model.Chamado;

public class Application {
	
	public static void main(String[] args) {
		System.out.println("Eu sou o seu primeiro programa.");
		Chamado chamado = new Chamado("Acabou a Luz", "Francine Flores", "Rua Frederico Eick, 150");
		System.out.println(chamado.getNomeSolicitante());
	}
}
