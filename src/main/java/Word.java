import java.util.ArrayList;

public class Word implements Comparable{
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
  public int compareTo(Object obj) {
    Word other = (Word) obj;
    if (equals(other)) {
      return 0;
    }
    int wordCmp = mWord.compareTo(other.mWord);
    // if (wordCmp == 0) {
    //   return mType.compareTo(other.mType);
    // }
    return wordCmp;
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
    try {
      return wordInstances.get(id - 1);
    } catch (IndexOutOfBoundsException oob) {
      return null;
    }
  }

  public static void clear() {
    wordInstances.clear();
  }

}
