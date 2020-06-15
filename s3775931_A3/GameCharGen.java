import java.util.Scanner;


public class GameCharGen 
{
	
	public static void main(String[] args)  throws NoGameCharacterFoundException
	{
		GameCharGenModel myCharGen = new GameCharGenModel();
		Scanner menuInput = new Scanner(System.in);
		

		boolean exit = false;

		while (!exit){
		
			System.out.println("*** WoK GameCharGen Menu***");
			System.out.printf("%s %15s %n", "Create Wizard", "WZ");
			System.out.printf("%s %14s %n", "Create Fighter", "FG");
			System.out.printf("%s %15s %n", "Create Cleric", "CL");
			System.out.printf("%s %10s %n", "Lowest HP Character", "LHC");
			System.out.printf("%s %9s %n", "Sort Characters Asc.", "SCA");
			System.out.printf("%s %8s %n", "Sort Characters Desc.", "SCD");
			System.out.printf("%s %10s %n", "Display Characters", "DC");
			System.out.printf("%s %16s %n", "Exit Program", "EX");
			
			System.out.println("Enter selection:");

			String userChoice = menuInput.nextLine();
			userChoice.toLowerCase();
			GameCharacter chosen = null;

			switch(userChoice){
				
				case "wz":
					chosen = new Wizard();
					chosen.randGen(true);
					chosen.display();
					myCharGen.addGameCharacter(chosen);
					break;
				
				case "fg":
					chosen = new Fighter();
					chosen.randGen(false);
					chosen.display();
					myCharGen.addGameCharacter(chosen);
					break;
				
				case "cl":
					chosen = new Cleric();
					chosen.randGen(true);
					chosen.display();
					myCharGen.addGameCharacter(chosen);
					break;

				case "lhc":
					try{
						int lowestHP = myCharGen.getLowestHPGameCharacter();
						System.out.println("Game character at index " + lowestHP + " had lowest HP.");
					} catch(NoGameCharacterFoundException e){
						System.out.println("No characters in array");
					}
					break;

				case "sca":
					myCharGen.sortGameCharacterWisdom(true);
					break;

				case "scd":
					myCharGen.sortGameCharacterWisdom(false);
					break;
				
				case "ex":
					exit = true;
					break;

				case "dc":
					try{
						for (int i = 0; i < GameCharGenModel.NUM_CHARS_BLOCK; i ++){
						
							if (myCharGen.gameCharacterAt(i).equals(null)) break;

							myCharGen.gameCharacterAt(i).display();
						}
					} catch(NullPointerException e){

					}
						break;

				default:
					System.out.println("Unrecognised command");
					break;
		}
	

	}
			
		menuInput.close();
		System.out.println("***************");
		System.out.println("Quitting now...");
		System.out.println("***************");
		System.exit(0);
	}

}
