import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;

public class AddressesTest {

  // @Rule
  // public DatabaseRule database = new DatabaseRule();

  // @Test
  // public void all_emptyAtFirst() {
  // assertEquals(Addresses.all().size(), 0);
  // }

  @Test
  public void address_instantiates_true() {
  Addresses myAddresses = new Addresses(1, 2, 503, "18th Ave", "Portland", "OR", 97212);
  assertEquals(true, myAddresses instanceof Addresses);
  }

  @Test
  public void addresses_returnsParametesValue_id() {
    Addresses testAddresses = new Addresses(1, 2, 503, "18th Ave", "Portland", "OR", 97212);
    assertEquals(1, testAddresses.getId());
  }

  @Test
  public void addresses_returnsParametersValue_restaurantId() {
    Addresses testAddresses = new Addresses(1, 2, 503, "18th Ave", "Portland", "OR", 97212);
    assertEquals(2, testAddresses.getRestaurantId());
  }

  @Test
  public void addresses_returnsParametersValue_street_number() {
    Addresses testAddresses = new Addresses(1, 2, 503, "18th Ave", "Portland", "OR", 97212);
    assertEquals(503, testAddresses.getStreetNumber());
  }

  @Test
  public void addresses_returnsParametersValue_streetName() {
    Addresses testAddresses = new Addresses(1, 2, 503, "18th Ave", "Portland", "OR", 97212);
    assertEquals("18th Ave", testAddresses.getStreetName());
  }

  @Test
  public void addresses_returnsParametersValue_city() {
    Addresses testAddresses = new Addresses(1, 2, 503, "18th Ave", "Portland", "OR", 97212);
    assertEquals("Portland", testAddresses.getCity());
  }

  @Test
  public void addresses_returnsParametersValue_state() {
    Addresses testAddresses = new Addresses(1, 2, 503, "18th Ave", "Portland", "OR", 97212);
    assertEquals("OR", testAddresses.getState());
  }

  @Test
  public void addresses_returnsParametersValue_zip() {
    Addresses testAddresses = new Addresses(1, 2, 503, "18th Ave", "Portland", "OR", 97212);
    assertEquals(97212, testAddresses.getZip());
  }

}
