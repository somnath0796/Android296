package develops.mad.productmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProdManager.db";

    //Table Products Data
    public static final String TABLE_PRODUCTS = "Products";
    public static final String COLUMN_ID = "P_Id";
    public static final String COLUMN_TITLE = "P_Name";
    public static final String COLUMN_PRICE = "P_Price";
    public static final String COLUMN_DOM = "P_DateMfg";

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_PRICE + " REAL, " +
                COLUMN_DOM + " TEXT " +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addProduct(@NonNull Products prod){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, prod.get_name());
        values.put(COLUMN_PRICE,prod.get_price());
        values.put(COLUMN_DOM, prod.get_dateMfg());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    public void updateProduct(@NonNull Products prod){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, prod.get_name());
        values.put(COLUMN_PRICE,prod.get_price());
        values.put(COLUMN_DOM, prod.get_dateMfg());

        db.update(TABLE_PRODUCTS,values,"P_Id = ? ", new String[] { Integer.toString(prod.get_id()) });

        db.close();
    }

    public void deleteProduct(int id, boolean all){
        SQLiteDatabase db = getWritableDatabase();
        if(!all){
            db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE "+ COLUMN_ID +" = " + id + ";");
        }
        else{
            db.execSQL("DELETE FROM " + TABLE_PRODUCTS +";" );
        }

        db.close();
    }

    @NonNull
    public ArrayList<Products> getProducts(){
        String dbString = "";
        ArrayList<Products> p = new ArrayList<Products>();
        Products prod;


        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1;";

        //Cursor point to a location in your results
        Cursor c = db.rawQuery(query,null);


        //Move to the first row of results
        c.moveToFirst();

        while(!c.isAfterLast()){

            prod = new Products();
            if(c.getString(c.getColumnIndex("P_Id"))!= null){
                prod.set_id(Integer.parseInt(c.getString(c.getColumnIndex("P_Id"))));
            }

            if(c.getString(c.getColumnIndex("P_Name"))!= null){
                prod.set_name(c.getString(c.getColumnIndex("P_Name")));
            }

            if(c.getString(c.getColumnIndex("P_Price"))!= null){
                prod.set_price(Double.parseDouble(c.getString(c.getColumnIndex("P_Price"))));
            }

            if(c.getString(c.getColumnIndex("P_DateMfg"))!= null){
                prod.set_dateMfg(c.getString(c.getColumnIndex("P_DateMfg")));
            }
            p.add(prod);

            //go to next result row
            c.moveToNext();

        }

        db.close();
        return p;
    }

}
