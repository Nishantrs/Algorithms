package AlgorithmQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ProgramCreekQuestions
{
  public int[] rotateRightByKUsingArray(int[] arr, int k)
  {
    // O(n) space and O(n) run time
    int[] temp = new int[arr.length];

    for (int i = k;i < arr.length;i++)
    {
      temp[i] = arr[i-k];
      // temp[i-k] = arr[i]
    }

    for (int i = 0;i < k;i++)
    {
      temp[i] = arr[arr.length-k+i];
      // temp[arr.length-k+i] = arr[i];
    }
    return temp;
  }

  public void rotateRightByKUsingReversal(int[] arr, int k)
  {
    int firstHalf = arr.length - k;
    reverse(arr,0,firstHalf-1);
    reverse(arr,firstHalf,arr.length - 1);
    reverse(arr,0,arr.length - 1);
  }

  private void reverse(int[] arr, int left, int right)
  {
    if (arr.length ==1)
    {
      return;
    }
    // O(1) space and O(n) run time
    int temp;
    while (left < right)
    {
      temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }

  public int computeReversePolishNotationUsingStack(String[] arr)
  {
    Stack<Integer> numberContainer = new Stack<>();
    String operators = "+-/*";
    int value, operand1, operand2;

    for(String term : arr)
    {
      if (!operators.contains(term)) {
        numberContainer.push(Integer.parseInt(term));
      } else {
        operand2 = numberContainer.pop();
        operand1 = numberContainer.pop();
        // Below 1.7, String cases are not supported.
        // Hence go with index position the operator.
        switch(term)
        //switch(operators.indexOf(term))
        {
          case "+":
            //  0
            numberContainer.push(operand1 + operand2);
            break;
          case "-":
            //  1
            numberContainer.push(operand1 - operand2);
            break;
          case "/":
            //  2
            numberContainer.push(operand1 / operand2);
            break;
          case "*":
            //  3
            numberContainer.push(operand1 * operand2);
            break;
        }
      }
    }
    value = numberContainer.pop();

    return value;
  }

  public boolean isIsomorphic(String word1, String word2)
  {
    if (word1.length() != word2.length()) {
      return false;
    }

    HashMap<Character,Character> characterMatchMap = new HashMap<>();
    char characterFromWord1;
    char characterFromWord2;

    for(int i=0; i < word1.length();i++)
    {
      characterFromWord1 = word1.charAt(i);
      characterFromWord2 = word2.charAt(i);

      Character characterMatchForWord2 = getCharacterMatch(characterMatchMap,characterFromWord2);

      // Check if the key matches given the value
      if (characterMatchForWord2 != null && characterMatchForWord2 != characterFromWord1) {
        return false;
      } else if (characterMatchMap.containsKey(characterFromWord1)) {
        // Check if the value matches given the key
        if (characterFromWord2 != characterMatchMap.get(characterFromWord1)) {
          return false;
        }
      } else {
        // Add the pair
        characterMatchMap.put(characterFromWord1,characterFromWord2);
      }
    }
    return true;
  }

  private Character getCharacterMatch(HashMap<Character,Character> map, char value)
  {
    for (Map.Entry<Character,Character> entry : map.entrySet())
    {
      if (entry.getValue() == value) {
        return entry.getKey();
      }
    }
    return null;
  }

  public int smallestTransformationWordLadder(String start, String end, Set<String> dictionary)
  {
    if (dictionary.size() == 0)
      return 0;

    LinkedList<String> wordQueue = new LinkedList<>();
    LinkedList<Integer> distanceQueue = new LinkedList<>();

    dictionary.add(end);
    // Two queues for BFS
    wordQueue.add(start);
    distanceQueue.add(1);

    int smallestDistance = Integer.MAX_VALUE;

    while (!wordQueue.isEmpty())
    {
      String currentWord = wordQueue.pop();
      Integer currentDistance = distanceQueue.pop();
      char[] characterArray = currentWord.toCharArray();

      // To ensure all possible ways the target word is achieved
      if (currentWord.equals(end)) {
        smallestDistance = Integer.min(smallestDistance,currentDistance);
      }

      for (int i = 0; i < currentWord.length();i++)
      {
        for (char substituteChar = 'a';substituteChar <= 'z'; substituteChar++)
        {
          characterArray[i] = substituteChar;
          String updatedWord = new String(characterArray);
          if (dictionary.contains(updatedWord)) {
            wordQueue.push(updatedWord);
            distanceQueue.push(currentDistance+1);
            dictionary.remove(updatedWord);
          }
        }
      }
    }

    if (smallestDistance == Integer.MAX_VALUE) {
      smallestDistance = 0;
    }
    return smallestDistance;
  }
}
