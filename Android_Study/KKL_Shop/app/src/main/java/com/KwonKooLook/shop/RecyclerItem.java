package com.KwonKooLook.shop;


public class RecyclerItem {
    private int profile_Img,main_Img,like_Img,comment_Img ;
    private String profile_Txt,like_Count_Txt,comment_Txt;

    public RecyclerItem(int profile_Img, int main_Img, int like_Img, int comment_Img, String profile_Txt, String like_Count_Txt, String comment_Txt) {
        this.profile_Img = profile_Img;
        this.main_Img = main_Img;
        this.like_Img = like_Img;
        this.comment_Img = comment_Img;
        this.profile_Txt = profile_Txt;
        this.like_Count_Txt = like_Count_Txt;
        this.comment_Txt = comment_Txt;
    }

    public int getProfile_Img() {
        return profile_Img;
    }

    public void setProfile_Img(int profile_Img) {
        this.profile_Img = profile_Img;
    }

    public int getMain_Img() {
        return main_Img;
    }

    public void setMain_Img(int main_Img) {
        this.main_Img = main_Img;
    }

    public int getLike_Img() {
        return like_Img;
    }

    public void setLike_Img(int like_Img) {
        this.like_Img = like_Img;
    }

    public int getComment_Img() {
        return comment_Img;
    }

    public void setComment_Img(int comment_Img) {
        this.comment_Img = comment_Img;
    }

    public String getProfile_Txt() {
        return profile_Txt;
    }

    public void setProfile_Txt(String profile_Txt) {
        this.profile_Txt = profile_Txt;
    }

    public String getLike_Count_Txt() {
        return like_Count_Txt;
    }

    public void setLike_Count_Txt(String like_Count_Txt) {
        this.like_Count_Txt = like_Count_Txt;
    }

    public String getComment_Txt() {
        return comment_Txt;
    }

    public void setComment_Txt(String comment_Txt) {
        this.comment_Txt = comment_Txt;
    }
}
