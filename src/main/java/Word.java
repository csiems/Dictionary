import java.util.ArrayList;

public class Word{
  private static ArrayList<Word> wordInstances = new ArrayList<Word>();
  private String mWord;
  private int mId;

  public Word(String word) {
    mWord = word;
    wordInstances.add(this);
    mId = wordInstances.size();
  }

  public String getWord() {
    return mWord;
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

  public static void clearWords() {
    wordInstances.clear();
  }

}
