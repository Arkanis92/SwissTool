package com.example.swisstool.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {

    private String name;
    private String bio;
    private int age;

    public Animal(String name) {
        this.name = name;
        this.bio = "";
        this.age = 0;
    }

    public Animal(String name, String bio, int age) {
        this.name = name;
        this.bio = bio;
        this.age = age;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        bio = in.readString();
        age = in.readInt();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(bio);
        parcel.writeInt(age);
    }
}