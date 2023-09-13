package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		System.out.println("Starting Amount");
		double startAmount = in.nextDouble();
		System.out.println("winChance");
		double winChance = in.nextDouble();
		System.out.println("Win Limit");
		double winLimit = in.nextDouble();
		System.out.println("Total Simulations");
		int totalSimulations = in.nextInt();
		int loseCounter=0;
		int winCounter=0;
		
		
		
		for (int day=1;day<=totalSimulations;day++)
		{
			double totalmoney = startAmount;
			int plays =0;
			while(totalmoney>0 && totalmoney<winLimit)
				{
				plays++;
				double random = Math.random();
				
				if (random <winChance)
					totalmoney++;
				
				else
					totalmoney --;
				}
			if (totalmoney==0)
			{
				System.out.println("Simulation " + day + ":" + plays +" Lose");
				loseCounter++;
			}
			else 
			{
				System.out.println("Simulation " + day + ":" + plays +" Win");
				winCounter++;
			}
		if (winChance==0.5)
			{
			double expectedRuin= (1-(startAmount/winLimit));
			double estimatedRuinRate= (loseCounter/totalSimulations);
			System.out.println("Losses: "+ loseCounter + "Simulations: "+totalSimulations);
			System.out.println("Ruin Rate from Simulation :" + estimatedRuinRate +"Expected Ruin Rate:" +expectedRuin);
			}
		else
			{
			double a=((1-winChance)/winChance);
			double expectedRuin= (Math.pow(a, startAmount)-(Math.pow(a,winLimit))/(1-Math.pow(a, winLimit)));
			double estimatedRuinRate= (loseCounter/totalSimulations);
			System.out.println("Losses: "+ loseCounter + "Simulations: "+totalSimulations);
			System.out.println("Ruin Rate from Simulation :" + estimatedRuinRate +"Expected Ruin Rate:" +expectedRuin);
			}		
		
		}
	}
}
		
		
	
				
	


