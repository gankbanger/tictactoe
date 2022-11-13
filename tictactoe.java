import java.util.Scanner;

public class tictactoe {

	private int[][] casillas = new int[3][3]; // TABLERO
	private int numeroTurno = 0; // TURNO JUGADOR
	private int jug = 0;
	private Scanner teclado = null;
	private int fila = 0;
	private int columna = 0;

	public static void main(String[] args) {
		tictactoe juego = new tictactoe();
		juego.jugar();
	}

	public void jugar() {

		System.out.println("◝(ᵔᵕᵔ)◜ ¡TIC TAC TOE! ◝(ᵔᵕᵔ)◜\n");

		try (Scanner input = new Scanner(System.in)) {
			this.teclado = input;
			do {
				determinarSiguienteTurno();
				jugarTurno();
				imprimirTablero();
			} while (!verificarSiHayGanador());
		}
		System.out.println("\nFIN DEL PROGRAMA! ◝(ᵔᵕᵔ)◜");

	}

	private void determinarSiguienteTurno() {
		jug = (numeroTurno++ % 2) + 1;
		System.out.println("Turno del jugador " + jug + ".");
	}

	private void jugarTurno() {

		while (true) {
			do {
				System.out.println("Dime la fila:");
				fila = teclado.nextInt();
			} while (fila < 1 || fila > 3);

			do {
				System.out.println("Dime la columna:");
				columna = teclado.nextInt();
			} while (columna < 1 || columna > 3);

			if (casillas[fila - 1][columna - 1] == 0) {
				casillas[fila - 1][columna - 1] = jug;
				return;
			}
			System.out.println("La posicion ya está ocupada");
		}

	}

	private void imprimirTablero() {
		System.out.print("\n\t---\t---\t---\n\t|1|\t|2|\t|3|\n\t---\t---\t---\n\n");

		for (int i = 0; i < 3; i++) {
			System.out.print("---\n|" + (i + 1) + "|");
			for (int j = 0; j < 3; j++) {
				System.out.print("\t " + casillas[i][j]);
			}
			System.out.println("\n---\n");
		}
	}

	private boolean verificarSiHayGanador() {

		if ((casillas[fila - 1][0] == jug && casillas[fila - 1][1] == jug && casillas[fila - 1][2] == jug) ||
				(casillas[0][columna - 1] == jug && casillas[1][columna - 1] == jug && casillas[2][columna - 1] == jug) ||
				(casillas[0][0] == jug && casillas[1][1] == jug && casillas[2][2] == jug) ||
				(casillas[0][2] == jug && casillas[1][1] == jug && casillas[2][0] == jug)) {
			System.out.println("El jugador " + jug + " ha ganado");
			return true;
		}

		// Empate
		if (casillas[0][0] != 0 && casillas[0][1] != 0 && casillas[0][2] != 0 &&
				casillas[1][0] != 0 && casillas[1][1] != 0 && casillas[1][2] != 0 &&
				casillas[2][0] != 0 && casillas[2][1] != 0 && casillas[2][2] != 0) {
			System.out.println("Empate!");
			return true;
		}

		return false;
	}
}
