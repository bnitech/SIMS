package bonkers.cau.sims;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class AddEditActivity extends Activity {

    private int phoneBtnCount = 3, phoneMotionCount = 3;

    private String mModelName;

    private RelativeLayout mRelativeLayout;
    private int btnCount[] = {0, 0, 0};
    private ArrayList<Button> mButton = new ArrayList<Button>();
    private ArrayList<Button> mMotion = new ArrayList<Button>();
    private ArrayList<RelativeLayout.LayoutParams> mButonParam = new ArrayList<RelativeLayout.LayoutParams>();
    private ArrayList<RelativeLayout.LayoutParams> mMotionParam = new ArrayList<RelativeLayout.LayoutParams>();

    private Button mButtonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        // (임시로) 모델 "A" 전송
        mModelName = "A";

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_main);

        setLayout();
        checkModel();
        init();

        mButtonMain = (Button) findViewById(R.id.btn_main);
        mButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddEditActivity.this, PopupActivity.class);
                startActivity(i);
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(AddEditActivity.this);
        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();     //닫기
            }
        });
        alert.setMessage("don't press btn more than 2");
        alert.show();
    }

    private void setLayout() {

        //Button id = 1 ~
        for (int i = 0; i < phoneBtnCount; i++) {
            mButton.add(new Button(this));
            mButton.get(i).setId(i);
            mButton.get(i).setText("'" + i + "'");
            mButonParam.add(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        mButton.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnCount[0] == 0) {
                    if (btnCount[0] + btnCount[1] + btnCount[2] < 2) {
                        btnCount[0] = 1;
                        mButton.get(0).setBackgroundColor(Color.BLUE);
                    } else
                        showDialog();

                } else {
                    btnCount[0] = 0;
                    mButton.get(0).setBackgroundColor(Color.LTGRAY);

                }

            }
        });
        mButton.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnCount[1] == 0) {
                    if (btnCount[0] + btnCount[1] + btnCount[2] < 2) {
                        btnCount[1] = 1;
                        mButton.get(1).setBackgroundColor(Color.BLUE);
                    } else
                        showDialog();

                } else {
                    btnCount[1] = 0;
                    mButton.get(1).setBackgroundColor(Color.LTGRAY);

                }

            }
        });
        mButton.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnCount[2] == 0) {
                    if (btnCount[0] + btnCount[1] + btnCount[2] < 2) {
                        btnCount[2] = 1;
                        mButton.get(2).setBackgroundColor(Color.BLUE);
                    } else
                        showDialog();

                } else {
                    btnCount[2] = 0;
                    mButton.get(2).setBackgroundColor(Color.LTGRAY);

                }

            }
        });


        //Motion button id = 10 ~
        for (int i = 0; i < phoneMotionCount; i++) {
            mMotion.add(new Button(this));
            mButton.get(i).setId(i * 10);
            mMotionParam.add(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    private void init() {


        for (int i = 0; i < mButton.size(); i++) {
            mButton.get(i).setLayoutParams(mButonParam.get(i));
            mRelativeLayout.addView(mButton.get(i));
        }

    }

    private void checkModel() {

        if (mModelName == "A") {

            // 폰 가로,세로 비율
            //버튼 갯수
            //모션 갯수
            //폰 이미지
            phoneBtnCount = 3;
            phoneMotionCount = 2;

            mButonParam.get(0).addRule(RelativeLayout.LEFT_OF, R.id.btn_main);
            mButonParam.get(0).addRule(RelativeLayout.ALIGN_TOP, R.id.btn_main);
            mButonParam.get(1).addRule(RelativeLayout.RIGHT_OF, R.id.btn_main);
            mButonParam.get(1).addRule(RelativeLayout.ALIGN_TOP, R.id.btn_main);
            mButonParam.get(2).addRule(RelativeLayout.LEFT_OF, R.id.btn_main);
            mButonParam.get(2).addRule(RelativeLayout.ALIGN_BOTTOM, R.id.btn_main);


        } else if (mModelName == "B") {

        } else if (mModelName == "C") {

        } else {
            //데이터가 없습니다.
        }
    }


    private void Setting() {


    }
}
