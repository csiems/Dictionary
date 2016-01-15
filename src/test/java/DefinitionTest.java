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
  public void newId_wordsInstantiateWithAnID_true() {
    Definition myDefinition = new Definition("to regard as a concrete thing");
    assertEquals(Definition.all().size(), myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("to regard as a concrete thing");
    Definition secondDefinition = new Definition("make (something abstract) more concrete or real.");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(999) == null);
  }

  @Test
  public void clearDefinitions_emptiesAllDefinitionsFromArrayList() {
    Definition firstDefinition = new Definition("to regard as a concrete thing");
    Definition.clearDefinitions();
    assertEquals(Definition.all().size(), 0);
  }
}
