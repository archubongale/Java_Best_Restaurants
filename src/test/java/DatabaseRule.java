import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/best_restaurant_test", null, null);
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteRestaurantQuery = "DELETE FROM restaurant *;";
      String deleteCuisineQuery = "DELETE FROM cuisines *;";
      String deleteAddressQuery = "DELETE FROM addresses *;";
      con.createQuery(deleteRestaurantQuery).executeUpdate();
      con.createQuery(deleteCuisineQuery).executeUpdate();
      con.createQuery(deleteAddressQuery).executeUpdate();


    }
  }
}
