// import org.sql2o.*;
// import org.junit.*;
// import static org.junit.Assert.*;
//
// public class ProductTest {
//   private Product product;
//   private Product product2;
//   private Product product3;
//
//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bookstore_test", null, null);
//     product = new Product("My Little Dragon", "A fantastic story about a little dragon in Narnia.", 1, 2);
//     product2 = new Product("How to Be the Greatest Ever", "Donald Trump narrates how he became the greatest person to ever live.", 2, 100);
//     product3 = new Product("The Cowboy and his Milk Girl", "A lonely cowboy finds himself lost, until a mysterious milk girl saves him from his misery.", 3, 10);
//   }
//
//   @Test
//   public void Product_instantiates_true() {
//     assertEquals(true, product instanceof Product);
//   }
//   @Test
//   public void find_returnCorrectProduct_true() {
//     assertTrue(Product.find(product.getId()).equals(product));
//   }
//   @Test
//   public void all_returnsAllInstances_true() {
//     assertTrue(Product.all().size()>1);
//   }
//   @Test
//   public void allByCategory_returnsInstancesByCategory_true() {
//     assertTrue(Product.allByCategory(3).get(0).getName().equals("The Cowboy and his Milk Girl"));
//   }
//
//   @After
//   public void tearDown() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "DELETE FROM products *;";
//       con.createQuery(sql).executeUpdate();
//     }
//   }
// }
