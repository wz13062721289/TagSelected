package com.renren.wz.tagselected.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.renren.wz.tagselected.R;
import com.renren.wz.tagselected.result.user.UserTag;
import com.renren.wz.tagselected.utils.ScreenUtils;
import com.renren.wz.tagselected.utils.TestDataUtils;
import com.renren.wz.tagselected.widget.FlowLayout;
import com.renren.wz.tagselected.widget.UserColorTagView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zan on 2018/7/13.
 * 个人资料-标签
 */
public class UserTagActivity extends AppCompatActivity {

    public static final String TAG_DATA = "tag_data";
    private static final int MAX_COUNT_TAGS = 8;//标签最大数

    @BindView(R.id.flowLayout_tags)
    FlowLayout flowLayoutTags;

    private ArrayList<UserTag> selectTagsData;//选中的条目的集合
    protected Context mContext;

    public static void actionForResult(Activity activity, Context context, int requestCode) {
        Intent intent = new Intent(context, UserTagActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_tag);
        mContext = this;
        initView();
        initData(TestDataUtils.getTagsData());
    }

    public void initView() {
        ButterKnife.bind(this);
    }

    private void initData(final List<UserTag> mTagData) {
        if (selectTagsData == null) {
            selectTagsData = new ArrayList<>();
        } else {
            selectTagsData.clear();
        }
        if (mTagData != null) {
            for (int i = 0; i < mTagData.size(); i++) {
                UserTag userTag = mTagData.get(i);
                UserColorTagView userColorTagView = getUserColorTagView();
                userColorTagView.setText(userTag.name);
                userColorTagView.setTagColor(Color.parseColor(userTag.color));

                userColorTagView.setChecked(userTag.getIsChecked());
                if (userTag.getIsChecked() && selectTagsData.size() < MAX_COUNT_TAGS) {//最多8个标签
                    selectTagsData.add(userTag);//已选中的标签直接添加
                }

                flowLayoutTags.addView(userColorTagView);
                /**
                 * 设置selectTagView 点击监听
                 */
                userColorTagView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UserColorTagView selectTagView = (UserColorTagView) v;
                        String s_content = selectTagView.getText().toString();
                        for (int j = 0; j < mTagData.size(); j++) {
                            if (s_content.equals(mTagData.get(j).name)) {
                                UserTag userTag1 = mTagData.get(j);
                                if (selectTagView.isChecked()) {//原来没选中，点击之后选中了。因为在调onClick方法之前 UserColorTagView 已经做了点击处理
                                    userTag1.select = userTag1.getIsCheckedText(true);//标签数据设置为选中状态
                                    selectTagsData.add(userTag1);//添加
                                    Log.d("flag_zan_select_count", selectTagsData.toString());
                                } else {//未选中
                                    userTag1.select = userTag1.getIsCheckedText(false);//标签数据设置为未选中状态
                                    selectTagsData.remove(userTag1);//删除
                                    Log.d("flag_zan_select_count2", selectTagsData.toString());
                                }
                            }
                        }
                        if (selectTagsData.size() >= MAX_COUNT_TAGS) {//最多选8个标签，大于等于8个其他的设置为不可选
                            Toast.makeText(UserTagActivity.this, "最多选" + MAX_COUNT_TAGS + "个标签", Toast.LENGTH_SHORT).show();

                            /**
                             * 下面打印出来的值是11， FlowLayout 应该还有其他子view
                             * FlowLayout 继承 ViewGroup
                             */
                            Log.d("flag_zan_child_count", flowLayoutTags.getChildCount() + "");
                            changeCheckedStatus();
                        } else {//小于8个标签，所有的标签都设置为可选
                            initCheckedStatus();
                        }

                    }
                });

            }
            /**
             * 设置 UserColorTagView 选中和未选中状态
             * 上面的是设置点击后 是否可点击的状态 二者不冲突不重复
             */
            if (selectTagsData.size() >= MAX_COUNT_TAGS) {//最多选8个标签，大于等于8个其他的设置为不可选
                changeCheckedStatus();
            } else {//小于8个标签，所有的标签都设置为可选
                initCheckedStatus();
            }
        }
    }

    /**
     * 初始化可选状态
     * 全部设置为可选
     */
    private void initCheckedStatus() {
        for (int k = 0; k < flowLayoutTags.getChildCount(); k++) {
            View child = flowLayoutTags.getChildAt(k);
            if (child instanceof UserColorTagView) {
                UserColorTagView childView = (UserColorTagView) child;
                childView.setEnabled(true);
            }
        }
    }

    /**
     * 改变选中状态
     */
    private void changeCheckedStatus() {
        for (int k = 0; k < flowLayoutTags.getChildCount(); k++) {
            View child = flowLayoutTags.getChildAt(k);
            if (child instanceof UserColorTagView) {
                UserColorTagView childView = (UserColorTagView) child;
                if (childView.isChecked()) {
                    childView.setEnabled(true);
                } else {
                    childView.setEnabled(false);
                }
            }
        }
    }

    /**
     * 获取标签tagview
     *
     * @return
     */
    private UserColorTagView getUserColorTagView() {
        UserColorTagView userColorTagView = new UserColorTagView(mContext);
        userColorTagView.setGravity(Gravity.CENTER);
        userColorTagView.setTextColor(getResources().getColor(R.color.white));
        userColorTagView.setTextSize(14);
        userColorTagView.setEnabled(true);
        userColorTagView.setChecked(false);
        int leftRightPadding = ScreenUtils.dip2px(15, mContext);
        int topBottomPadding = ScreenUtils.dip2px(5, mContext);
        userColorTagView.setPadding(leftRightPadding, topBottomPadding, leftRightPadding, topBottomPadding);
        return userColorTagView;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                Intent intent = new Intent();
                intent.putExtra(TAG_DATA, selectTagsData);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
