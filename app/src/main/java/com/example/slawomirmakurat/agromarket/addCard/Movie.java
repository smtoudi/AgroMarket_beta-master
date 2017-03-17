/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.slawomirmakurat.agromarket.addCard;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String mPosterUrl;
    private int mBackgroundColor;
    private int mTextColor;

    public Movie(String mMovieUrl) {
        this.mPosterUrl = mMovieUrl;
    }


    protected Movie(Parcel in) {
        mPosterUrl = in.readString();
        int[] c = new int[2];
        in.readIntArray(c);
        mBackgroundColor = c[0];
        mTextColor = c[1];
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getPosterUrl() {
        return mPosterUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mPosterUrl);
        int[] c = new int[]{mBackgroundColor, mTextColor};
        parcel.writeIntArray(c);
    }

    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
    }

    public int getColor() {
        return mBackgroundColor;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }
}
