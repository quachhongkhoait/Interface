package com.example.bt3_app.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.bt3_app.R;
import com.example.bt3_app.adapter.GroupAdapter;
import com.example.bt3_app.adapter.InfoAdapter;
import com.example.bt3_app.adapter.OnItemClick;
import com.example.bt3_app.model.Group;
import com.example.bt3_app.model.Info;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    RecyclerView mRecyclerViewInfo, mRecyclerViewGroup;
    private List<Info> mListInfo = new ArrayList<>();
    private List<Group> mListGroup = new ArrayList<>();
    private InfoAdapter infoAdapter;
    private GroupAdapter groupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        mListInfo.add(new Info("Khoa", "Bình định", "111"));
        mListInfo.add(new Info("Anh", "Quảng Nam", "111"));
        mListInfo.add(new Info("Sang", "Quảng Nam", "111"));
        mListInfo.add(new Info("Thầy", "Quảng Nam", "111"));
        mListInfo.add(new Info("Nguyễn", "Quảng Nam", "111"));
        mRecyclerViewInfo = findViewById(R.id.rCyclvInfo);
        mRecyclerViewGroup = findViewById(R.id.rCyclvGroup);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewInfo.setLayoutManager(layoutManager);
        infoAdapter = new InfoAdapter(mListInfo);
        infoAdapter.setOnClickRouteListner(this);
        mRecyclerViewInfo.setAdapter(infoAdapter);
        //

        RecyclerView.LayoutManager layoutManagerGroup = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewGroup.setLayoutManager(layoutManagerGroup);
        groupAdapter = new GroupAdapter(mListGroup);
        mRecyclerViewGroup.setAdapter(groupAdapter);
    }

    @Override
    public void onCheck(int posCheck, boolean b) {
        if (b) {
            mListGroup.add(new Group(posCheck, mListInfo.get(posCheck).getName()));
        } else {
            for (int i = 0; i < mListGroup.size(); i++) {
                if (mListGroup.get(i).getIdgroup() == posCheck) {
                    mListGroup.remove(i);
                }
            }
        }
        groupAdapter.notifyDataSetChanged();
    }

    @Override
    public void onView(int posView) {
        Toast.makeText(this, mListInfo.get(posView).getName() + " - " + mListInfo.get(posView).getAddress(), Toast.LENGTH_SHORT).show();
    }
}