package chen.example.com.answer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/23.
 */
public class DBService {
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    public DBService(Context mContext){
        dbHelper=new MyDatabaseHelper(mContext,"question.db",null,1);
        db=dbHelper.getWritableDatabase();
        db.execSQL("insert into question(question,answerA,answerB,answerC,answerD,answer,explaination)" +
                "values(?,?,?,?,?,?,?)",new String[]{"狗有几条尾巴","1条","2条","3条","4条","0"
                  ,"笨蛋"});
    }
    public List<Question> getQuestions(){
        List<Question> list=new ArrayList<Question>();
        Cursor cursor=db.rawQuery("select * from question",null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            int count=cursor.getCount();
            for (int i=0;i<count;i++) {
                cursor.moveToPosition(i);
                Question question = new Question();
                question.question = cursor.getString(cursor.getColumnIndex("question"));
                question.answerA=cursor.getString(cursor.getColumnIndex("answerA"));
                question.answerB=cursor.getString(cursor.getColumnIndex("answerB"));
                question.answerC=cursor.getString(cursor.getColumnIndex("answerC"));
                question.answerD=cursor.getString(cursor.getColumnIndex("answerD"));
                question.answer=cursor.getInt(cursor.getColumnIndex("answer"));
                question.ID=cursor.getInt(cursor.getColumnIndex("ID"));
                question.explaination=cursor.getString(cursor.getColumnIndex("explaination"));
                question.selectedAnswer=-1;
                list.add(question);
            }
        }
        return list;
    }
}
