package helloworld.lin.com.databasetest.ZhangThree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import helloworld.lin.com.databasetest.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewFruitAdapter adapter = new RecyclerViewFruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
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
