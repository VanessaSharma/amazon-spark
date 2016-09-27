// import org.sql2o.*;
// import org.junit.*;
// import static org.junit.Assert.*;
//
// public class WineTest{
//   private Wine wine;
//   private Wine wine2;
//   private Wine wine3;
//
//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bookstore_test", null, null);
//     wine = new Wine("California Carbenet Sauvignon", "ONEHOPE", 2013, "Carbenet Sauvignon");
//     wine2 = new Wine("Pinot Noir", "ONEHOPE", 2013, "Pinot Noir");
//     wine3 = new Wine("California Merlot", "ONEHOPE", 2013, "Merlot");
//   }
//
//   @Test
//   public void Wine_instantiates_true() {
//     assertEquals(true, wine instanceof Wine);
//   }
//   @Test
//   public void find_returnCorrectWine_true() {
//     assertTrue(Wine.find(wine.getId()).equals(wine));
//   }
//   @Test
//   public void all_returnsAllInstances_true() {
//     assertTrue(Wine.all().size()>1);
//   }
//   @Test
//   public void allByCategory_returnsInstancesByCategory_true() {
//     assertTrue(Wine.allByCategory(3).get(0).getName().equals("California Merlot"));
//   }
//
//   @After
//   public void tearDown() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "DELETE FROM wines *;";
//       con.createQuery(sql).executeUpdate();
//     }
//   }
// }
