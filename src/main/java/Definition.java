import java.util.ArrayList;

public class Definition{
  private static ArrayList<Definition> definitionInstances = new ArrayList<Definition>();
  private String mDefinition;
  private int mId;

  public Definition(String definition) {
    mDefinition = definition;
    definitionInstances.add(this);
    mId = definitionInstances.size();
  }

  public String getDefinition() {
    return mDefinition;
  }

  public static ArrayList<Definition> all() {
    return definitionInstances;
  }

  public int getId() {
    return mId;
  }

  public static Definition find(int id) {
    try {
      return definitionInstances.get(id - 1);
    } catch (IndexOutOfBoundsException oob) {
      return null;
    }
  }

  public static void clearDefinitions() {
    definitionInstances.clear();
  }

}
