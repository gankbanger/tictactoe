import java.util.Scanner;

public class tictactoe {

	private int[][] tablero = new int[3][3]; // TABLERO
	private int numeroTurno = 0; // TURNO JUGADOR
	private int turnoDe = 0;
	private Scanner teclado = null;

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
		turnoDe = (numeroTurno++ % 2) + 1;
		System.out.println("Turno del jugador " + turnoDe + ".");
	}

	private void jugarTurno() {
		int columna;
		int fila;

		while (true) {
			do {
				System.out.println("Dime la fila:");
				fila = teclado.nextInt();
			} while (fila < 1 || fila > 3);

			do {
				System.out.println("Dime la columna:");
				columna = teclado.nextInt();
			} while (columna < 1 || columna > 3);

			if (tablero[fila - 1][columna - 1] == 0) {
				tablero[fila - 1][columna - 1] = turnoDe;
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
				System.out.print("\t " + tablero[i][j]);
			}
			System.out.println("\n---\n");
		}
	}


	private boolean verificarSiHayGanador() {

		if ((tablero[0][0] == turnoDe && tablero[0][1] == turnoDe && tablero[0][2] == turnoDe) ||
				(tablero[1][0] == turnoDe && tablero[1][1] == turnoDe && tablero[1][2] == turnoDe) ||
				(tablero[2][0] == turnoDe && tablero[2][1] == turnoDe && tablero[2][2] == turnoDe) ||
				(tablero[0][0] == turnoDe && tablero[1][0] == turnoDe && tablero[2][0] == turnoDe) ||
				(tablero[0][1] == turnoDe && tablero[1][1] == turnoDe && tablero[2][1] == turnoDe) ||
				(tablero[0][2] == turnoDe && tablero[1][2] == turnoDe && tablero[2][2] == turnoDe) ||
				(tablero[0][0] == turnoDe && tablero[1][1] == turnoDe && tablero[2][2] == turnoDe) ||
				(tablero[0][2] == turnoDe && tablero[1][1] == turnoDe && tablero[2][0] == turnoDe)) {
			System.out.println("El jugador " + turnoDe + " ha ganado");
			return true;
		}

		// Empate
		if (tablero[0][0] != 0 && tablero[0][1] != 0 && tablero[0][2] != 0 &&
				tablero[1][0] != 0 && tablero[1][1] != 0 && tablero[1][2] != 0 &&
				tablero[2][0] != 0 && tablero[2][1] != 0 && tablero[2][2] != 0) {
			System.out.println("Empate!");
			return true;
		}

		return false;
	}
}
