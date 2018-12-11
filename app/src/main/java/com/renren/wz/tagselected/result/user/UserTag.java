package com.renren.wz.tagselected.result.user;

import java.io.Serializable;

/**
 * Created by zan on 2018/7/13.
 * 个人资料-标签
 */
public class UserTag implements Serializable {

    public final int UNCHECKED = 0;  // 未选中
    public final int CHECKED = 1;   // 选中
    public int id;     //标签id
    public String name; //标签名字
    public String color;//标签颜色  #DEDEDE
    public int select;//是否选中    0未选中  1 选中

    public UserTag() {
    }

    /**
     * 判断是否选中  true：选中
     */
    public boolean getIsChecked() {
        return select == CHECKED;

    }

    /**
     * 获取选中或者不选中状态数字
     *
     * @param checked 0未选中  1 选中
     * @return
     */
    public int getIsCheckedText(boolean checked) {
        return checked ? 1 : 0;
    }

    @Override
    public String toString() {
        return "UserTag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", select='" + select + '\'' +
                '}';
    }
}
