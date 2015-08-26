import java.util.Arrays;
import org.junit.*;
import org.junit.Rule;
import static org.junit.Assert.*;

public class CuisinesTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void cuisine_instantiates_true() {
  Cuisines myCuisines = new Cuisines("Mexican");
  assertEquals(true, myCuisines instanceof Cuisines);
  }

  @Test
  public void cuisines_returnsParametersValue_type() {
    Cuisines testCuisines = new Cuisines("Mexican");
    assertEquals("Mexican", testCuisines.getType());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Cuisines.all().size(), 0);
  }

  @Test
  public void save_insertsValueIntoCuisines_true() {
    Cuisines testCuisines = new Cuisines("Mexican");
    testCuisines.save();
    Cuisines savedCuisine = Cuisines.first();
    assertTrue(savedCuisine.equals(testCuisines));
  }

  @Test
  public void all_cuisine_returns_allTheValues() {
    Cuisines testCuisines = new Cuisines("Mexican");
    testCuisines.save();
    assertEquals(Cuisines.first().getType(), testCuisines.getType());
  }

  @Test
  public void find_findsCuisineInDatabase_true() {
    Cuisines testCuisines = new Cuisines("Vietnamese");
    testCuisines.save();
    Cuisines savedCuisine = Cuisines.find(testCuisines.getId());
    assertTrue(testCuisines.equals(savedCuisine));
  }


}
