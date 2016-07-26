package com.example.allu.srp_psnacet.Dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by allu on 7/26/16.
 */
public class feed_class implements Parcelable {
    String Heading,Type,Desc,Pic_link;
    int auth;

    public feed_class(String head,String ty,String des,String pic,int au){
        this.Heading=head;
        this.Type=ty;
        this.Desc=des;
        this.Pic_link=pic;
        this.auth=au;
    }

    public HashMap<String,String> getfeed(){
        HashMap<String,String> feed=new HashMap<String, String>();
        feed.put("head",Heading);
        feed.put("type",Type);
        feed.put("desc",Desc);
        feed.put("pic",Pic_link);
        feed.put("auth",auth+"");
        return feed;
    }


    protected feed_class(Parcel in) {
        Heading = in.readString();
        Type = in.readString();
        Desc = in.readString();
        Pic_link = in.readString();
        auth = in.readInt();
    }

    public static final Creator<feed_class> CREATOR = new Creator<feed_class>() {
        @Override
        public feed_class createFromParcel(Parcel in) {
            return new feed_class(in);
        }

        @Override
        public feed_class[] newArray(int size) {
            return new feed_class[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Heading);
        dest.writeString(Type);
        dest.writeString(Desc);
        dest.writeString(Pic_link);
        dest.writeInt(auth);
    }
}
