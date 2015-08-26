import java.util.*;
import org.sql2o.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Cuisines {
  private String type;
  private Integer id;


  public Cuisines(String type) {
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  @Override
  public boolean equals(Object otherCuisine) {
    if (!(otherCuisine instanceof Cuisines)) {
      return false;
    } else {
      Cuisines newCuisine = (Cuisines) otherCuisine;
      return this.getId() == newCuisine.getId() && // == for primitive equality
             this.getType().equals(newCuisine.getType()); // .equals for object equality
    }
  }

  public static List<Cuisines> all() {
  String sql = "SELECT * FROM cuisines";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Cuisines.class);
  }
 }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO cuisines (type) VALUES (:type)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("type", type)
      .executeUpdate()
      .getKey();
   }
}
   public static Cuisines find(int id) {
   try(Connection con = DB.sql2o.open()) {
     String sql = "SELECT * FROM cuisines where id=:id";
     Cuisines cuisine = con.createQuery(sql)
       .addParameter("id", id)
       .executeAndFetchFirst(Cuisines.class);
     return cuisine;
   }
 }

  public static Cuisines first() {
    return all().get(0);
  }
}
