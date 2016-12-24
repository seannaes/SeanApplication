package igs.android.sean.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import igs.android.sean.R;

public class MenuAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuappcompat);

        //必须设置Activity的样式的windowActionBar为false，下面自定义Toolbar才起作用。
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // TODO: 2016-12-23 下面2个方法都可以设置title，效果一样
//        this.setTitle("ddddd");
////        toolbar.setTitle("dddddddddddd");
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back);//设置返回按钮图片及事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setLogo(R.drawable.back_on);//设置Logo图片
        toolbar.setSubtitle("tttt");//设置副标题
        toolbar.setOnCreateContextMenuListener(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own actionReplace with your own actionReplace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Acti2onActi2onActi2onActi2onActi2onActi2onActi2onActi2onActi2onActi2onActi2onActi2on", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Toast.makeText(MenuAppCompatActivity.this,"点击"+view,Toast.LENGTH_SHORT).show();
//                            }
//                        }).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_appcompat, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
