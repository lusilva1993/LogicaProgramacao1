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
		
		String jogadorDaVez = primeiroJogador;

		boolean continuarJogando = true;

		System.out.println("O primeiro jogador ficará com o O.");
		
		while (continuarJogando) {

			imprimindoTabuleiro(tabuleiro);

			System.out.print("Insira a linha:");
			if (scanner.hasNextInt()) {
				linhaTabuleiro = scanner.nextInt();
			} else {
				System.err.print("Valor inválido!");
				break;
			}
			System.out.print("Insira a coluna:");
			if (scanner.hasNextInt()) {
				colunaTabuleiro = scanner.nextInt();
			} else {
				System.err.print("Valor inválido!");
				break;
			}

			if (checandoJogadaValida(tabuleiro, linhaTabuleiro, colunaTabuleiro)) {

				tabuleiro[linhaTabuleiro][colunaTabuleiro] = jogadorDaVez;
				if (checandoLinha(tabuleiro) || checandoColuna(tabuleiro)
						|| checandoDiagonal(tabuleiro)) {
					System.out.println("O jogador " + jogadorDaVez + " ganhou!");
					imprimindoTabuleiro(tabuleiro);
					continuarJogando = false;
				} else if (checandoVelha(tabuleiro)) {
					imprimindoTabuleiro(tabuleiro);
					System.out.println("Ops! DEU VELHA!");
					continuarJogando = false;
				} else {

					if (jogadorDaVez == primeiroJogador) {
						jogadorDaVez = segundoJogador;
					} else {
						jogadorDaVez = primeiroJogador;
					}
				}

			} else {
				System.out.println("Jogada inválida, tente novamente!");
			}
		}
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
	
	public static boolean checandoJogadaValida(String[][] tabuleiro, int linhaTabuleiro, int colunaTabuleiro) {
		if (linhaTabuleiro >= 0 && linhaTabuleiro <= 2 && colunaTabuleiro >= 0 && colunaTabuleiro <= 2) {
			if (tabuleiro[linhaTabuleiro][colunaTabuleiro] == null) {
				return true;
			}
		}
		return false;
	}

	public static boolean checandoLinha(String[][] tabuleiro) {
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

	public static boolean checandoColuna(String[][] tabuleiro) {
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

	public static boolean checandoDiagonal(String[][] tabuleiro) {
		boolean diagonal = true;
		for (int i = 1; i < tabuleiro.length; i++) {
			for (int j = 1; j < tabuleiro.length; j++) {
				if (i == j) {
					if (tabuleiro[0][0] != tabuleiro[i][j] || tabuleiro[0][0] == null) {
						diagonal = false;
					}
				}
			}
		}
		if (diagonal) {
			return diagonal;
		}
		diagonal = true;
		int cont = 1;
		for (int i = tabuleiro.length - 2; i >= 0; i--) {
			for (int j = 1; j < tabuleiro.length; j++) {
				if (cont == j) {
					if (tabuleiro[tabuleiro.length - 1][0] != tabuleiro[i][j]
							|| tabuleiro[tabuleiro.length - 1][0] == null) {
						diagonal = false;
					}
				}
			}
			cont++;
		}
		return diagonal;
	}
	
	public static boolean checandoVelha(String[][] tabuleiro) {
		boolean velha = true;
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] == null) {
					velha = false;
				}
			}
		}
		return velha;
	}
}