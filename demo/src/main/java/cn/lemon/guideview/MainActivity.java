package cn.lemon.guideview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cn.lemon.view.Direction;
import cn.lemon.view.GuideView;

public class MainActivity extends AppCompatActivity {

    private GuideView mGVOne, mGVTwo, mGVThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();
        findViewById(R.id.rootview).post(new Runnable() {
            @Override
            public void run() {
                showGuideViews();
            }
        });
    }

    public void showGuideViews() {
        TextView mHintViewOne = new TextView(this);
        mHintViewOne.setText("列夫·托尔斯泰曾在《安娜·卡列尼娜》里说过：幸福的家庭都是相似的");
        mHintViewOne.setTextSize(20f);
        mHintViewOne.setTextColor(Color.WHITE);

        View view1 = View.inflate(this, R.layout.hint1, null);

        mGVOne = new GuideView.Builder(this)
                .setTargetView(R.id.text_one)
                .setHintView(view1)
                .setHintViewDirection(Direction.RIGHT_BOTTOM)
                .setTransparentOvalPadding(20)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mGVOne.hide();
                        mGVTwo.show();
                    }
                })
                .create();
        mGVOne.show();

        mGVTwo = new GuideView.Builder(this)
                .setTargetView(R.id.text_two)
                .setHintView(mHintViewOne)
                .setHintViewDirection(Direction.BOTTOM_ALIGN_LEFT)
                .setTransparentOvalPaddingLeft(20)
                .setTransparentOvalPaddingRight(20)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mGVTwo.hide();
                        mGVThree.show();
                    }
                })
                .create();

        mGVThree = new GuideView.Builder(this)
                .setTargetView(R.id.text_three)
                .setHintView(mHintViewOne)
                .setHintViewDirection(Direction.LEFT_BOTTOM)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mGVThree.hide();
                    }
                })
                .create();
    }
}
