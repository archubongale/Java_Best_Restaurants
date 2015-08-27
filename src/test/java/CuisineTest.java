import java.util.Arrays;
import org.junit.*;
import org.junit.Rule;
import static org.junit.Assert.*;

public class CuisineTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void cuisine_instantiates_true() {
    Cuisine myCuisine = new Cuisine("Mexican");
    assertTrue(myCuisine instanceof Cuisine);
  }

  @Test
  public void cuisine_returnsParametersValue_type() {
    Cuisine testCuisine = new Cuisine("Mexican");
    assertEquals("Mexican", testCuisine.getType());
  }

  @Test
  public void cuisine_returnsParameterValue_id() {

  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Cuisine.all().size(), 0);
  }

  @Test
  public void all_returnsAllFromDB() {
    Cuisine testCuisine = new Cuisine("Mexican");
    testCuisine.save();
    assertEquals(Cuisine.first().getType(), "Mexican");
  }

  @Test
  public void equals_returnsTrueIfSameTypes_true() {
    Cuisine testCuisine = new Cuisine("Mexican");
    testCuisine.save();
    Cuisine nextTestCuisine = new Cuisine("Mexican");
    nextTestCuisine.save();
    assertTrue(testCuisine.getType().equals(nextTestCuisine.getType()));
  }

  @Test
  public void equals_returnsFalseIfDifferentTypes_false() {
    Cuisine testCuisine = new Cuisine("Mexican");
    testCuisine.save();
    Cuisine nextTestCuisine = new Cuisine("Chinese");
    nextTestCuisine.save();
    assertEquals(false, testCuisine.getType().equals(nextTestCuisine.getType()));
  }

  @Test
  public void save_savesIntoDatabase() {
     Cuisine testCuisine = new Cuisine("Persian");
     testCuisine.save();
     Cuisine savedCuisine = Cuisine.first();
     assertEquals(testCuisine.getId(), savedCuisine.getId());
  }

  @Test
  public void save_assignsIdToObject_true() {
    Cuisine testCuisine = new Cuisine("Mexican");
    testCuisine.save();
    Cuisine savedCuisine = Cuisine.first();
    assertTrue(savedCuisine.equals(testCuisine));
  }

  @Test
  public void find_findsCuisineInDatabase_true() {
    Cuisine testCuisine = new Cuisine("Vietnamese");
    testCuisine.save();
    Cuisine savedCuisine = Cuisine.find(testCuisine.getId());
    assertTrue(testCuisine.equals(savedCuisine));
  }

  @Test
  public void getRestaurants_returnsAllRestaurantsOfTypeFromDB() {

  }

}
