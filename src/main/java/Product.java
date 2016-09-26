import org.sql2o.*;
import java.util.List;

public class Product {
  public String name;
  public String description;
  public int categoryId;
  public float price;
  public float cost;
  public int id;

  public Product(String name, String description, int categoryId, float cost){
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.cost = cost;
    this.price = cost *2;
    this.save();
}
  public String getName() {
    return name;
  }
  public String getDescription() {
    return description;
  }
  public int getCategoryId() {
    return categoryId;
  }
  public float getCost() {
    return cost;
  }
  public float getPrice() {
    return price;
  }
  public static List<Product> all() {
    String sql = "SELECT * FROM products";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Product.class);
    }
  }

  public static List<Product> allByCategory(int id) {
    String sql = "SELECT * FROM products WHERE categoryId=:id";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetch(Product.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO products (name, description, categoryId, price, cost) VALUES (:name, :description, :categoryId, :price, :cost)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("description", this.description)
        .addParameter("categoryId", this.categoryId)
        .addParameter("price", this.price)
        .addParameter("cost", this.cost)
        .executeUpdate()
        .getKey();
    }
  }

}
