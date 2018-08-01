package helloworld.lin.com.databasetest.ZhangSix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

import helloworld.lin.com.databasetest.R;

public class Main2Activity extends AppCompatActivity {
    private Button mButtonLitepalCreate,mButtonLitepalAdd,
            mButtonLitepalUpdate,mButtonLitepalDelete,
            mButtonLitepalUppalQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mButtonLitepalCreate = (Button) findViewById(R.id.button_litepal_create);
        mButtonLitepalAdd = (Button) findViewById(R.id.button_litepal_add);
        mButtonLitepalUpdate = (Button) findViewById(R.id.button_litepal_update);
        mButtonLitepalDelete = (Button) findViewById(R.id.button_litepal_delete);
        mButtonLitepalUppalQuery = (Button) findViewById(R.id.button_litepal_query);
        mButtonLitepalCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });
        mButtonLitepalAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da Vinci Coda");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();


            }
        });
        mButtonLitepalUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
//                book.setName("The Lost Symbol");
//                book.setAuthor("Dan Brown");
//                book.setPages(510);
//                book.setPrice(19.95);
//                book.setPress("Unknow");
//                book.save();
//                book.setPrice(10.99);
//                book.save();
                //第二种更新方法
//                book.setPrice(14.95);
//                book.setPress("Anchor");
//                book.updateAll("name = ? and author = ? ","The Lost Symbol","Dan Brown");
                //更新为默认值
                book.setToDefault("pages");
                book.updateAll();
                Toast.makeText(Main2Activity.this,"更新成功",Toast.LENGTH_SHORT).show();

            }
        });
        mButtonLitepalDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class,"price < ?","15");
                Toast.makeText(Main2Activity.this,"删除成功",Toast.LENGTH_SHORT).show();
            }
        });
        mButtonLitepalUppalQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book:books) {
                    Log.d("Main2Activity", "book name is " + book.getName());
                    Log.d("Main2Activity", "book author is " + book.getAuthor());
                    Log.d("Main2Activity", "book pages is " + book.getPages());
                    Log.d("Main2Activity", "book price is " + book.getPrice());
                    Log.d("Main2Activity", "book press is " + book.getPress());
                }
            }
        });
    }
}
