import java.util.Random;
import java.util.Scanner;

public class MouseDemo {
	public static void main (String [] args)
	{
		Scanner keyboard = new Scanner (System.in);
		Random generator = new Random ();
		System.out.println("enter row");
		int rowNum = keyboard.nextInt();
		System.out.println("enter column");
		int columnNum = keyboard.nextInt();
		
		int row =1;
		int column = 1;
	
		int [][] mouse = new int [rowNum][columnNum];
		int x=2;
		int y=2;
		
		do
		{
			int num = generator.nextInt(8)+1;
			mouse [0][0] = 1;
			mouse [1][1] = 2;
		
			if ((num == 1)&&(row+1 <= rowNum))
				//in the array
			{
				if ((row != 0)&&(column != 0) && (row +1 != rowNum -1)&&(column != columnNum -1))  
					//to make sure it doesnt run into edges
				{
					row ++;
					y++;
					x++;
					mouse [row][column] = y;
				}
				
			}
			else if ((num == 2)&&(column+1 <= columnNum))
			{
				if ((row != 0)&&(column != 0) && (row != rowNum -1)&&(column+1 != columnNum -1))
				{
					column ++;
					y++;
					x++;
					mouse [row][column] = y;
				}
				
			}
			else if ((num == 3)&&(column+1 <= columnNum)&&(row +1 <= rowNum))
			{
				if ((row != 0)&&(column != 0) && (row+1 != rowNum -1)&&(column+1 != columnNum -1))
				{
					row ++;
					column ++;
					y++;
					x++;
					mouse [row][column] = y;
				}
			}
			else if (((num == 4)&&(row+1 <= rowNum)&&(column+1 <= columnNum)))
			{
				if ((row != 0)&&(column-1 != 0) && (row+1 != rowNum -1)&&(column != columnNum -1))
				{
					row ++;
					column --;
					y++;
					x++;
					mouse [row][column] = y;
				}
			}
			else if (((num == 5)&&(row+1 <= rowNum)&&(column+1 <= columnNum)))
			{
				if ((row-1 != 0)&&(column != 0) && (row != rowNum -1)&&(column+1 != columnNum -1))
				{
					row --;
					column ++;
					y++;
					x++;
					mouse [row][column] = y;
				}
			}
			else 
			{
				reset(rowNum, columnNum, mouse);
				row = 1;
				column = 1;
				y=2;
				x=2;
				
			}
			
		}while ((row+2 < rowNum)||(column+2 < columnNum));
		
		mouse [rowNum-1][columnNum-1]=(x+1);
		System.out.println("");
		System.out.println("it took " + (x+1) + " moves to solve");
		System.out.println("");
		
		for(int[] rows : mouse) 
	    {
	        printRow(rows);
	    }
	}
	
	private static void reset(int rowNum, int columnNum, int [][]mouse) 
	{
		for (int rows = 0; rows <rowNum; rows++)
		{
			for (int columns = 0; columns <columnNum; columns++)
			{
				mouse[rows][columns] = 0;
			}
		}
	}

	private static void printRow(int[] rows)
	{
		for (int i : rows) 
		{
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();	
	}
}
