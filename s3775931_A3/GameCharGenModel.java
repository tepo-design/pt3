import java.util.Arrays;
import java.util.Collections;

public class GameCharGenModel 
{
	static public int NUM_CHARS_BLOCK = 500;
	final public int STRENGTH=0; 
	final public int INTELLIGENCE=1; 
	final public int WISDOM=2;
	
	private int gameCharCount=0;
	private GameCharacter[] randomGameChars = new GameCharacter[NUM_CHARS_BLOCK];
	
	/**
	 * Returns the number of randomly-generated characters so far. 
	 * @return Number of randomly-generated characters.
	 */
	public int getNumCharacters()
	{
		return gameCharCount;
	}
	
	/**
	 * Adds a character to the array of characters
	 * @param c character to be added
	 */
	public void addGameCharacter(GameCharacter c)
	{
		if (gameCharCount>=randomGameChars.length)
		{
			GameCharacter[] newRandomChars = Arrays.copyOf(randomGameChars,randomGameChars.length+GameCharGenModel.NUM_CHARS_BLOCK);
			randomGameChars = newRandomChars;
		}
			
		randomGameChars[gameCharCount] = c;
		gameCharCount++;
	}
	
	/**
	 * Returns a character at a given index
	 * @param idx Provided index
	 * @return Character at a given index
	 */
	public GameCharacter gameCharacterAt(int idx)
	{
		if (idx<0 || idx>=randomGameChars.length)
			throw new IndexOutOfBoundsException();
		
		return randomGameChars[idx];
	}
	
	/**
	 * Finds a character with either maximum strength, intelligence or wisdom based on the parameter passed.
	 * @return Index of the character with lowest HP in the character array.
	 * @throws NoGameCharacterFoundException
	 */
	public int getLowestHPGameCharacter() throws NoGameCharacterFoundException
	{
		
		int minimium = Integer.MAX_VALUE;
		int returnIndex = 0;
		GameCharacter[] trimmedArray = resizeArray(randomGameChars);

		try{
			if (randomGameChars[0].equals(null)){}
		} catch (NullPointerException e){
			throw new NoGameCharacterFoundException();
		}

		for (int i = 0; i < trimmedArray.length; i ++){
				
			if (trimmedArray[i].hitPoints < minimium){
				minimium = trimmedArray[i].hitPoints;
				returnIndex = i;
				}
		}

		return returnIndex;
	}

	
	
	public void sortGameCharacterWisdom(boolean ascending) throws NoGameCharacterFoundException
	{
			
			GameCharacter[] trimmedArray = resizeArray(randomGameChars);
			
			if (ascending == true){
				Arrays.sort(trimmedArray);
			} else {
				Arrays.sort(trimmedArray, Collections.reverseOrder());
			}

			for (int i = 0; i < trimmedArray.length; i ++ ){
				randomGameChars[i] = trimmedArray[i];
			}

	}


	public GameCharacter[] resizeArray(GameCharacter[] array){
		
		int indexNull = Arrays.asList(array).indexOf(null);

		GameCharacter[] trimmedArray = Arrays.copyOfRange(array, 0, indexNull);

		return trimmedArray;
	}
}
