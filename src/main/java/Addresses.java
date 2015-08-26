import java.util.List;
import org.sql2o.*;


public class Addresses {
  private int id;
  private int restaurant_id;
  private int street_number;
  private String street_name;
  private String city;
  private String state;
  private int zip;

  public Addresses(int id, int restaurant_id, int street_number, String street_name, String city, String state, int zip) {
    this.id = id;
    this.restaurant_id = restaurant_id;
    this.street_number = street_number;
    this.street_name = street_name;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  public int getId() {
    return id;
  }

  public int getRestaurantId() {
    return restaurant_id;
  }

  public int getStreetNumber() {
    return street_number;
  }

  public String getStreetName() {
    return street_name;
  }

  public String getCity() {
     return city;
  }


  public String getState() {
    return state;
  }

  public int getZip() {
     return zip;
  }


  // @Override
  // public boolean equals(Object otherSpecialty) {
  //   if(!(otherSpecialty instanceof Specialty )) {
  //     return false;
  //   }
  //   else {
  //     Specialty newSpecialty = (Specialty) otherSpecialty;
  //     return this.getSpecialty().equals(newSpecialty.getSpecialty());
  //   }
  // }
  //
  // public static List<Specialty> all() {
  //   String sql ="SELECT id, specialty FROM specialties";
  //   try(Connection con = DB.sql2o.open()) {
  //     return con.createQuery(sql).executeAndFetch(Specialty.class);
  //   }
  // }
  //
  // public void save() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql ="INSERT INTO specialties (specialty) values (:specialty)";
  //     this.id = (int) con.createQuery(sql,true)
  //     .addParameter("specialty", this.specialty)
  //     .executeUpdate()
  //     .getKey();
  //   }
  // }
  //
  // public static Specialty find(int id) {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql ="select * from specialties where id=:id";
  //     Specialty specialty = con.createQuery(sql)
  //     .addParameter("id",id)
  //     .executeAndFetchFirst(Specialty.class);
  //     return specialty;
  //   }
  // }
  //
  // public List<Doctor> getDoctors() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM doctors where specialty_id=:id";
  //     return con.createQuery(sql)
  //      .addParameter("id", this.id)
  //      .executeAndFetch(Doctor.class);
  //   }
  // }
}
