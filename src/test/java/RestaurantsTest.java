import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class RestaurantsTest {

    //  @Rule
    //  public DatabaseRule database = new DatabaseRule();
     //

     @Test
     public void restaurant_instantiates_true() {
       Restaurants myRestaurants = new Restaurants(1,3,"PokPok",2,"503-443-2432");
       assertEquals(true, myRestaurants instanceof Restaurants);
     }

     @Test
     public void restaurant_returnsParametersValue_id() {
       Restaurants testRestaurants = new Restaurants(1,3,"PokPok",2,"503-443-2432");
       assertEquals(1, testRestaurants.getId());
     }

     @Test
     public void restaurant_returnsParametersValue_addressId() {
       Restaurants testRestaurants = new Restaurants(1,3,"PokPok",2,"503-443-2432");
       assertEquals(3, testRestaurants.getAddressId());
     }

     @Test
     public void restaurant_returnsParametersValue_name() {
       Restaurants testRestaurants = new Restaurants(1,3,"PokPok",2,"503-443-2432");
       assertEquals("PokPok", testRestaurants.getName());
     }

     @Test
     public void restaurant_returnsParametersValue_cuisineId() {
       Restaurants testRestaurants = new Restaurants(1,3,"PokPok",2,"503-443-2432");
       assertEquals(2, testRestaurants.getCuisineId());
     }

     @Test
     public void restaurant_returnsParametersValue_phone() {
       Restaurants testRestaurants = new Restaurants(1,3,"PokPok",2,"503-443-2432");
       assertEquals("503-443-2432", testRestaurants.getPhone());
     }

}
