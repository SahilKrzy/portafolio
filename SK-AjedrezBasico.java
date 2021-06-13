package AjedrezBasic;

import java.util.Scanner;

public class AjedrezIntento2 {

	public static void main(String[] args) {
		String select = "";
		Scanner teclado = new Scanner(System.in);

		String[][] ajedrez = { { "[T]", "[C]", "[A]", "[K]", "[Q]", "[A]", "[C]", "[T]" },
				{ "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]" },
				{ " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . " },
				{ " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . " },
				{ " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . " },
				{ " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . " },
				{ "(P)", "(P)", "(P)", "(P)", "(P)", "(P)", "(P)", "(P)" },
				{ "(T)", "(C)", "(A)", "(Q)", "(K)", "(A)", "(C)", "(T)" }, };

		int fila, columna, filaf = 0, columnaf = 0;
		
		System.out.println("Buenas! Bienvenido al ajedrez basico.\n\nEn este ajedrez se recuerda que ninguna ficha se puede comer a la otra.\nA continuacion tienes el tablero. Recuerda, vas de 1 a 8, lo demas estara fuera del tablero.\n");
		
		do {
			for (int x = 0; x < ajedrez.length; x++) {
				for (int y = 0; y < ajedrez[x].length; y++) {
					System.out.print(ajedrez[x][y] + " ");
				}
				System.out.println(" ");
			}
			do {
				System.out.print("Fila y Columna Pieza: ");
				fila = teclado.nextInt();
				columna = teclado.nextInt();
			} while (fila < 1 || fila > 9 || columna < 1 || columna > 9);
//////////////////////////////////////////////////////////////////////////////////////////////////////
			if (ajedrez[fila - 1][columna - 1].equals(" . ")) {
				System.out.println("No hay pieza en ese lugar.");
				System.out.println(" ");
			} else {
				System.out.print("Pieza seleccionada: " + ajedrez[fila - 1][columna - 1]);
				select = ajedrez[fila - 1][columna - 1];

				System.out.println("");
//////////////////////////////////////////////////////////////////////////////////////////////////////
				System.out.print("Destino pieza: ");
				filaf = teclado.nextInt();
				columnaf = teclado.nextInt();
				
				if (filaf -1 >= ajedrez.length || columnaf -1 >= ajedrez.length || filaf <= 0 || columnaf <= 0) {
					System.out.println("Destino fuera del tablero.");
				}
				else if (!(ajedrez[filaf - 1][columnaf - 1].equals(" . "))) {
					System.out.println("Destino ocupado.");
				} else {
					ajedrez[filaf - 1][columnaf - 1] = select;
					ajedrez[fila - 1][columna - 1] = " . ";

//////////////////////////////////////////////////////////////////////////////////////////////////////

					switch (select) {
					case "[P]":
						if (fila == 2) {
							if ((filaf == fila + 2 || filaf == fila + 1) && columnaf == columna) {
								ajedrez[filaf - 1][columnaf - 1] = select;
								ajedrez[fila - 1][columna - 1] = " . ";
							} else {
								System.out.println("Movimento incorrecto.");
								ajedrez[filaf - 1][columnaf - 1] = " . ";
								ajedrez[fila - 1][columna - 1] = select;
							}
						} else {
							if (filaf == fila + 1 && columnaf == columna) {
								ajedrez[filaf - 1][columnaf - 1] = select;
								ajedrez[fila - 1][columna - 1] = " . ";
							} else {
								System.out.println("Movimento incorrecto.");
								ajedrez[filaf - 1][columnaf - 1] = " . ";
								ajedrez[fila - 1][columna - 1] = select;
							}
						}

						break;
					case "(P)":
						if (fila == 7) {
							if ((filaf == fila - 2 || filaf == fila - 1) && columnaf == columna) {
								ajedrez[filaf - 1][columnaf - 1] = select;
								ajedrez[fila - 1][columna - 1] = " . ";
							} else {
								System.out.println("Movimento incorrecto.");
								ajedrez[filaf - 1][columnaf - 1] = " . ";
								ajedrez[fila - 1][columna - 1] = select;
							}
						} else {
							if (filaf == fila + 1 && columnaf == columna) {
								ajedrez[filaf - 1][columnaf - 1] = select;
								ajedrez[fila - 1][columna - 1] = " . ";
							} else {
								System.out.println("Movimento incorrecto.");
								ajedrez[filaf - 1][columnaf - 1] = " . ";
								ajedrez[fila - 1][columna - 1] = select;
							}
						}
						break;
					case "[T]":
					case "(T)":
						if (filaf == fila || columnaf == columna) {
							ajedrez[filaf - 1][columnaf - 1] = select;
							ajedrez[fila - 1][columna - 1] = " . ";
						} else {
							System.out.println("Movimento incorrecto.");
							ajedrez[filaf - 1][columnaf - 1] = " . ";
							ajedrez[fila - 1][columna - 1] = select;
						}
						break;
					case "[C]":
					case "(C)":
						if ((filaf == fila + 2 || filaf == fila - 2 || filaf == fila + 1 || filaf == fila - 1) && (columnaf == columna + 2 || columnaf == columna - 2 || columnaf == columna + 1 || columnaf == columna - 1)) {
							ajedrez[filaf - 1][columnaf - 1] = select;
							ajedrez[fila - 1][columna - 1] = " . ";
						} else {
							System.out.println("Movimento incorrecto.");
							ajedrez[filaf - 1][columnaf - 1] = " . ";
							ajedrez[fila - 1][columna - 1] = select;
						}
						break;
					case "[A]":
					case "(A)":
						if (Math.abs(fila - filaf) == Math.abs(columna - columnaf)) {
							ajedrez[filaf - 1][columnaf - 1] = select;
							ajedrez[fila - 1][columna - 1] = " . ";
						} else {
							System.out.println("Movimento incorrecto.");
							ajedrez[filaf - 1][columnaf - 1] = " . ";
							ajedrez[fila - 1][columna - 1] = select;
						}
						break;
					case "[Q]":
					case "(Q)":
						if (Math.abs(fila - filaf) == Math.abs(columna - columnaf) || filaf == fila || columnaf == columna) {
							ajedrez[filaf - 1][columnaf - 1] = select;
							ajedrez[fila - 1][columna - 1] = " . ";
						} else {
							System.out.println("Movimento incorrecto.");
							ajedrez[filaf - 1][columnaf - 1] = " . ";
							ajedrez[fila - 1][columna - 1] = select;
						}
						break;
					case "[K]":
					case "(K)":
						if (filaf == fila + 1 || filaf == fila - 1 || columnaf == columna + 1 || columnaf == columna - 1 || Math.abs(filaf - fila + 1) == Math.abs(columnaf - columna + 1)) {
							ajedrez[filaf - 1][columnaf - 1] = select;
							ajedrez[fila - 1][columna - 1] = " . ";
						} else {
							System.out.println("Movimento incorrecto.");
							ajedrez[filaf - 1][columnaf - 1] = " . ";
							ajedrez[fila - 1][columna - 1] = select;
						}
					}// ESTE ES EL DEL SWITCH
				} // ESTE ES EL DEL ELSE
			}

		} while (true);
	}

}