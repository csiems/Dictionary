import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
    public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Dictionary");
    }

  @Test
    public void newWordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText ("Add A New Word"));
    fill("#newWord").with("reify");
    submit(".btn");
    assertThat(pageSource()).contains("reify");
  }

  @Test
    public void multipleWordsAreCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText ("Add A New Word"));
    fill("#newWord").with("reify");
    submit(".btn");
    click("a", withText ("Add A New Word"));
    fill("#newWord").with("hebetude");
    submit(".btn");
    assertThat(pageSource()).contains("reify");
    assertThat(pageSource()).contains("hebetude");
  }

  @Test
    public void newDefinitionIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText ("Add A New Word"));
    fill("#newWord").with("reify");
    submit(".btn");
    goTo("http://localhost:4567/index/1");
    click("a", withText ("Add a new definition"));
    fill("#newDefinition").with("to regard something abstract as concrete");
    submit(".btn");
    goTo("http://localhost:4567/index/1");
    assertThat(pageSource()).contains("to regard something abstract as concrete");
  }

  @Test
    public void multipleDefinitionsAreCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText ("Add A New Word"));
    fill("#newWord").with("reify");
    submit(".btn");
    goTo("http://localhost:4567/index/1");
    click("a", withText ("Add a new definition"));
    fill("#newDefinition").with("to regard something abstract as concrete");
    submit(".btn");
    goTo("http://localhost:4567/index/1");
    click("a", withText ("Add a new definition"));
    fill("#newDefinition").with("to convert into a concrete thing");
    submit(".btn");
    goTo("http://localhost:4567/index/1");
    assertThat(pageSource()).contains("to regard something abstract as concrete");
    assertThat(pageSource()).contains("to convert into a concrete thing");
  }


}
