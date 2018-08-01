package helloworld.lin.com.databasetest.ZhangThree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import helloworld.lin.com.databasetest.R;

public class ListViewActivity extends AppCompatActivity {
    //private String[] data = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initFruits();
//        ArrayAdapter<Fruit> adapter = new ArrayAdapter<String>(ListViewActivity.this,
//                android.R.layout.simple_list_item_1,data);
        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit grape1 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape1);
            Fruit grape2 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape2);
            Fruit grape3 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape3);
            Fruit grape4 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape4);
            Fruit grape5 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape5);
            Fruit grape6 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape6);
            Fruit grape7 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape7);
            Fruit grape8 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape8);
            Fruit grape9 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape9);
            Fruit grape10 = new Fruit("example",R.mipmap.grape);
            fruitList.add(grape10);
        }
    }
}
