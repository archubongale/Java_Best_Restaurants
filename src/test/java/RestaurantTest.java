import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class RestaurantTest {

     @Rule
     public DatabaseRule database = new DatabaseRule();


     @Test
     public void restaurant_instantiates_true() {
       Restaurant myRestaurant = new Restaurant("PokPok","503-443-2432");
       assertTrue(myRestaurant instanceof Restaurant);
     }

     @Test
     public void restaurant_returnsParametersValue_name() {
       Restaurant testRestaurant = new Restaurant("PokPok","503-443-2432");
       assertEquals("PokPok", testRestaurant.getName());
     }

     @Test
     public void restaurant_returnsParametersValue_phone() {
       Restaurant testRestaurant = new Restaurant("PokPok","503-443-2432");
       assertEquals("503-443-2432", testRestaurant.getPhone());
     }
     @Test
     public void all_emptyAtFirst() {
       assertEquals(Restaurant.all().size(), 0);
     }

     @Test
     public void all_returnsAllValues() {
       Restaurant testRestaurant = new Restaurant("PokPok","503-443-2432");
       testRestaurant.save();
       assertEquals(Restaurant.first().getPhone(), "503-443-2432");
     }

     @Test
     public void equals_returnsTrueIfSameName_true() {
       Restaurant testRestaurant = new Restaurant("KoiFusion", "503-718-7990");
       testRestaurant.save();
       Restaurant nextRestaurant = new Restaurant("KoiFusion", "503-718-7990");
       nextRestaurant.save();
       assertTrue(testRestaurant.getName().equals(nextRestaurant.getName()));
     }

     @Test
     public void equals_returnsFalseIfDifferentName_false() {
       Restaurant testRestaurant = new Restaurant("KoiFusion", "503-718-7990");
       testRestaurant.save();
       Restaurant nextRestaurant = new Restaurant("Nicolas Food", "503-721-1680");
       nextRestaurant.save();
       assertEquals(false, testRestaurant.getName().equals(nextRestaurant.getName()));
     }

     @Test
     public void save_savesIntoDatabase() {
       Restaurant testRestaurant = new Restaurant("KoiFusion", "503-718-7990");
       testRestaurant.save();
       Restaurant savedRestaurant = Restaurant.first();
       assertEquals(testRestaurant.getId(), savedRestaurant.getId());
     }

     @Test
     public void save_assignsNameToObject() {
       Restaurant testRestaurant = new Restaurant("PokPok","503-443-2432");
       testRestaurant.save();
       Restaurant savedRestaurant = Restaurant.first();
       assertEquals(savedRestaurant.getName(), "PokPok");
     }

     @Test
     public void find_findsRestaurantInDatabase() {
       Restaurant testRestaurant = new Restaurant("PokPok","503-443-2432");
       testRestaurant.save();
       Restaurant savedRestaurant = Restaurant.find(testRestaurant.getId());
       assertEquals(savedRestaurant.getName(), "PokPok");
     }

     @Test
     public void delete_deletesRestaurantFromDatabase_true() {

     }

}
