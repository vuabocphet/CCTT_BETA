package com.developer.memory.junk.model;


import android.content.Context;

import com.developer.memory.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mazhuang on 16/1/14.
 */
public class JunkInfo implements Comparable<JunkInfo>, Serializable {
    public String name;
    public long mSize;
    public int icon;
    public String mPackageName;
    public String mPath;
    public ArrayList<JunkInfo> mChildren = new ArrayList<>();
    public boolean mIsVisible = false;
    public boolean mIsChild = true;
    public int typeJunk;;
    private Context context;

    public JunkInfo(Context context, int typeJunk) {
        this.context = context;
        this.typeJunk = typeJunk;
    }

    @Override
    public int compareTo(JunkInfo another) {

        String top = context.getString(R.string.system_cache);

        if (this.name != null && this.name.equals(top)) {
            return 1;
        }

        if (another.name != null && another.name.equals(top)) {
            return -1;
        }

        if (this.mSize > another.mSize) {
            return 1;
        } else if (this.mSize < another.mSize) {
            return -1;
        } else {
            return 0;
        }
    }
}
