import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word myWord = new Word("reify");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void Word_instantiateWithWord_true() {
    Word myWord = new Word("reify");
    assertEquals("reify", myWord.getWord());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("reify");
    Word secondWord = new Word("hebetude");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void newId_wordsInstantiateWithAnID_true() {
    Word myWord = new Word("reify");
    assertEquals(Word.all().size(), myWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
    Word firstWord = new Word("reify");
    Word secondWord = new Word("hebetude");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }

  @Test
  public void clearWords_emptiesAllWordsFromArrayList() {
    Word firstWord = new Word("reify");
    Word.clearWords();
    assertEquals(Word.all().size(), 0);
  }
}
