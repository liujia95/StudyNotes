package me.liujia95.studynotes._2016_3_03.bean;

import me.liujia95.studynotes._2016_3_03.utils.CharacterParser;

public class DataBean {

    public static final int TYPE_CHARACTER = 0; //首字母item的类型
    public static final int TYPE_DATA = 1;      //数据类型
    private int item_type;                      //类型
    private String item_en;
    private String name;                        //姓名
    private String phone;                       //电话
    /*其他成员*/

    public DataBean(String name,String phone,int type){
        CharacterParser parser = CharacterParser.getInstance();
        this.name = name;
        this.phone = phone;
        this.item_type = type;
        this.item_en = parser.getSelling(name).toUpperCase().trim();
        if(!item_en.matches("[A-Z]+")){
            item_en = "#"+item_en;
        }
    }

    public int getItem_type() {
        return item_type;
    }

    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }

    public String getItem_en() {
        return item_en;
    }

    public void setItem_en(String item_en) {
        this.item_en = item_en;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}