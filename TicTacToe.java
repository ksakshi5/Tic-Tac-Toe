import java.util.Scanner;
import java.util.Arrays;

class TicTacToe
{
	public static void main(String[] args)
	{
		int rows=3 , columns=3;

		char [][] grid = createGrid(rows,columns);
		Arrays.fill(grid[0],' ');
		Arrays.fill(grid[1],' ');
		Arrays.fill(grid[2],' ');

		System.out.println("\n*********** WELCOME ***********");
		System.out.println("==================================");
		System.out.println("           TIC TAC TOE          ");
		System.out.println("==================================\n");
		startGame(grid);
	}	

	public static void startGame(char [][] grid)
	{
		boolean winner = false;
		char x='X', o='O';
		boolean playerO = false;

		while(!winner)
		{
			if(playerO == false)
			{
				boolean playerX = player(grid,'X');
				checkWinner(grid);

				if(playerX == false)
				{
					continue;
				}
			}

			playerO = player(grid,'O');
			checkWinner(grid);
			if(playerO == false)
			{
				playerO = true;
				continue;
			}
			playerO = false;
		} 
	}


	public static void checkWinner(char [][] grid)
	{
		int cntX = 0;
		int cntO = 0;

		// HORIZONTAL WINNER CHECK

		for(int i=0; i<=2; i++)
		{
			for(int j=0; j<=2; j++)
			{
				if(grid[i][j] == 'X')
				{
					cntX++;
				}
				else if(grid[i][j] == 'O')
				{
					cntO++;
				}
			}

			if(cntX == 3)
			{
				displayGrid(grid);
				System.out.println("\n*-*-*-*-*-*-X IS WINNER-*-*-*-*-*-*\n");
				System.exit(0);
			}
			else if(cntO == 3)
			{
				displayGrid(grid);
				System.out.println("\n*-*-*-*-*-*-O IS WINNER-*-*-*-*-*-*\n");
				System.exit(0);
			}
			cntX = 0;
			cntO = 0;
		}



		//  VERTICAL WINNER CHECK 

		cntX = 0;
		cntO = 0;

		for(int j=0; j<=2; j++)
		{
			for(int i=0; i<=2; i++)
			{
				if(grid[i][j] == 'X')
				{
					cntX++;
				}
				else if(grid[i][j] == 'O')
				{
					cntO++;
				}
			}
			if(cntX == 3)
			{
				displayGrid(grid);
				System.out.println("\n*-*-*-*-*-*-X IS WINNER-*-*-*-*-*-*\n");
				System.exit(0);
			}
			else if(cntO == 3)
			{
				displayGrid(grid);
				System.out.println("\n*-*-*-*-*-*-O IS WINNER-*-*-*-*-*-*\n");
				System.exit(0);
			}
			cntX = 0;
			cntO = 0;
		}



		//  DIAGONAL CONDITIONS

		if((grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X')||
		   (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X')  )
		{
			displayGrid(grid);
			System.out.println("\n*-*-*-*-*-*-X IS WINNER-*-*-*-*-*-*\n");
			System.exit(0);
		}
		else if((grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O')||
				(grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O')  )
		{
			displayGrid(grid);
			System.out.println("\n*-*-*-*-*-*-O IS WINNER-*-*-*-*-*-*\n");
			System.exit(0);
		}

		boolean grids = false;

		for(int i=0; i<=2; i++)
		{
			for(int j=0; j<=2; j++)
			{
				char ch = grid[i][j];
				if(ch == ' ') 
				{
						return;
				}
			}
		}

		if(grids == false)
		{
			displayGrid(grid);
			System.out.println("\n*-*-*-*-*-*-IT'S A DRAW-*-*-*-*-*-* \n");
			System.exit(0);
		}
	}

	public static boolean player(char [][] grid, char player)
	{
		displayGrid(grid);
		System.out.println();
		System.out.print("\nEnter your response player " +player+ " : ");
		String response = new Scanner(System.in).next().toUpperCase();
		boolean check = checkResponse(grid,response,player);

		if(!check)
		{
			System.out.println("\n Player " +player+ " should get another chance\n");
			return false;
		}
		return true;
	}

	public static boolean checkResponse(char [][] grid, String response, char player)
	{
		int i = response.charAt(0)-65;
		int j = response.charAt(1)-49;

		if(i<0 || i>2 || j<0 || j>2)
		{
			System.out.println("\nInvalid Response. Please enter like A1,c1,etc.  \n");
			return false;
		}


		if(grid[i][j] == ' ')
		{
			grid[i][j] = player;
			return true;
		}else{
			System.out.println("\nSpace is already Occupied. \n");
			return false;
		} 
	}

	public static char [][] createGrid(int rows, int columns)
	{
		char [][] grid = new char[rows][columns];
		return grid;
	}

	public static void displayGrid(char [][] grid)
	{
		for(int i=0; i<grid.length; i++)
		{
			for(int j=0; j<grid[i].length; j++)
			{
				System.out.printf("%2c", grid[i][j]);
				if(j<2)
					System.out.printf("%2s", " | ");
			}
			if(i<2)
				System.out.printf("%n %5s %n","-----------");
		}
	}
}
