package com.example.root.filemanager;

import android.content.Intent;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //int[] image = {R.drawable.file};
    String[] folderName = {"Bluetooth", "Songs", "Downloads", "Pictures", "DCIM", "Doc"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent(view.getContext(), FileActivity2.class);
                    //intent.putExtra("Bluetooth",folderName[0]);
                    startActivityForResult(intent, 0);
                }
                else if(i==1){
                    Intent intent = new Intent(view.getContext(), FileActivity3.class);
                    //intent.putExtra("Songs",folderName[1]);
                    startActivityForResult(intent, 1);
                }
                else if(i==2){
                    Intent intent = new Intent(view.getContext(), FileActivity4.class);
                    //intent.putExtra("Downloads",folderName[2]);
                    startActivityForResult(intent, 2);
                }
                else if(i==3){
                    Intent intent = new Intent(view.getContext(), FIleActivity5.class);
                    //intent.putExtra("Pictures",folderName[3]);
                    startActivityForResult(intent, 3);
                }
                else if(i==4){
                    Intent intent = new Intent(view.getContext(), FileActivity3.class);
                    //intent.putExtra("DCIM",folderName[4]);
                    startActivityForResult(intent, 4);
                }
                else if(i==5){
                    Intent intent = new Intent(view.getContext(), FileActivity3.class);
                    //intent.putExtra("Doc",folderName[5]);
                    startActivityForResult(intent, 5);
                }
            }
        });
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return folderName.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_layout,null);

            ImageView imageView = (ImageView)view.findViewById(R.id.iView);
            TextView tView = (TextView)view.findViewById(R.id.tView);

            imageView.setImageResource(R.drawable.file);
            tView.setText(folderName[i]);

            return view;
        }
    }
}
