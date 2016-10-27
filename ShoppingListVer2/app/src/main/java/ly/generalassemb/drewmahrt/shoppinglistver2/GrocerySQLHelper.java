package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NikitaShuvalov on 10/25/16.
 */



public class GrocerySQLHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "SHOPPING_DB";
    public static final String TABLE_NAME = "SHOPPING_LIST";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "ITEM_NAME";
    public static final String COL_DESCRIPTION = "DESCRIPTION";
    public static final String COL_PRICE = "PRICE";
    public static final String COL_TYPE = "TYPE";

    private static final String CREATE_TABLE_EXE = "CREATE TABLE "+
            TABLE_NAME + " ("+ COL_ID +" TEXT, "+ COL_NAME+ " TEXT, " + COL_DESCRIPTION + " TEXT, " + COL_PRICE + " TEXT, "+ COL_TYPE+ " TEXT)";

    private static GrocerySQLHelper myInstance;

    public static GrocerySQLHelper getInstance(Context context){
        if (myInstance == null){
            myInstance = new GrocerySQLHelper(context.getApplicationContext());
        }
        return myInstance;
    }

    private GrocerySQLHelper(Context context){
        super(context, DATABASE_NAME, null,7);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { sqLiteDatabase.execSQL(CREATE_TABLE_EXE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if EXISTS "+ TABLE_NAME);
        this.onCreate(sqLiteDatabase);

    }

    public List<GroceryItem> getItemsAsList(){
        ArrayList<GroceryItem> groceryItems = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        if(c.moveToFirst()){
            while(!c.isAfterLast()){
                groceryItems.add(
                        new GroceryItem(
                                c.getString(c.getColumnIndex(COL_NAME)),
                                c.getString(c.getColumnIndex(COL_DESCRIPTION)),
                                c.getString(c.getColumnIndex(COL_TYPE)),
                                c.getString(c.getColumnIndex(COL_PRICE)),
                                c.getString(c.getColumnIndex(COL_ID))));

                c.moveToNext();
            }

        }
        c.close();
        return groceryItems;
    }

    public List<GroceryItem> searchByContainsInName(String query){
        List<GroceryItem> queriedList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                null,
                COL_NAME + " LIKE " + "'%"+query+"%'",
                null,
                null,
                null,
                COL_NAME);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                queriedList.add(new GroceryItem
                        (cursor.getString(cursor.getColumnIndex(COL_NAME)),
                                cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION)),
                                cursor.getString(cursor.getColumnIndex(COL_PRICE)),
                                cursor.getString(cursor.getColumnIndex(COL_TYPE)),
                                cursor.getString(cursor.getColumnIndex(COL_ID))));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return queriedList;
    }
}
