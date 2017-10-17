package Trie;

import java.util.LinkedList;

class TrieNode
{
  char letter;
  boolean isEndOfStringSequence; // Used to figure out the end of a sequence
  int countOfAlphabet; // Used to decide whether to remove the node or not
  LinkedList<TrieNode> listOfChildLetters; // Saves space instead of array storing 26 letters

  public TrieNode(char letter)
  {
    this.letter = letter;
    isEndOfStringSequence = false;
    countOfAlphabet = 0;
    listOfChildLetters = new LinkedList<TrieNode>();
  }

  // In order to check whether the letter exists or not
  public TrieNode fetchChildLetter(char letter)
  {
    if (listOfChildLetters != null)
    for (TrieNode childletter : listOfChildLetters)
    {
      if (childletter.letter == letter) {
        return childletter;
      }
    }
    return null;
  }
}

public class Trie
{
  private TrieNode root;


    public Trie()
    {
      root = new TrieNode(' ');
    }

  public void insert(String phrase)
  {
    if (search(phrase)) {
      return;
    }
    TrieNode currentParent = root;
    for (char letter : phrase.toCharArray())
    {
      TrieNode childLetter = currentParent.fetchChildLetter(letter);
      if (childLetter == null) {
        currentParent.listOfChildLetters.add(new TrieNode(letter));
        currentParent = currentParent.fetchChildLetter(letter);
      } else {
        // This saves one iteration through listOfChildLetters
        currentParent = childLetter;
      }
      currentParent.countOfAlphabet++;
    }
    currentParent.isEndOfStringSequence = true;
  }

  public void remove(String phrase)
  {
    TrieNode currentParent = root;
    if (!search(phrase)) {
      return;
    }

    for (char letter : phrase.toCharArray())
    {
      TrieNode childLetter = currentParent.fetchChildLetter(letter);
      childLetter.countOfAlphabet--;
      if (childLetter.countOfAlphabet == 0) {
        currentParent.listOfChildLetters.remove(childLetter);
        return;
      }
      currentParent = childLetter;
    }
    currentParent.isEndOfStringSequence = false;
  }

  public boolean search(String phrase)
  {
    TrieNode currentParent = root;
    // In every iteration the char in question will be
    // updated to the parent node
    for (char letter : phrase.toCharArray())
    {
      if (currentParent.fetchChildLetter(letter) == null){
        return false;
      }
      currentParent = currentParent.fetchChildLetter(letter);
    }
    // If it is out of this loop and we actually have a
    // pattern stored in Trie. Chances are currentParent
    // will have children due to other patterns stores.
    // e.g. "bat" and "bates". Search "bat"
    if (currentParent.isEndOfStringSequence) {
      return true;
    }
    return false;
  }
}




