import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("to regard as a concrete thing");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiateWithDefinition_true() {
    Definition myDefinition = new Definition("to regard as a concrete thing");
    assertEquals("to regard as a concrete thing", myDefinition.getDefinition());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("to regard as a concrete thing");
    Definition secondDefinition = new Definition("make (something abstract) more concrete or real.");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList() {
    Definition firstDefinition = new Definition("to regard as a concrete thing");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }
}
