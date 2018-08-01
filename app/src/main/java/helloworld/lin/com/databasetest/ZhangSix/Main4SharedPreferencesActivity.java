package helloworld.lin.com.databasetest.ZhangSix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import helloworld.lin.com.databasetest.R;

public class Main4SharedPreferencesActivity extends AppCompatActivity {
    private Button mButtonSavaData,mButtonRestoreData,mButtonPractice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_shared_preferences);
        mButtonSavaData = (Button) findViewById(R.id.button_save_data);
        mButtonRestoreData = (Button) findViewById(R.id.button_restore_data);
        mButtonPractice = (Button) findViewById(R.id.button_best_practice);
        mButtonSavaData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                editor.apply();
            }
        });
        mButtonRestoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name","");
                int age = pref.getInt("age",0);
                boolean married = pref.getBoolean("married",false);
                Log.d("Main4Activity", "name is" + name);
                Log.d("Main4Activity", "age is" + age);
                Log.d("Main4Activity", "married is" + married);


            }
        });
        mButtonPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4SharedPreferencesActivity.this,BestPractice.class);
                startActivity(intent);
            }
        });
    }
}
