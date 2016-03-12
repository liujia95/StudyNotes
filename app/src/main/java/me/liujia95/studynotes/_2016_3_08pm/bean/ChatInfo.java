package me.liujia95.studynotes._2016_3_08pm.bean;

import java.io.Serializable;

public class ChatInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6240488099748291325L;
    public int    iconFromResId;
    public String iconFromUrl;
    public String content; //消息内容
    public String time; // 转换后格式的时间
    public int    fromOrTo;// 0 是收到的消息，1是发送的消息

    @Override
    public String toString() {
        return "ChatInfoEntity [iconFromResId=" + iconFromResId
                + ", iconFromUrl=" + iconFromUrl + ", content=" + content
                + ", time=" + time + ", fromOrTo=" + fromOrTo + "]";
    }
}
