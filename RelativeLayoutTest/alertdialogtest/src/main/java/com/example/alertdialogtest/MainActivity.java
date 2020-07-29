package com.example.alertdialogtest;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView tv_ordtext;
    private TextView tv_text;
    private TextView tv_like;
    private Button btn_ord;
    private Button btn_tsize;
    private Button btn_like;
    private Context myContext;
    private int textSize = 1;
    private int[] textSizeArr = {10, 20, 25, 30, 40};

    private String hobbys = "您的兴趣爱好：";
    private CharSequence[] items = new CharSequence[]{"旅游", "美食", "看电影", "运动"};
    private boolean[] checkedItems = new boolean[]{false, true, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContext = this;
        findView();
        setListener();
    }

    private void setListener() {

        btn_ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(myContext)
                        .setTitle("普通对话框")
                        .setMessage("这是一个普通对话框，看完之后请点击确定！")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btn_tsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(myContext)
                        .setTitle("设置字体大小")
                        .setIcon(R.mipmap.ic_launcher)
                        .setSingleChoiceItems(new String[]{"小号", "默认", "中号", "大号", "超大"}, textSize, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                textSize = which;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tv_text.setTextSize(textSizeArr[textSize]);
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(myContext)
                        .setTitle("请添加兴趣爱好")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkedItems[which] = isChecked;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuffer stringBuffer = new StringBuffer();
                                for (int i = 0; i <= checkedItems.length - 1; i++) {
                                    if (checkedItems[i]) {
                                        stringBuffer.append(items[i]).append(" ");
                                    }
                                }
                                if (stringBuffer != null) {
                                    tv_like.setText(hobbys + stringBuffer + " ");
                                    Toast.makeText(MainActivity.this, "" + stringBuffer, Toast.LENGTH_LONG).show();
                                }
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    private void findView() {
        tv_ordtext = findViewById(R.id.tv_ordtext);
        tv_text = findViewById(R.id.tv_text);
        tv_like = findViewById(R.id.tv_like);
        btn_ord = findViewById(R.id.btn_ord);
        btn_tsize = findViewById(R.id.btn_tsize);
        btn_like = findViewById(R.id.btn_like);
    }
}
