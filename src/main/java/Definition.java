import java.util.ArrayList;

public class Definition{
  private static ArrayList<Definition> definitionInstances = new ArrayList<Definition>();
  private String mDefinition;

  public Definition(String definition) {
    mDefinition = definition;
    definitionInstances.add(this);
  }

  public String getDefinition() {
    return mDefinition;
  }

  public static ArrayList<Definition> all() {
    return definitionInstances;
  }

  public static void clear() {
    definitionInstances.clear();
  }

}
