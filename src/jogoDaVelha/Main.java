package jogoDaVelha;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String primeiroJogador = "O";
		String segundoJogador = "X";

		String[][] tabuleiro = new String[3][3];

		int linhaTabuleiro = 0;
		int colunaTabuleiro = 0;

		boolean continuarJogando = true;

		System.out.println("O primeiro jogador ficará com o X.");
		imprimindoTabuleiro(tabuleiro);
		checarLinha(tabuleiro);
		checarColuna(tabuleiro);
		
	}
	
	public static void imprimindoTabuleiro(String[][] tabuleiro) {
		System.out.println("  0 1 2");
		for (int i = 0; i < tabuleiro.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] == null) {
					System.out.print(" ");
				} else {
					System.out.print(tabuleiro[i][j]);
				}
				if (j != tabuleiro[i].length - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
		}
	}
	
	public static boolean checarLinha(String[][] tabuleiro) {
		boolean linha = true;
		for (int i = 0; i < tabuleiro.length; i++) {
			linha = true;
			for (int j = 1; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][0] != tabuleiro[i][j] || tabuleiro[i][0] == null) {
					linha = false;
				}
			}
			if (linha) {
				break;
			}
		}
		return linha;
	}

	
	public static boolean checarColuna(String[][] tabuleiro) {
		boolean coluna = true;
		for (int i = 0; i < tabuleiro.length; i++) {
			coluna = true;
			for (int j = 1; j < tabuleiro[i].length; j++) {
				if (tabuleiro[0][i] != tabuleiro[j][i] || tabuleiro[0][i] == null) {
					coluna = false;
				}
			}
			if (coluna) {
				break;
			}
		}
		return coluna;
	}
		
}