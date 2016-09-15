package com.example.allu.srp_psnacet.Dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by allu on 8/31/16.
 */
public class Equip_class implements Parcelable {
    public String Name;
    public String Desc;
    public String Types;
    public String Repair;
    public String More_Det;
    public String Htu;

    public Equip_class(String name,String desc,String types,String repair,String more_Det,String htu){
        this.Name=name;
        this.Desc=desc;
        this.Types=types;
        this.Repair=repair;
        this.More_Det=more_Det;
        this.Htu=htu;
    }

    protected Equip_class(Parcel in) {
        Name = in.readString();
        Desc = in.readString();
        Types = in.readString();
        Repair = in.readString();
        More_Det = in.readString();
        Htu = in.readString();
    }

    public static final Creator<Equip_class> CREATOR = new Creator<Equip_class>() {
        @Override
        public Equip_class createFromParcel(Parcel in) {
            return new Equip_class(in);
        }

        @Override
        public Equip_class[] newArray(int size) {
            return new Equip_class[size];
        }
    };

    public ArrayList<String> Get_Equip(){
        ArrayList<String> equip=new ArrayList<>();

        equip.add(Name);
        equip.add(Desc);
        equip.add(Types);
        equip.add(Repair);
        equip.add(More_Det);
        equip.add(Htu);

        return equip;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Desc);
        dest.writeString(Types);
        dest.writeString(Repair);
        dest.writeString(More_Det);
        dest.writeString(Htu);
    }
}
