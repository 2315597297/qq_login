package com.example.administrator.qq_login;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {
    private SimpleDraweeView dvWelcome;
    private LinearLayout text_layout;
    private LinearLayout button_layout;
    private LinearLayout login_layout;
    private Button show_login;
    private ImageView logo;
    private Button login;
    private EditText user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        WindowManager wm = this.getWindowManager();
        final int width = wm.getDefaultDisplay().getWidth();
        final int height = wm.getDefaultDisplay().getHeight();
        dvWelcome= (SimpleDraweeView) findViewById(R.id.dv_welcome);
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)//自动播放动画
                .setUri(Uri.parse("asset://com.example.administrator.qq_login/timg.gif"))//路径
                .build();
        dvWelcome.setController(draweeController);
        text_layout = findViewById(R.id.main_text_layout);
        button_layout = findViewById(R.id.main_button_layout);
        login_layout = findViewById(R.id.main_login_layout);
        logo = findViewById(R.id.main_logo);
        show_login = findViewById(R.id.main_show_login);
        login = findViewById(R.id.main_login);
        user = findViewById(R.id.main_user);

        show_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login_layout.animate().translationY(-340).setDuration(300);
                logo.animate().translationX(-(width/2-50)).scaleY(0.7f).scaleX(0.7f).translationY(20);
                text_layout.setVisibility(View.GONE);
                button_layout.setVisibility(View.GONE);
                login_layout.setVisibility(View.VISIBLE);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.doudong);//加载动画资源文件
                user.startAnimation(shake);
            }
        });
    }
}
