import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word myWord = new Word("reify");
    assertEquals(true, myWord instanceof Word);
  }
}
