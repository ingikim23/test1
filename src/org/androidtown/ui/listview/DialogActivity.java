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
		super(context); // context ��ü�� �޴� �����ڰ� �ݵ�� �ʿ�!
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.memo_dialog); // Ŀ���� ���̾�α� ���̾ƿ�

		memoTime = (EditText) findViewById(R.id.dialogTime);
		memoSubject = (EditText) findViewById(R.id.dialogSubject);
		memoTodo = (EditText) findViewById(R.id.dialogTodo);
		
		addOK = (Button) findViewById(R.id.dialogAddOK);
		addCancel = (Button) findViewById(R.id.dialogAddCancel);

		addOK.setOnTouchListener(this);
		addCancel.setOnTouchListener(this);
	}

	// �ð��� �о ������
	public String getMemoTime() {
		return memoTime.getText().toString();
	}

	// ������� �о ������
	public String getMemoSubject() {
		return memoSubject.getText().toString();
	}

	// ���ϸ���� �о ������
	public String getMemoTodo() {
		return memoTodo.getText().toString();
	}

	@Override // ��ġ ������
	public boolean onTouch(View v, MotionEvent event) {
		// Ȯ�� ��ư�� Ŭ���ϸ� �Է��� ���� ������ ������ �� ���̾�α׸� ����
		if (v == addOK)
			dismiss(); // ���� MainActivity���� �������� Dismiss �����ʰ� �۵���

		// ��� ��ư�� Ŭ���ϸ� �ܼ��� ���̾�α׸� ����
		else if (v == addCancel)
			cancel(); // ���� MainActivity���� �������� Dismiss�� Cancel �����ʰ� �۵���
		
		return false;
	}
}