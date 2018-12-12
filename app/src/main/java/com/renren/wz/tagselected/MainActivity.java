package com.renren.wz.tagselected;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.renren.wz.tagselected.result.user.UserTag;
import com.renren.wz.tagselected.user.UserTagActivity;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * Created by zan on 2018/12/11.
 */
public class MainActivity extends AppCompatActivity {

    private static final int TAG_REQUEST_CODE = 101;

    @BindView(R.id.btn_jump)
    Button btnJump;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
    }

    @OnClick(R.id.btn_jump)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_jump:
                UserTagActivity.actionForResult(this, this, TAG_REQUEST_CODE);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == TAG_REQUEST_CODE) {
            //刷新界面
            if (data != null && data.getExtras() != null) {
                ArrayList<UserTag> returnData = (ArrayList<UserTag>) data.getExtras().getSerializable(UserTagActivity.TAG_DATA);
                if (returnData != null && returnData.size() > 0) {
                    StringBuffer buffer = new StringBuffer();
                    for (int i = 0; i < returnData.size(); i++) {
                        if (!TextUtils.isEmpty(returnData.get(i).name))
                            buffer.append(returnData.get(i).name).append("\r\n");
                    }
                    tvContent.setText(buffer);
                }else {
                    tvContent.setText("暂无内容");
                }
            }
        }
    }
}
