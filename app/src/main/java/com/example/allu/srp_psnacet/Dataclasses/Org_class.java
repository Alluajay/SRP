package com.example.allu.srp_psnacet.Dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.allu.srp_psnacet.SqlliteDb.Org_db;

import java.util.ArrayList;

/**
 * Created by allu on 8/31/16.
 */
public class Org_class implements Parcelable {
    public String Name,Add,City,Abus,Email,Website;
    public int Phone1,Phone2;

    public Org_class(String name,String add,String city,String abus,String email,int phn1,int phn2,String website){
        this.Name =name;
        this.Add=add;
        this.Abus=abus;
        this.City=city;
        this.Email=email;
        this.Website=website;
        this.Phone1=phn1;
        this.Phone2=phn2;
    }

    protected Org_class(Parcel in) {
        Name = in.readString();
        Add = in.readString();
        City = in.readString();
        Abus = in.readString();
        Email = in.readString();
        Website = in.readString();
        Phone1 = in.readInt();
        Phone2 = in.readInt();
    }

    public static final Creator<Org_class> CREATOR = new Creator<Org_class>() {
        @Override
        public Org_class createFromParcel(Parcel in) {
            return new Org_class(in);
        }

        @Override
        public Org_class[] newArray(int size) {
            return new Org_class[size];
        }
    };

    public ArrayList Get_org(){
        ArrayList org=new ArrayList();

        org.add(Name);
        org.add(Add);
        org.add(City);
        org.add(Abus);
        org.add(Email);
        org.add(Website);
        org.add(Phone1);
        org.add(Phone2);

        return org;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Add);
        dest.writeString(City);
        dest.writeString(Abus);
        dest.writeString(Email);
        dest.writeString(Website);
        dest.writeInt(Phone1);
        dest.writeInt(Phone2);
    }
}
