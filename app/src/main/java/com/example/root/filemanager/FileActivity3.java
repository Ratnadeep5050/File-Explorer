package com.example.root.filemanager;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class FileActivity3 extends ListActivity {
    String str;
    ArrayList<String> al;
    ArrayAdapter<String> adapter;
    ListView lv;

    @SuppressLint("SdCardPath")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file2);
        Intent int1 = getIntent();
        ArrayList<String> arr1 = GetFiles(Environment.getExternalStorageDirectory().getPath());
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, arr1);
        lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(adapter);
    }

    private ArrayList<String> GetFiles(String path) {
        String pathdir = "";
        pathdir = path + "/Songs/";
        ArrayList<String> arr2 = new ArrayList<String>();
        File file = new File(pathdir);
        File[] allfiles = file.listFiles();
        if (allfiles.length == 0) {
            return null;
        } else {
            for (int i = 0; i < allfiles.length; i++) {
                arr2.add(allfiles[i].getName());
            }
        }
        return arr2;
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
    }

}