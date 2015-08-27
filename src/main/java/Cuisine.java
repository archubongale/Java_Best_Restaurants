import java.util.*;
import org.sql2o.*;

public class Cuisine {
  private Integer id;
  private String type;

  public Cuisine(String type) {
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
    if (!(otherCuisine instanceof Cuisine)) {
      return false;
    } else {
      Cuisine newCuisine = (Cuisine) otherCuisine;
      return this.getId() == newCuisine.getId() && // == for primitive equality
             this.getType().equals(newCuisine.getType()); // .equals for object equality
    }
  }

  public static List<Cuisine> all() {
    String sql = "SELECT * FROM cuisines";
    try(Connection con = DB.sql2o.open()) {
       return con.createQuery(sql).executeAndFetch(Cuisine.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO cuisines (type) VALUES (:type)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("type", this.type)
        .executeUpdate()
        .getKey();
     }
  }

   public static Cuisine find(int id) {
     try(Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM cuisines where id=:id";
       Cuisine cuisine = con.createQuery(sql)
         .addParameter("id", id)
         .executeAndFetchFirst(Cuisine.class);
       return cuisine;
     }
   }

  public static Cuisine first() {
    return all().get(0);
  }

}
