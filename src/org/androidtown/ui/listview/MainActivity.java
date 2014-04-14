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
 * 리스트뷰를 사용하는 방법에 대해 알 수 있습니다.
 * 
 * @author Mike
 *
 */
public class MainActivity extends Activity {

	/**
	 * 리스트뷰 객체
	 */
	//DataListView list;
	ListView list;
	
	/**
	 * 어댑터 객체
	 */
	IconTextListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        // 타이틀 없애기
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 리스트뷰 객체 생성
        //ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        //list = new DataListView(this);

        list = (ListView)findViewById(R.id.todoList);
        // 어댑터 객체 생성
        adapter = new IconTextListAdapter(this);

		// 아이템 데이터 만들기
        // 과목명(string) / 시간(int) / 비고(string)
		Resources res = getResources();
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "SE", "21:00", "퀴즈 제출"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "추억의 테트리스", "14:20", "900 원"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "고스톱 - 강호동 버전", "14:20", "1500 원"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "친구찾기 (Friends Seeker)", "14:20", "900 원"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "강좌 검색", "14:20", "900 원"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "지하철 노선도 - 서울", "14:40", "1500 원"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "지하철 노선도 - 도쿄", "11:20", "1500 원"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "지하철 노선도 - LA", "16:20", "1500 원"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "지하철 노선도 - 워싱턴", "14:00", "1500 원"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "지하철 노선도 - 파리", "4:20", "1500 원"));
		
		// 리스트뷰에 어댑터 설정
		list.setAdapter(adapter);

		// 새로 정의한 리스너로 객체를 만들어 설정
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
