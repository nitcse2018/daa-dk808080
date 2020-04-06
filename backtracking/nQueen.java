public class nQueen
{
  final static int n =4;
  static boolean isSafe(int board[][], int row, int col)
  {
    int i,j;
    for(i =0; i<row; i++)
    {
      if(board[i][col] == 1)
      {
        return false;
      }
    }
    for(i=row,j=col; i>=0 && j>=0; i--,j--)
    {
      if(board[i][j] == 1)
      {
        return false;
      }
    }
    for(i=row,j=col; i>=0 && j<n; i--,j++)
    {
      if(board[i][j] == 1)
      {
        return false;
      }
    }
    return true;
  }
  static boolean solveNQ(int board[][], int row)
  {
    if(row>=n)
    {
      return true;
    }
    for(int col=0; col<n; col++)
    {
      if(isSafe(board, row,col))
      {
          board[row][col] = 1;

      if(solveNQ(board, row+1))
      {
        return true;
      }
      board[row][col] = 0;
    }
  }
    return false;
  }
  static void printSolution(int board[][])
    {
      for (int i = 0; i < n; i++)
      {
          for (int j = 0; j <n; j++)
          {
            System.out.print(" " + board[i][j] + " ");

         }
           System.out.println();
      }
    }
  public static void main(String args[])
  {
    int board[][] =
    {
      {0,0,0,0},
      {0,0,0,0},
      {0,0,0,0},
      {0,0,0,0}
    };
    if(!solveNQ(board,0))
    {
      System.out.println("solution not found");
    }
    printSolution(board);
  }
}
