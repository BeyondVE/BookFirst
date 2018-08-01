package helloworld.lin.com.databasetest.ZhangSix;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import helloworld.lin.com.databasetest.R;

public class MainActivity extends AppCompatActivity {
    Button mButtonCreate,mButtonInsert,mButtonUpdata,mButtonDelete;
    private MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        mButtonCreate = (Button) findViewById(R.id.button_create);
        mButtonInsert = (Button) findViewById(R.id.button_insert);
        mButtonUpdata = (Button) findViewById(R.id.button_update);
        mButtonDelete = (Button) findViewById(R.id.button_delete);
        mButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper.getWritableDatabase();

            }
        });
        mButtonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name","The Da Vinci Code");
                contentValues.put("author","Dan Browm");
                contentValues.put("pages",454);
                contentValues.put("price",16.96);
                db.insert("Book",null,contentValues);
                contentValues.clear();
                contentValues.put("name","The Lost Symbol");
                contentValues.put("author","Dan Browm");
                contentValues.put("pages",510);
                contentValues.put("price",19.95);
                db.insert("Book",null,contentValues);
                contentValues.clear();
            }
        });
        mButtonUpdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("price",10.99);
                db.update("Book",contentValues,"name = ?",new String[]{"The Da Vinci Code"});
            }
        });
        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                db.delete("Book","pages > ?",new String[]{"500"});
            }
        });
    }
}
