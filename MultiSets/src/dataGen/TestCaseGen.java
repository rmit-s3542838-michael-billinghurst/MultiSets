package dataGen;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class TestCaseGen {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName= "test1";
		Scanner input = new Scanner(System.in);
		
		int [] dataset= new int[100];
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
					int randomAdd=random.nextInt(99);//Generate random number, 1-100;
					inputWriter.println("A "+randomAdd);
					dataset[randomAdd]++;
				}
				break;
			case "S":
				int searchNo;
				System.out.println("How many times do you wish to search?");
				searchNo = input.nextInt();
				for (int i=0; i<searchNo; i++)
				{
					int randomSearch=random.nextInt(99);//Generate random number, 1-100;
					inputWriter.println("S "+randomSearch);
					searchWriter.println("S "+dataset[randomSearch]);//write "S <dataset[randomSearch]" to filename.search.exp
				}
				break;
			case "RO":
				int remONo;
				System.out.println("How many times do you wish to remove one?");
				remONo = input.nextInt();
				for (int i=0; i<remONo; i++)
				{
					int randomRem=random.nextInt(99);//Generate random number, 1-100;
					inputWriter.println("RO "+randomRem);
					dataset[randomRem]--;
				}
				break;
			case "RA":
				int remANo;
				System.out.println("How many times do you wish to remove All?");
				remANo = input.nextInt();
				for (int i=0; i<remANo; i++)
				{
					int randomRem=random.nextInt(99);//Generate random number, 1-100;
					inputWriter.println("RA "+randomRem);
					dataset[randomRem]=0;
				}
				break;
			default: System.out.println("Invalid Command");
				break;
			}//End of switch Statement
			System.out.println("Do you wish to keep generating data? (Y/N)");
			if (input.nextLine().equals("Y"))
				quit=true;
			
		}
		inputWriter.println("P");
		inputWriter.println("Q");
		for (int i=0; i<100;i++)
		{
			expectedWriter.println(i + " | " + dataset[i]);
		}
		// Close the file Writers
		inputWriter.close();
		expectedWriter.close();
		searchWriter.close();
	}

}
