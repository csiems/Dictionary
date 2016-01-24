import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Word implements Comparable<Word>{
  private static ArrayList<Word> wordInstances = new ArrayList<Word>();
  private String mWord;
  private ArrayList<Definition> mDefinitions = new ArrayList<Definition>();
  private int mId;

  public Word(String word) {
    mWord = word;
    wordInstances.add(this);
    mId = wordInstances.size();
  }

  @Override
  public int compareTo(Word other) {
    if (equals(other)) {
      return 0;
    }

    return mWord.compareTo(other.mWord);
  }

  public String getWord() {
    return mWord;
  }

  public ArrayList<Definition> getAllDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public static ArrayList<Word> all() {
    return wordInstances;
  }

  public int getId() {
    return mId;
  }

  public static Word find(int id) {
    for(Word word : wordInstances) {
      if(id == word.getId()) {
        return word;
      }
    }
    throw new NoSuchElementException();
  }

  public static void clear() {
    wordInstances.clear();
  }

}
