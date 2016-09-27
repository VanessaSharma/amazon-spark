import org.sql2o.*;
import java.util.List;

public abstract class Product {
  public String name;
  public String description;
  public int categoryId;
  public float price;
  public float cost;
  public int id;

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
  public int getId() {
    return id;
  }
  public static List<Product> all() {
    String sql = "SELECT * FROM products";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Product.class);
    }
  }

  @Override
  public boolean equals(Object otherProduct) {
    if(!(otherProduct instanceof Product)) {
      return false;
    } else{
      Product newProduct = (Product) otherProduct;
      return this.getName().equals(newProduct.getName()) && this.getDescription().equals(newProduct.getDescription()) && this.getId() == newProduct.getId();
    }
  }

}
