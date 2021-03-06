package dataGen;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class TestCaseGen {
static final int MAXSETSIZE=1000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName= "test1";
		Scanner input = new Scanner(System.in);
		
		int [] dataset= new int[MAXSETSIZE];
		//Initialised to -1
		Arrays.fill(dataset, -1);
		Random random = new Random();
		System.out.println("Please enter the name of the file you wish to output to");
		
		fileName = input.nextLine();
		File inputFile= new File(fileName+".in");
		PrintWriter inputWriter = new PrintWriter(new FileWriter(inputFile));
		File expectedFile= new File(fileName+".exp");
		PrintWriter expectedWriter = new PrintWriter(new FileWriter(expectedFile));
		File searchFile= new File(fileName+".search.exp");
		PrintWriter searchWriter = new PrintWriter(new FileWriter(searchFile));
		
		Boolean quit = false;
		while (quit==false)
		{
			System.out.println("What command would you like to generate");
			String command= input.nextLine();
			switch(command)//Switch to choose which command to add next
			{
			case "A":
				int addNo;
				System.out.println("How many times do you wish to add?");
				addNo = input.nextInt();
				for (int i=0; i<addNo; i++)
				{
					int randomAdd=random.nextInt(MAXSETSIZE-1);//Generate random number
					inputWriter.println("A "+randomAdd);
					if (dataset[randomAdd]==-1)
						dataset[randomAdd]++;
					dataset[randomAdd]++;
				}
				break;
			case "S":
				int searchNo;
				System.out.println("How many times do you wish to search?");
				searchNo = input.nextInt();
				for (int i=0; i<searchNo; i++)
				{
					int randomSearch=random.nextInt(MAXSETSIZE-1);//Generate random number
					inputWriter.println("S "+randomSearch);
					int searchResult = Math.max(0,dataset[randomSearch]); //Should return 0 even if element is not in the list (is -1 in dataset array)
					searchWriter.println(randomSearch+" "+searchResult);//write "S <dataset[randomSearch]" to filename.search.exp
				}
				break;
			case "RO":
				int remONo;
				System.out.println("How many times do you wish to remove one?");
				remONo = input.nextInt();
				for (int i=0; i<remONo; i++)
				{
					int randomRem=random.nextInt(MAXSETSIZE-1);//Generate random number
					inputWriter.println("RO "+randomRem);
					if (dataset[randomRem]>0)
						dataset[randomRem]--;
				}
				break;
			case "RA":
				int remANo;
				System.out.println("How many times do you wish to remove All?");
				remANo = input.nextInt();
				for (int i=0; i<remANo; i++)
				{
					int randomRem=random.nextInt(MAXSETSIZE-1);//Generate random number;
					inputWriter.println("RA "+randomRem);
					dataset[randomRem]=-1;
				}
				break;
			case "Q":
				break;
			default: System.out.println("Invalid Command");
				break;
			}//End of switch Statement
			System.out.println("Enter 'Q' to Stop generating this Test Case");
			if (input.nextLine().equals("Q"))
				quit=true;
			
		}
		inputWriter.println("P");
		inputWriter.println("Q");
		for (int i=0; i<MAXSETSIZE-1;i++)
		{
			if (dataset[i]>=0)
				expectedWriter.println(i + " | " + dataset[i]);
		}
		// Close the file Writers
		inputWriter.close();
		expectedWriter.close();
		searchWriter.close();
	}

}
