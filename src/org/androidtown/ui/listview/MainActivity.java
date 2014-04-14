package org.androidtown.ui.listview;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

/**
 * ����Ʈ�並 ����ϴ� ����� ���� �� �� �ֽ��ϴ�.
 * 
 * @author Mike
 *
 */
public class MainActivity extends Activity {

	/**
	 * ����Ʈ�� ��ü
	 */
	//DataListView list;
	ListView list;
	
	/**
	 * ����� ��ü
	 */
	IconTextListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        // Ÿ��Ʋ ���ֱ�
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        // ����Ʈ�� ��ü ����
        //ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        //list = new DataListView(this);

        list = (ListView)findViewById(R.id.todoList);
        // ����� ��ü ����
        adapter = new IconTextListAdapter(this);

		// ������ ������ �����
        // �����(string) / �ð�(int) / ���(string)
		Resources res = getResources();
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "SE", "21:00", "���� ����"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�߾��� ��Ʈ����", "14:20", "900 ��"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "���� - ��ȣ�� ����", "14:20", "1500 ��"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "ģ��ã�� (Friends Seeker)", "14:20", "900 ��"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "���� �˻�", "14:20", "900 ��"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����ö �뼱�� - ����", "14:40", "1500 ��"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "����ö �뼱�� - ����", "11:20", "1500 ��"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����ö �뼱�� - LA", "16:20", "1500 ��"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "����ö �뼱�� - ������", "14:00", "1500 ��"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����ö �뼱�� - �ĸ�", "4:20", "1500 ��"));
		
		// ����Ʈ�信 ����� ����
		list.setAdapter(adapter);

		// ���� ������ �����ʷ� ��ü�� ����� ����
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				IconTextItem curItem = (IconTextItem) adapter.getItem(position);
				String[] curData = curItem.getData();

				Toast.makeText(getApplicationContext(), "Selected : " + curData[0], 1000).show();
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
