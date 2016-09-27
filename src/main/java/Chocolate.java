import org.sql2o.*;
import java.util.List;

public class Chocolate extends Product {
  public String type;
  public int count;
  public String brand;

  public Chocolate(String name, String description, int categoryId, float cost, String type, int count, String brand){
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.cost = cost;
    this.price = cost *2;
    this.save();
    this.type = type;
    this.count = count;
    this.brand = brand;
}
public static Chocolate find(int id) {
  try(Connection cn = DB.sql2o.open()) {
    String sql = "SELECT * FROM products WHERE id=:id";
    Chocolate chocolate = cn.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false)
      .executeAndFetchFirst(Chocolate.class);
    return chocolate;
  }
}

public static List<Chocolate> allByCategory(int id) {
  String sql = "SELECT * FROM products WHERE categoryId=:id";
  try(Connection cn = DB.sql2o.open()) {
    return cn.createQuery(sql)
    .addParameter("id", id)
    .throwOnMappingFailure(false)
    .executeAndFetch(Chocolate.class);
  }
}

public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO products (name, description, categoryId, price, cost, type, typeId, count, brand, details) VALUES (:name, :description, :categoryId, :price, :cost, :type, 1, :count, :brand, :details)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("description", this.description)
      .addParameter("categoryId", this.categoryId)
      .addParameter("price", this.price)
      .addParameter("cost", this.cost)
      .addParameter("type", this.type)
      .addParameter("brand", this.brand)
      .throwOnMappingFailure(false)
      .executeUpdate()
      .getKey();
  }
}


}
