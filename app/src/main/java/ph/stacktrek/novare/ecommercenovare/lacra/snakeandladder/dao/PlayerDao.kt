//package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder.dao
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.Cursor
//import android.database.SQLException
//import ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder.model.Player
//
//
//interface PlayerDAO {
//    fun addPlayer(player: Player)
//    fun getPlayer(): ArrayList<Player>
//    fun updatePlayer(player: Player)
//    fun deletePlayer(player: Player)
//}
//
//class PlayerDAOStubImplementation: PlayerDAO{
//    private var playerList: ArrayList<Player> = ArrayList()
//
//    init{
//        playerList.add(Player("Nonie"))
//        playerList.add(Player("Kyle"))
//
//    }
//
//    override fun addProduct(product: Product) {
//        productList.add(product)
//    }
//
//    override fun getProducts(): ArrayList<Product> = productList
//
//    //TODO("Not yet implemented")
//    override fun updateProduct(product: Product) {
//
//    }
//
//    //TODO("Not yet implemented")
//    override fun deleteProduct(product: Product) {
//
//    }
//
//}
//
//class ProductDAOSQLLiteImplementation(var context: Context): ProductDAO{
//    override fun addProduct(product: Product) {
//        val databaseHandler = DatabaseHandler(context)
//        val db = databaseHandler.writableDatabase
//
//        val contentValues = ContentValues()
//        contentValues.put(DatabaseHandler.TABLE_PRODUCT_NAME, product.name)
//
//        var status = db.insert(DatabaseHandler.TABLE_PRODUCT,
//            null,
//            contentValues)
//        db.close()
//    }
//
//    override fun getProducts(): ArrayList<Product> {
//        val databaseHandler = DatabaseHandler(context)
//        val db = databaseHandler.readableDatabase
//        var result = ArrayList<Product>()
//        var cursor: Cursor? = null
//
//        val columns =  arrayOf(DatabaseHandler.TABLE_PRODUCT_ID,
//            DatabaseHandler.TABLE_PRODUCT_NAME)
//
//        try {
//            cursor = db.query(DatabaseHandler.TABLE_PRODUCT,
//                columns,
//                null,
//                null,
//                null,
//                null,
//                null)
//
//        }catch (sqlException: SQLException){
//            db.close()
//            return result
//        }
//
//        var product: Product
//        if(cursor.moveToFirst()){
//            do{
//                product = Product("")
//                product.name = cursor.getString(1)
//                product.id = cursor.getInt(0).toString()
//                result.add(product)
//            }while(cursor.moveToNext())
//        }
//        return result
//    }
//
//    override fun updateProduct(product: Product) {
//        TODO("Not yet implemented")
//    }
//
//    override fun deleteProduct(product: Product) {
//        TODO("Not yet implemented")
//    }
//
//}