package com.doiloppa.bottomsheet_ex;

import android.graphics.drawable.Drawable;

public class Item {

    Drawable drawable;
    String title;

    public Item(Drawable drawable, String title) {
        this.drawable = drawable;
        this.title = title;
    }


    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
