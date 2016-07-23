package chen.example.com.answer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/7/23.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table question(ID integer primary key autoincrement" +
               ",answerA text,answerB text,answerC text,answerD text" +
                ",answer integer,explaination text,selectedAnswer integer" +
                ",question text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
