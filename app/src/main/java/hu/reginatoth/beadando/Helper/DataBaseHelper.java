package hu.reginatoth.beadando.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import hu.reginatoth.beadando.Model.todoModel;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "todo.db";

    private static final String TODO_TABLE = "ToDoItems";

    private static final String PK_ID = "id";
    private static final String TODO_NAME ="title";
    private static final String TODO_DESC ="description";
    private static final String TODO_DUETO ="dueto";

    public static String CREATE_TABLE_TODO =
            "CREATE TABLE "+TODO_TABLE +
                    "(" +PK_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + TODO_NAME+" TEXT NOT NULL,"
                    + TODO_DESC+" TEXT NOT NULL,"
                    + TODO_DUETO+" TEXT NOT NULL" +")";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TODO_TABLE);
        onCreate(db);
    }

    public boolean addTodoItem(todoModel todo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TODO_NAME,  todo.getTitle());
        contentValues.put(TODO_DESC, todo.getDesc());
        contentValues.put(TODO_DUETO, todo.getDueto());


        long insert = db.insert(TODO_TABLE, null, contentValues);
        db.close();

        if (insert==-1) return false;
        else return true;
    }

    public List<todoModel> getAllitem(){
        List<todoModel> returnList = new ArrayList<>();
        String SELECT_ALL_ITEM = "SELECT * FROM "+TODO_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL_ITEM, null);

        if (cursor.moveToFirst()){
            do{
                int todoId = cursor.getInt(0);
                String todoTitle = cursor.getString(1);
                String todoDesc = cursor.getString(2);
                String todoDueto = cursor.getString(3);


                todoModel newtodoitem = new todoModel(todoId,todoTitle,todoDesc,todoDueto);
                returnList.add(newtodoitem);
            }while (cursor.moveToNext());
        }else

            cursor.close();
        db.close();

        return returnList;
    }
    public todoModel getTodoItem(todoModel todo) {
        SQLiteDatabase db = this.getReadableDatabase();
        String SELECT_ONE_ITEM="SELECT * FROM "+TODO_TABLE+" WHERE "+PK_ID+" = "+todo.getId();

        Cursor cursor = db.rawQuery(SELECT_ONE_ITEM, null);

        if (cursor!=null) cursor.moveToFirst();

        todoModel todoitem = new todoModel(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3)
                );

        db.close();
        return todoitem;
    }
    public boolean deleteTodoItem(todoModel todo){
        SQLiteDatabase db =this.getWritableDatabase();
        String DELETE_ONE_ITEM = "DELETE FROM "+TODO_TABLE +" WHERE "+PK_ID+" = "+ todo.getId();
        Cursor cursor = db.rawQuery(DELETE_ONE_ITEM, null);

        if (cursor.moveToFirst()) return true;
        else return false;

    }
    public boolean updateTodoItem(todoModel todo){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PK_ID, todo.getId());
        contentValues.put(TODO_NAME,  todo.getTitle());
        contentValues.put(TODO_DESC, todo.getDesc());
        contentValues.put(TODO_DUETO, todo.getDueto());


        String whereClause = " = ?";
        String[] whereArgs = new String[]{String.valueOf(todo.getId())};

        db.update(TODO_TABLE,contentValues,PK_ID+whereClause,whereArgs);

        db.close();
        return true;
    }
}
