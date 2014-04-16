package org.androidtown.ui.listview;

import android.os.Bundle;
import android.app.Dialog;
import android.content.Context;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class DialogActivity extends Dialog implements OnTouchListener {

	private EditText memoTime, memoSubject, memoTodo;
	private Button addOK, addCancel;
	
	public DialogActivity(Context context) {
		super(context); // context 객체를 받는 생성자가 반드시 필요!
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.memo_dialog); // 커스텀 다이얼로그 레이아웃

		memoTime = (EditText) findViewById(R.id.dialogTime);
		memoSubject = (EditText) findViewById(R.id.dialogSubject);
		memoTodo = (EditText) findViewById(R.id.dialogTodo);
		
		addOK = (Button) findViewById(R.id.dialogAddOK);
		addCancel = (Button) findViewById(R.id.dialogAddCancel);

		addOK.setOnTouchListener(this);
		addCancel.setOnTouchListener(this);
	}

	// 시간을 읽어서 리턴함
	public String getMemoTime() {
		return memoTime.getText().toString();
	}

	// 과목명을 읽어서 리턴함
	public String getMemoSubject() {
		return memoSubject.getText().toString();
	}

	// 할일목록을 읽어서 리턴함
	public String getMemoTodo() {
		return memoTodo.getText().toString();
	}

	@Override // 터치 리스너
	public boolean onTouch(View v, MotionEvent event) {
		// 확인 버튼을 클릭하면 입력한 값을 적절히 설정한 후 다이얼로그를 닫음
		if (v == addOK)
			dismiss(); // 이후 MainActivity에서 구현해준 Dismiss 리스너가 작동함

		// 취소 버튼을 클릭하면 단순히 다이얼로그를 닫음
		else if (v == addCancel)
			cancel(); // 이후 MainActivity에서 구현해준 Dismiss와 Cancel 리스너가 작동함
		
		return false;
	}
}