package com.ucas.lostandfound;

import android.os.Parcel;
import android.os.Parcelable;

public class LostItem implements Parcelable {
    String name, location, details;

    public LostItem(String name, String location, String details) {
        this.name = name;
        this.location = location;
        this.details = details;
    }

    protected LostItem(Parcel in) {
        name = in.readString();
        location = in.readString();
        details = in.readString();
    }

    public static final Creator<LostItem> CREATOR = new Creator<LostItem>() {
        @Override
        public LostItem createFromParcel(Parcel in) {
            return new LostItem(in);
        }

        @Override
        public LostItem[] newArray(int size) {
            return new LostItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(location);
        parcel.writeString(details);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
