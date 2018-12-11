package com.renren.wz.tagselected.utils;

import com.renren.wz.tagselected.result.user.UserTag;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zan on 2018/12/7 16:32
 */
public class TestDataUtils {

    public static List<UserTag> getTagsData() {
        List<UserTag> userTagList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            switch (i) {
                case 0:
                    UserTag userTag = new UserTag();
                    userTag.id = 111;
                    userTag.name = "月薪2W";
                    userTag.color = "#B26772";
                    userTag.select = 0;
                    userTagList.add(userTag);
                    break;
                case 1:
                    UserTag userTag1 = new UserTag();
                    userTag1.id = 112;
                    userTag1.name = "宅男";
                    userTag1.color = "#81626A";
                    userTag1.select = 1;
                    userTagList.add(userTag1);
                    break;
                case 2:
                    UserTag userTag2 = new UserTag();
                    userTag2.id = 113;
                    userTag2.name = "名车控";
                    userTag2.color = "#448E7E";
                    userTag2.select = 1;
                    userTagList.add(userTag2);
                    break;
                case 3:
                    UserTag userTag3 = new UserTag();
                    userTag3.id = 114;
                    userTag3.name = "年轻有活力";
                    userTag3.color = "#859732";
                    userTag3.select = 0;
                    userTagList.add(userTag3);
                    break;
                case 4:
                    UserTag userTag4 = new UserTag();
                    userTag4.id = 115;
                    userTag4.name = "探索";
                    userTag4.color = "#E46780";
                    userTag4.select = 1;
                    userTagList.add(userTag4);
                    break;
                case 5:
                    UserTag userTag5 = new UserTag();
                    userTag5.id = 116;
                    userTag5.name = "知识达人";
                    userTag5.color = "#DB0159";
                    userTag5.select = 1;
                    userTagList.add(userTag5);
                    break;
                case 6:
                    UserTag userTag6 = new UserTag();
                    userTag6.id = 117;
                    userTag6.name = "工作狂";
                    userTag6.color = "#E5142D";
                    userTag6.select = 0;
                    userTagList.add(userTag6);
                    break;
                case 7:
                    UserTag userTag7 = new UserTag();
                    userTag7.id = 118;
                    userTag7.name = "正能量";
                    userTag7.color = "#A81719";
                    userTag7.select = 0;
                    userTagList.add(userTag7);
                    break;
                case 8:
                    UserTag userTag8 = new UserTag();
                    userTag8.id = 119;
                    userTag8.name = "技术控，技术控，技术控";
                    userTag8.color = "#6AB0B7";
                    userTag8.select = 0;
                    userTagList.add(userTag8);
                    break;
                case 9:
                    UserTag userTag9 = new UserTag();
                    userTag9.id = 120;
                    userTag9.name = "白富美";
                    userTag9.color = "#EA4A32";
                    userTag9.select = 0;
                    userTagList.add(userTag9);
                    break;
                case 10:
                    UserTag userTag10 = new UserTag();
                    userTag10.id = 120;
                    userTag10.name = "高富帅";
                    userTag10.color = "#FBC900";
                    userTag10.select = 1;
                    userTagList.add(userTag10);
                    break;
                default:
                    break;
            }
        }
        return userTagList;
    }
}
