package Strings.CTCString;

public class UniquenessCheck
{
  public boolean isUnique(String word)
  {
    // Assuming ASCII(128), if Extended ASCII(256)
    if (word.length() > 128)
      return false;
    boolean[] bArray = new boolean[128];
    for (int i = 0; i < word.length(); i++)
    {
      // One approach would be to have a
      // HashTable of (Character,dummy)

      // ASCII value of the Character
      int asciiValue = word.charAt(i);

      if (bArray[asciiValue]) {
        return false;
      }
      bArray[asciiValue] = true;
    }
    return true;
  }
}
