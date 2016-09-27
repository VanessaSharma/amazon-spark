// import org.sql2o.*;
// import org.junit.*;
// import static org.junit.Assert.*;
//
// public class ChocolateTest {
//   private Chocolate chocolate;
//   private Chocolate chocolate2;
//   private Chocolate chocolate3;
//
//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bookstore_test", null, null);
//     chocolate = new Chocolate("California Carbenet Sauvignon", "ONEHOPE", 2013, "Carbenet Sauvignon");
//     chocolate2 = new Chocolate("Pinot Noir", "ONEHOPE", 2013, "Pinot Noir");
//     chocolate3 = new Chocolate("California Merlot", "ONEHOPE", 2013, "Merlot");
//   }
//
//   @Test
//   public void Chocolate_instantiates_true() {
//     assertEquals(true, chocolate instanceof Chocolate);
//   }
//   @Test
//   public void find_returnCorrectChocolate_true() {
//     assertTrue(Chocolate.find(chocolate.getId()).equals(chocolate));
//   }
//   @Test
//   public void all_returnsAllInstances_true() {
//     assertTrue(Chocolate.all().size()>1);
//   }
//   @Test
//   public void allByCategory_returnsInstancesByCategory_true() {
//     assertTrue(Chocolate.allByCategory(3).get(0).getName().equals("California Merlot"));
//   }
//
//   @After
//   public void tearDown() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "DELETE FROM chocolates *;";
//       con.createQuery(sql).executeUpdate();
//     }
//   }
// }
