package com.by5388.groupdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.by5388.groupdemo.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {
    public String[] groupStrings = {"西游记", "水浒传", "三国演义", "红楼梦"};
    public String[][] childStrings = {
            {"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
            {"宋江", "林冲", "李逵", "鲁智深"},
            {"曹操", "刘备", "孙权", "诸葛亮", "周瑜"},
            {"贾宝玉", "林黛玉", "薛宝钗", "王熙凤"}
    };

    private ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapter();
        initListener();

    }

    private void initView() {
        expandableListView = findViewById(R.id.record_expand_list);
    }

    private void initAdapter() {
        MyAdapter adapter = new MyAdapter(this,groupStrings,childStrings);
        expandableListView.setAdapter(adapter);
        for (int i = 0; i < groupStrings.length; i++) {
            expandableListView.expandGroup(i);
        }
        expandableListView.setGroupIndicator(null);
    }

    private void initListener() {
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });
    }
}
