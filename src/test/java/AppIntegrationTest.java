import org.fluentlenium.adapter.FluentTest;
import java.util.ArrayList;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  // @ClassRule
  // public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
    goTo("http://localhost4567/");
    assertThat(pageSource().contains("Restaurants"));
  }

  // @Test
  // public void cuisineIsCreatedTest() {
  //   goTo("http://localhost:4567/");
  //   click("a",withText("Add a restaurant"));
  //   fill("#name").with("Mexican");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Add a restaurant");
  // }


}
