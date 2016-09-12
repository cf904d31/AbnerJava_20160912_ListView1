package iii.org.tw.listviewtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView showList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showList = (ListView) findViewById(R.id.showList);
        intitListView();
    }

    private void intitListView() {
        LinkedList<HashMap<String,String>> linkedList = new LinkedList<>();

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

        String []from = {"title","content"};
        int []to = {R.id.item_title,R.id.item_content};
        SimpleAdapter adapter = new SimpleAdapter(this ,linkedList ,R.layout.layout_item ,from ,to);
        showList.setAdapter(adapter);
    }
}
