package helloworld.lin.com.databasetest.ZhangSix;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import helloworld.lin.com.databasetest.R;

/**
 * Created by W50V on 2018/7/29.
 */

public class BestPractice extends AppCompatActivity{
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText accountEdit,passwordEdit;
    private Button login;
    private CheckBox rememberPass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_practice);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText) findViewById(R.id.editText_account);
        passwordEdit = (EditText) findViewById(R.id.editText_password);
        rememberPass = (CheckBox) findViewById(R.id.checkbox_remember_pass);
        login = (Button) findViewById(R.id.button_login);
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(account.equals("admin") && password.equals("123456")){
                    editor = pref.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else{editor.clear();}
                    editor.apply();
                    Toast.makeText(BestPractice.this,"登录成功",Toast.LENGTH_SHORT).show();
                }else {Toast.makeText(BestPractice.this,"账号或密码错误",Toast.LENGTH_SHORT).show();}

            }
        });

    }
}
