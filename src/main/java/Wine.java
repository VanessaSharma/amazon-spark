import org.sql2o.*;
import java.util.List;

public class Wine extends Product{
  public String alcoholContent;
  public String maker;
  public int year;
  public String type;

  public Wine(String name, String description, int categoryId, float cost, String alcoholContent, String maker, int year, String type){
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.cost = cost;
    this.price = cost *2;
    this.save();
    this.alcoholContent = alcoholContent;
    this.maker = maker;
    this.year = year;
    this.type = type;
}

public static Wine find(int id) {
  try(Connection cn = DB.sql2o.open()) {
    String sql = "SELECT * FROM products WHERE id=:id";
    Wine wine = cn.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false)
      .executeAndFetchFirst(Wine.class);
    return wine;
  }
}

public static List<Wine> allByCategory(int id) {
  String sql = "SELECT * FROM products WHERE categoryId=:id";
  try(Connection cn = DB.sql2o.open()) {
    return cn.createQuery(sql)
    .addParameter("id", id)
    .throwOnMappingFailure(false)
    .executeAndFetch(Wine.class);
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
      .addParameter("brand", this.maker)
      .throwOnMappingFailure(false)
      .executeUpdate()
      .getKey();
  }
}



}
