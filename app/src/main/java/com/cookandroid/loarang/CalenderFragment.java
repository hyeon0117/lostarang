package com.cookandroid.loarang;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CalenderFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    ArrayList actors;
    ListView customListView;
    private static CustomAdapter customAdapter;

    public CalenderFragment() {
        // Required empty public constructor
    }

    public static CalenderFragment newInstance(String param1, String param2) {
        CalenderFragment fragment = new CalenderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calender,container,false);

        actors = new ArrayList<>();
        actors.add(new Actor("카오스게이트","https://loawa.com/assets/images/island/chaos_01.png","매 시간 정각"));
        actors.add(new Actor("필드 보스","https://loawa.com/assets/images/island/boss_13.png","매 시간 정각"));
        actors.add(new Actor("모험 섬","https://cdn-lostark.game.onstove.com/uploadfiles/banner/ef5b1d5004ad4094893234a752ac9e70.jpg","매 시간 정각"));
        actors.add(new Actor("점령전","https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/information/contents/tower/5.jpg?ca30c98e745f4558d976","매 시간 정각"));
        customListView = (ListView) rootView.findViewById(R.id.listView_custom);
        customAdapter = new CustomAdapter(getContext(),actors);
        customListView.setAdapter(customAdapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = (String) view.findViewById(R.id.textView_name).getTag().toString();

            }
        });
        //return inflater.inflate(R.layout.fragment_calender, container, false);
        return rootView;
    }
}
class Actor{
    private String name;
    private String summary;
    private String thumb_url;

    public Actor(String name,String thumb_url,String summary){
        this.name = name;
        this.summary = summary;
        this.thumb_url = thumb_url;
    }
    public String getName(){
        return name;
    }
    public String getSummary(){
        return summary;
    }
    public String getThumb_url(){
        return thumb_url;
    }
}