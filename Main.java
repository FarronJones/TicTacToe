//This program makes use of methods for a Tic-tac-toe game. If x get a row or column, x wins. If o get a row or column,
//o wins. If x's and o's the same, its a draw.
//import scanner
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
			//declare scanner
			Scanner scanner = new Scanner(System.in);
			//create the board
			char[][]board = createBoard();
			//set token to 'x'
			char token = 'x';
			//set k=1
			int k=1;
			//set boolean won=false
			boolean won = false;
			//set boolean avail=true
			boolean avail=true;
			//prints the initial board
			startBoard(board);
			//loop at most 9 times, but end loop when someone wins
			//do the code
			do {
			//if k is greater than 1
			if(k>1) {
				//if avail
				if(avail) {
					//calls method to print the board again
					newBoard(board);
				}
				//change token(if it was 'x' change to 'o' and vice versa
				if(token=='x') {
					token='o';
				}
				else {
					token='x';
				}
			}
			//Ask player where to place token each time
			System.out.println("Where to place "+token);
			//int place is for the placeToken method
			int place = scanner.nextInt();
			//if place is between 1 and 9
			if(place>0 && place<=9) {
				//calls method for availability
				avail=availability(board,place);
				//calls method for placeToken
				if(avail) {
					board=placeToken(board, token, place);
				}
				//else
				else {
					//that place is already taken, try another one
					System.out.println("That place is already taken, try again!");
					//k is being decremented 
					k--;
				}
			}
			//else 
			else {
				//ask user to try again
				System.out.println("Please enter a number between 1-9 again!");
			}
			//if k is greater than 4
				if(k>4) {
					//calls method check for winner
					won=checkforwinner(board);
					//if won is true
					if(won) {
						//calls method to print the board again
						newBoard(board);
						//congratulate someone on winning
						//if token x, o won
						if(token=='o') {
							System.out.println('o'+" won!");
						}
						//else x won
						else {
							System.out.println('x'+" won!");
						}
					}
				}
				//k is being incremented
				k++;
			//while k is less than 9 and won is false
			}while(k<9 && won==false);
			//if won is false
			if(won==false) {
				//calls method to print the board again
				newBoard(board);
				//it's a draw, no winner
				System.out.println("It's a draw!");
			}
			  
			
	
			

}//end main
	//methods
	//method to create the board
	public static char[][]createBoard() {
				//17 by 17 tic tac toe game
				char[][] board = new char[17][17];
				//needs return
				return board; 
	}

	//method to print the first board
	public static void startBoard(char[][] board) {
		//declare rows
		int row = 0;
		//declare columns
		int col = 0;
		//inner and outer for loop to fill all rows with blanks from 0 to 16
		//outer for loop
		for(row=0; row<17; row++) {
		//inner for loop
		for(col = 0; col<17; col++) {
			board[row][col]=' ';
			}
		}
		//for every column puts line for the first horizontal loop
		for(col = 0; col<17; col++) {
			board[5][col]='-';
		}
		//for every column puts line for the second horizontal loop
		for(col=0; col<17; col++) {
			board[11][col]='-';
		}
		//needs new line for 17 by 17
		System.out.println();
		//for every row puts line for the first vertical loop
		for(row = 0; row<17; row++) {
			board[row][5]='|';
		}
		//for every row puts line for the second vertical loop
		for(row=0; row<17; row++) {
			board[row][11]='|';
		}
		//put in numbers for Tic-tac-toe, for player to visualize the board placements
		board[2][2]='1';
		board[2][8]='2';
		board[2][14]='3';
		board[8][2]='4';
		board[8][8]='5';
		board[8][14]='6';
		board[14][2]='7';
		board[14][8]='8';
		board[14][14]='9';
		//nested loop to print the board
		for(row=0; row<17; row++) {
			for(col = 0; col<17; col++) 
			System.out.print(board[row][col]);
			System.out.println();
			}
		
	}
	//method to check for winner
	public static boolean checkforwinner(char[][] board){
				//for loop, to go through the board placements
				for(int i=2; i<14; i=i+6) {
					//if statement to check if its a straight across win
					if(board[i][2]==board[i][8]&&board[i][8]==board[i][14]) {
						//its a winner because 3 in a row
						return true;
					}
				}
				//for loop, to go through the board placements
				for(int j=2; j<14; j=j+6) {
					//if statement to check if its straight down win
					if(board[2][j]==board[8][j]&&board[8][j]==board[14][j]) {
						//its a winner because 3 in a row
						return true;
					}
				}
				//code to check diagonally
				if(board[2][2]==board[8][8]&&board[8][8]==board[14][14]) {
					//its a winner because 3 in a row
					return true;
				}
				//code to check diagonally
				if(board[2][14]==board[8][8]&&board[8][8]==board[14][2]) {
					//its a winner because 3 in a row
					return true;
				}
			//needs return
			return false;
		}


	
	//method to place token(x's and o's placement)
	public static char[][] placeToken(char[][]board,char token,int place) {
		//switch statement 
		switch(place) {
		case 1:board[2][2]=token;
		break;
		case 2: board[2][8]=token;
		break;
		case 3: board[2][14]=token;
		break;
		case 4: board[8][2]=token;
		break;
		case 5: board[8][8]=token;
		break;
		case 6: board[8][14]=token;
		break;
		case 7: board[14][2]=token;
		break;
		case 8: board[14][8]=token;
		break;
		case 9: board[14][14]=token;
		break;
		}
		//return
		return board;
	}
	//method to print out new board
	public static void newBoard(char[][] board) {
			//declare rows
			int row = 0;
			//declare columns
			int col = 0;
			//nested loop to print the board
			for(row=0; row<17; row++) {
				for(col = 0; col<17; col++) 
				System.out.print(board[row][col]);
				System.out.println();
				}
			
	}
	//method to check availability of board(Extra Credit portion)
	public static boolean availability(char[][] board, int place) {
		//switch statement,if board is the number return true.
		switch(place) {
		case 1:	
			if(board[2][2]=='1') {
				return true;
		} 
		break;
		case 2:
			if(board[2][8]=='2') {
				return true;
			}
		break;
		case 3:
			if(board[2][14]=='3') {
				return true;
			}
		break;
		case 4:
			if(board[8][2]=='4') {
				return true;
			}
		break;
		case 5:
			if(board[8][8]=='5') {
				return true;
			}
		break;
		case 6:
			if(board[8][14]=='6') {
				return true;
			}
		break;
		case 7:
			if(board[14][2]=='7') {
				return true;
			}
		break;
		case 8:
			if(board[14][8]=='8') {
				return true;
			}
		break;
		case 9:
			if(board[14][14]=='9') {
				return true;
			}
		break;
			
	}
		//return
		return false;
	}
}//end class
 