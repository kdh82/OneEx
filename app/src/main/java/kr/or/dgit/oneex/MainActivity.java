package kr.or.dgit.oneex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] listCls;
    private ArrayAdapter<CharSequence> mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCls = getResources().getStringArray(R.array.list_cls); //실행할 액티비티명들

        //어뎁터생성
        mAdapter = ArrayAdapter.createFromResource(this,R.array.list_title,
                android.R.layout.simple_list_item_1);
        //리스트뷰 참조
        mListView = (ListView) findViewById(R.id.listview);

        //어뎁터와 리스트뷰 연결
        mListView.setAdapter(mAdapter);

        //리스너 연결 눌리면 액티비티 실행 되도록
        mListView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), getPackageName()+"."+listCls[position]);
        intent.putExtra("title", mAdapter.getItem(position));
        startActivity(intent);
    }
}
