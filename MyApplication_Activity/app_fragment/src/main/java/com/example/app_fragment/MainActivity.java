package com.example.app_fragment;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction beginTransaction;
    private String[] settingText = {
            "1.将鸡蛋清和淀粉调料调匀成糊，涂在肉片上。\n" +
            "2.将花椒、干辣椒慢火炸，带辣椒成金黄色捞出切成细末。\n" +
            "3.用锅中油爆炒豆瓣辣酱，然后将白菜叶，调料放入。\n" +
            "4.随即放入 肉片，再炖几分钟，肉片熟后，将肉片盛起，将辣椒、花椒末撒上。\n" +
            "5.用植物油烧开，淋在肉片上，即可使麻、辣、浓香四溢。"
            ,
            "1.豆腐切丁，香葱、生姜、大蒜、干辣椒切细备用。\n" +
            "2.锅内放入油烧热，先爆香葱末、生姜末、大蒜末、干辣椒末和豆瓣酱，再放入猪肉馅炒熟。\n" +
            "3.加入适量水，煮开后加入豆腐丁，酱油、白糖煮3分钟。\n" +
            "4.再用水淀粉勾芡后盛入盘中。\n" +
            "5.烧热香油，爆香花椒，将花椒油淋在豆腐上即可。"
    };
    private int[] settingicons={R.drawable.boiledmeat,R.drawable.mapoytofo};
    private String[] foodNames = {"水煮肉片","麻婆豆腐"};

    public String[] getSettingText() {
        return settingText;
    }

    public int[] getSettingicons() {
        return settingicons;
    }

    public String[] getFoodNames() {
        return foodNames;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentFargment contentFargment = new ContentFargment();
        MenuFragment menuFragment = new MenuFragment();
        beginTransaction = getFragmentManager().beginTransaction();

        beginTransaction.replace(R.id.foodcontent,contentFargment);
        beginTransaction.replace(R.id.menu,menuFragment);
        beginTransaction.commit();
    }
}
