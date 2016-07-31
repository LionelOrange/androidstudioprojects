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
                "values(?,?,?,?,?,?,?)",new String[]{"下面关于java.lang.Exception类的说法正确的是（）","继承自Throwable"
                ,"Serialable ","不记得","反正不正确","0"
                  ,"Java异常的基类为java.lang.Throwable，java.lang.Error和java.lang.Exception继承 Throwable，RuntimeException和" +
                "其它的Exception等继承Exception，具体的RuntimeException继承RuntimeException。"});
        db.execSQL("insert into question(question,answerA,answerB,answerC,answerD,answer,explaination)" +
                "values(?,?,?,?,?,?,?)",new String[]{"下列说法正确的有（）","class中的constructor不可省略","constructor必须与class同名，但方法不能与class同名","constructor在一个对象被new时执行"
                ,"一个class只能定义一个constructor","2","这里可能会有误区，其实普通的类方法是可以和类名同名的，和构造方法唯一的区分就是，构造方法没有返回值。"});
        db.execSQL("insert into question(question,answerA,answerB,answerC,answerD,answer,explaination)" +
                "values(?,?,?,?,?,?,?)",new String[]{"下列属于关系型数据库的是（）"," Oracle"," MySql","IMS","MongoDB"
                ,"0","非关系型数据库有MongoDB、memcachedb、Redis等"});
        db.execSQL("insert into question(question,answerA,answerB,answerC,answerD,answer,explaination)" +
                "values(?,?,?,?,?,?,?)",new String[]{"下列说法正确的是（）","LinkedList继承自List","AbstractSet继承自Set","HashSet继承自AbstractSet","WeakMap继承自HashMap"
                ,"0","HashSet继承自AbstractSet,也是"});
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
