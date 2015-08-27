import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;

public class AddressTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void address_instantiates_true() {
    Address testAddress = new Address(503, "18th Ave", "Portland", "OR", 97212);
    assertEquals(true, testAddress instanceof Address);
  }

  @Test
  public void address_returnsParametersValue_street_number() {
    Address testAddress = new Address(503, "18th Ave", "Portland", "OR", 97212);
    assertEquals(503, testAddress.getStreetNumber());
  }

  @Test
  public void address_returnsParametersValue_streetName() {
    Address testAddress = new Address(503, "18th Ave", "Portland", "OR", 97212);
    assertEquals("18th Ave", testAddress.getStreetName());
  }

  @Test
  public void address_returnsParametersValue_city() {
    Address testAddress = new Address(503, "18th Ave", "Portland", "OR", 97212);
    assertEquals("Portland", testAddress.getCity());
  }

  @Test
  public void address_returnsParametersValue_state() {
    Address testAddress = new Address(503, "18th Ave", "Portland", "OR", 97212);
    assertEquals("OR", testAddress.getState());
  }

  @Test
  public void address_returnsParametersValue_zip() {
    Address testAddress = new Address(503, "18th Ave", "Portland", "OR", 97212);
    assertEquals(97212, testAddress.getZip());
  }

  @Test
    public void all_emptyAtFirst() {
    assertEquals(Address.all().size(), 0);
  }

  @Test
  public void all_returnsAllFromDatabase() {
    Address testAddress = new Address(108,"Fernhill Drive","San Jose","CA",95136);
    testAddress.save();
    assertEquals(Address.first().getStreetName(), "Fernhill Drive");
  }

  @Test
  public void equals_returnsTrueIfSameCity_true() {
    Address testAddress = new Address(503, "Washington Ave", "Portland", "OR", 97212);
    testAddress.save();
    Address nextAddress = new Address(12, "Madison Place", "Portland", "OR", 97211);
    nextAddress.save();
    assertTrue(testAddress.getCity().equals(nextAddress.getCity()));
  }

  @Test
  public void equals_returnsFalseIfDifferentCity_false() {
    Address testAddress = new Address(503, "Washington Ave", "Portland", "OR", 97212);
    testAddress.save();
    Address nextAddress = new Address(12, "Madison Place", "Astoria", "OR", 97321);
    nextAddress.save();
    assertEquals(false, testAddress.getCity().equals(nextAddress.getCity()));
  }

  @Test
  public void save_savesIntoDatabase() {
    Address testAddress = new Address(108,"Fernhill Drive","San Jose","CA",95136);
    testAddress.save();
    Address savedAddress = Address.first();
    assertEquals(testAddress.getId(), savedAddress.getId());
  }

  @Test
  public void save_assignsIdToObject() {
    Address testAddress = new Address(108,"Foothill Drive","San Jose","CA",95136);
    testAddress.save();
    Address savedAddress = Address.first();
    assertEquals(testAddress.getId(), savedAddress.getId());
  }

  @Test
  public void find_findsAddressInDatabase_true() {
    Address testAddress = new Address(3936,"Going St","Portland","OR",97232);
    testAddress.save();
    Address savedAddress = Address.find(testAddress.getId());
    assertTrue(testAddress.getId() == savedAddress.getId());
  }

}
