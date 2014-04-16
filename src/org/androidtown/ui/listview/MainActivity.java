package org.androidtown.ui.listview;

import android.app.Activity;
import android.content.res.Resources;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * ����Ʈ�並 ����ϴ� ����� ���� �� �� �ֽ��ϴ�.
 * 
 * @author Mike
 *
 */
public class MainActivity extends Activity{

	// ����Ʈ�� ��ü
	ListView list;
	
	// ����� ��ü
	IconTextListAdapter adapter;
	DialogActivity dActivity;
	Button getMemoBtn;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list = (ListView)findViewById(R.id.todoList);
        getMemoBtn = (Button) findViewById(R.id.getMemo);
		dActivity = new DialogActivity(MainActivity.this);
		dActivity.setTitle("�� �޸� �ۼ�"); // ���̾�α� Ÿ��Ʋ ����

        // ����� ��ü ����
        adapter = new IconTextListAdapter(this);

		// ������ ������ �����
        // �����(string) / �ð�(int) / ���(string)
		Resources res = getResources();
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "SE", "21:00", "���� ����"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�߾��� ��Ʈ����", "14:20", "900 ��"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "���� - ��ȣ�� ����", "14:20", "1500 ��"));
		
		// ����Ʈ�信 ����� ����
		list.setAdapter(adapter);

		// ���� ������ �����ʷ� ��ü�� ����� ����
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				IconTextItem curItem = (IconTextItem) adapter.getItem(position);
				String[] curData = curItem.getData();

				Toast.makeText(getApplicationContext(), "Selected : " + curData[0], 1000).show();
			}
		});
		
		// ���̾�α׸� ���� ��ư
		getMemoBtn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dActivity.show();
			}
		});

		// Ŀ���� ���̾�α� ��ü�� Dismiss ������ ����
		// Ŀ���� ���̾�αװ� ������� �� ���� �ൿ��
		dActivity.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss(DialogInterface arg0) {
				Toast.makeText(getApplicationContext(), dActivity.getMemoSubject(), 1000).show();
			}
		});

		// Ŀ���� ���̾�α� ��ü�� Cancel ������ ����
		// Ŀ���� ���̾�α��� ��� ��ư�� ��ġ���� �� ���� �ൿ��
		dActivity.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface arg0) {
				Toast.makeText(getApplicationContext(), "�޸� �߰����� �ʾҽ��ϴ�.",1000).show();
			}
		});
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
