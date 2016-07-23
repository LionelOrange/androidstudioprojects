package chen.example.com.answer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn;
//    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.button);
//        dbHelper=new MyDatabaseHelper(this,"question.db",null,1);
//        SQLiteDatabase db=dbHelper.getWritableDatabase();
//        db.execSQL("insert into question(question,answerA,answerB,answerC,answerD,answer,explaination)" +
//                "values(?,?,?,?,?,?,?)",new String[]{"狗有几条尾巴","1条","2条","3条","4条","0"
//                ,"笨蛋"});
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ExamActivity.class);
                startActivity(intent);
            }
        });
    }
}
