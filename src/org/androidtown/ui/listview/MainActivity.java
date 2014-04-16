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
 * 리스트뷰를 사용하는 방법에 대해 알 수 있습니다.
 * 
 * @author Mike
 *
 */
public class MainActivity extends Activity{

	// 리스트뷰 객체
	ListView list;
	
	// 어댑터 객체
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
		dActivity.setTitle("새 메모 작성"); // 다이얼로그 타이틀 설정

        // 어댑터 객체 생성
        adapter = new IconTextListAdapter(this);

		// 아이템 데이터 만들기
        // 과목명(string) / 시간(int) / 비고(string)
		Resources res = getResources();
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "SE", "21:00", "퀴즈 제출"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "추억의 테트리스", "14:20", "900 원"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "고스톱 - 강호동 버전", "14:20", "1500 원"));
		
		// 리스트뷰에 어댑터 설정
		list.setAdapter(adapter);

		// 새로 정의한 리스너로 객체를 만들어 설정
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				IconTextItem curItem = (IconTextItem) adapter.getItem(position);
				String[] curData = curItem.getData();

				Toast.makeText(getApplicationContext(), "Selected : " + curData[0], 1000).show();
			}
		});
		
		// 다이얼로그를 띄우는 버튼
		getMemoBtn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dActivity.show();
			}
		});

		// 커스텀 다이얼로그 객체에 Dismiss 리스너 설정
		// 커스텀 다이얼로그가 사라졌을 때 취할 행동들
		dActivity.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss(DialogInterface arg0) {
				Toast.makeText(getApplicationContext(), dActivity.getMemoSubject(), 1000).show();
			}
		});

		// 커스텀 다이얼로그 객체에 Cancel 리스너 설정
		// 커스텀 다이얼로그의 취소 버튼을 터치했을 때 취할 행동들
		dActivity.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface arg0) {
				Toast.makeText(getApplicationContext(), "메모를 추가하지 않았습니다.",1000).show();
			}
		});
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
