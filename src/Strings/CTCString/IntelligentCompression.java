package Strings.CTCString;

public class IntelligentCompression
{
  public String stringCompression(String word)
  {
    int count = 0;
    StringBuilder temp = new StringBuilder();

    for (int i = 0; i < word.length(); i++)
    {
      count++;

      if ((i+1 >= word.length()) || (word.charAt(i) != word.charAt(i + 1)))
      {
        temp.append(word.charAt(i)).append(count);
        count = 0;
      }
    }

    if (temp.length() < word.length())
    {
      return temp.toString();
    }
    return word;
  }
}
