package com.example.app_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Dell on 2019/10/24.
 */

public class MenuFragment extends Fragment {

    private View view;
    private int[] settingicon;
    private String[] foodNames;
    private String[] settingText;
    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_menu,container,false);

        MainActivity activity = (MainActivity) getActivity();
        settingicon = activity.getSettingicons();
        foodNames = activity.getFoodNames();
        settingText = activity.getSettingText();

        if (view != null){
            initView();
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContentFargment listFargment = (ContentFargment) ((MainActivity)getActivity()).getFragmentManager().findFragmentById(R.id.foodcontent);
                listFargment.setText(settingText[position]);
            }
        });

        return view;
    }

    private void initView(){
        mListView = view.findViewById(R.id.menulist);
        if (settingicon != null){
            mListView.setAdapter(new MyAdapter());
        }
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return settingicon.length;
        }

        @Override
        public Object getItem(int position) {
            return settingicon[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(getActivity(),R.layout.item_list,null);
            ImageView mNameTV = convertView.findViewById(R.id.food_icon);
            mNameTV.setBackgroundResource(settingicon[position]);
            TextView mFoodName = convertView.findViewById(R.id.food_name);
            mFoodName.setText(foodNames[position]);

            return convertView;
        }
    }
}
