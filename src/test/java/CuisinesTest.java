import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;

public class CuisinesTest {
  // @Rule
  // public DatabaseRule database = new DatabaseRule();
  //

  @Test
  public void cuisine_instantiates_true() {
  Cuisines myCuisines = new Cuisines(1,"Mexican");
  assertEquals(true, myCuisines instanceof Cuisines);
  }

  @Test
  public void cuisines_returnsParametersValue_id() {
    Cuisines testCuisines = new Cuisines(1,"Mexican");
    assertEquals(1, testCuisines.getId());
  }

  @Test
  public void cuisines_returnsParametersValue_type() {
    Cuisines testCuisines = new Cuisines(1,"Mexican");
    assertEquals("Mexican", testCuisines.getType());
  }

}
