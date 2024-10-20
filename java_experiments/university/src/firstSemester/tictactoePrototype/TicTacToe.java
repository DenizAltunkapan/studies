package firstSemester.tictactoePrototype;

import firstSemester.tictactoePrototype.Board;

import java.util.Scanner;


public class TicTacToe {
	public static void main(String[] args) {
		char[][] gameBoard = {
				{'|', ' ' , '|', ' ' ,'|', ' ', '|'},
				{'|', ' ' , '|', ' ' ,'|', ' ', '|'},
				{'|', ' ' , '|', ' ' ,'|', ' ', '|'}
		};

		Board.printBoard(gameBoard);

		System.out.println("Das Spiel startet! :");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Einzelspieler(1) oder Mehrspieler(2)?");
		int mode = scanner.nextInt();
		while(true) {
			System.out.println("Bitte wähle eine Zahl von 1-9. Die erste Zeile markiert 1-3.");
			int input = scanner.nextInt();
			
			//gameBoard[1][1]= 'X';

			try {
				makeMove(gameBoard, input, 'X');
			} catch (Exception e) {
				System.out.println("Da ist bereits ein Element. Versuch es bitte erneut!");
				continue;
			}
			Board.printBoard(gameBoard);
			
			if(Board.getWinningCondition(gameBoard)) {
				System.out.println("Es gibt einen Gewinner!");
				break;
			}
			
			if(mode==1) {
				Opponent(gameBoard);
				
				if(Board.getWinningCondition(gameBoard)) {
					System.out.println("Es gibt einen Gewinner!");
					break;
				}
			}
			if(mode==2) {
				System.out.println("Bitte wähle eine Zahl von 1-9. Die erste Zeile markiert 1-3.");
				int input2 = scanner.nextInt();
				try {
					makeMove(gameBoard, input2, 'O');
				} catch (Exception e) {
					System.out.println("Da ist bereits ein Element. Versuch es bitte erneut!");
					continue;
				}
				Board.printBoard(gameBoard);
				
				if(Board.getWinningCondition(gameBoard)) {
					System.out.println("Es gibt einen Gewinner!");
					break;
				}
			}
	}
	
}

	private static void Opponent(char[][] gameBoard) {
		int random = (int) (Math.random()*10);
		if(random <5) {
			System.out.println("Jetzt bin ich dran");
		}else {
			System.out.println("Mach dich bereit zu verlieren.");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			makeMove(gameBoard, random, 'O');
			Board.printBoard(gameBoard);
		} catch (Exception e) {
			Opponent(gameBoard);
		}

	}
	

	private static void makeMove(char[][] gameBoard, int input, char x) throws Exception {
		int column;
		if(input<4) {
			column=0;
		}else if(input<7) {
			column=1;
		}else {
			column=2;
		}
		
		if(input%3 == 1) {
			if(Board.checkFree(gameBoard,column,1)) {
				gameBoard[column][1]= x;
			}
		}	
		if(input%3 == 2) {
			if(Board.checkFree(gameBoard,column,3)) {
				gameBoard[column][3]= x;
			}
		}
		if(input%3 == 0) {
			if(Board.checkFree(gameBoard,column,5)) {
				gameBoard[column][5]= x;
			}
		}
	}

}
