package Strings.CTCString;

public class PalindromePermutationCheck
{
  public boolean isPalindromePermutation(String word)
  {
    int aValue = Character.getNumericValue('a');
    int zValue = Character.getNumericValue('z');

    int[] characterMappingArray = new int[zValue - aValue + 1];
    int countOdd = 0;
    for (char letter : word.toCharArray())
    {
      int x = getCharacterValue(letter);
      if (x != -1) {
        characterMappingArray[x]++;
        if (characterMappingArray[x] % 2 == 1) {
          countOdd++;
        } else {
          countOdd--;
        }
      }
    }

    return countOdd <= 1;
  }

  private int getCharacterValue(char letter)
  {
    int AValue = Character.getNumericValue('A');
    int ZValue = Character.getNumericValue('Z');
    int value = Character.getNumericValue(letter);
    if (AValue < value && value < ZValue)
    {
      return value - AValue;
    }
    return -1;
  }
}
