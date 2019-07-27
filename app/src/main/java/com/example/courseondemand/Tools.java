package com.example.courseondemand;

import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Tools {
    public static void setImage(ImageView view, String url) {
        if (view != null) {
            if (!TextUtils.isEmpty(url) && url.contains("https:")) {
                Picasso.get()
                        .load(url)
                        .placeholder(R.color.colorGray)
                        .error(R.color.colorGray)
                        .fit()
                        .into(view);
            } else {
                view.setImageResource(R.color.colorGray);
            }
        }
    }
}
