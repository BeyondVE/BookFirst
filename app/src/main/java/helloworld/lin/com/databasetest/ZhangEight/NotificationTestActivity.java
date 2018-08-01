package helloworld.lin.com.databasetest.ZhangEight;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import helloworld.lin.com.databasetest.R;

public class NotificationTestActivity extends AppCompatActivity {
    private Button mBtnSendNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);
        mBtnSendNotice = (Button) findViewById(R.id.button_send_notice);
        mBtnSendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                String CHANNEL_ID ="my_channel_01";
                Notification notification = new NotificationCompat.Builder(NotificationTestActivity.this)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setChannel(CHANNEL_ID)
                        .build();
                manager.notify(1,notification);
            }
        });
    }
}
