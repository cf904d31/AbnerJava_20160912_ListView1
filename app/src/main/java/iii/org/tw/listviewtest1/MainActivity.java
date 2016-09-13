package iii.org.tw.listviewtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ListView showList;
    private EditText inputEdit;
    private LinkedList<HashMap<String,Object>> linkedList = new LinkedList<>();
    private String []from = {"title","content","img"};
    private int []to = {R.id.item_title,R.id.item_content,R.id.showImg};
    private SimpleAdapter adapter;
    private int[] img = {R.drawable.fruit1,R.drawable.fruit2,R.drawable.fruit3,R.drawable.fruit4,R.drawable.fruit5,R.drawable.fruit6,R.drawable.fruit7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showList = (ListView) findViewById(R.id.showList);
        inputEdit = (EditText) findViewById(R.id.inputEdit);

        intitListView();
    }

    private void intitListView() {

        linkedList = new LinkedList<>();
        /*
        HashMap<String,String> data0 = new HashMap<>();
        data0.put("title","Abner");
        data0.put("content","good~~~~~~~~");
        linkedList.add(data0);

        HashMap<String,String> data1 = new HashMap<>();
        data1.put("title","Adele");
        data1.put("content","good~~~~~~~~");
        linkedList.add(data1);

        HashMap<String,String> data2 = new HashMap<>();
        data2.put("title","One Direction");
        data2.put("content","good~~~~~~~~");
        linkedList.add(data2);

        HashMap<String,String> data3 = new HashMap<>();
        data3.put("title","Link Park");
        data3.put("content","good~~~~~~~~");
        linkedList.add(data3);
        */


        adapter = new SimpleAdapter(this ,linkedList ,R.layout.layout_item ,from ,to);
        showList.setAdapter(adapter);

//        showList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("Abner","OnClick");
//            }
//        });

        showList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Abner","i = " + position);
                Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"title=",Toast.LENGTH_SHORT).show();
            }
        });

        showList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Abner","i = " + position + "->Long");
                Toast.makeText(MainActivity.this,"Long OK",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    public void insert(View v) {
        //String input = inputEdit.getText().toString();
        HashMap<String,Object> data = new HashMap<>();
        data.put(from[0],inputEdit.getText().toString());
        data.put(from[1],"Good~~~~~~1!!");
        data.put(from[2],img[(int)(Math.random()*7)]);
        linkedList.add(data);
        adapter.notifyDataSetChanged();
    }
}
