package com.ixidev.fileitemviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ixi.Dv on 3/22/2018.
 */

public class FileView extends FrameLayout {

    private ImageView ivIcon;
    private Drawable fileIcon;
    private TextView fileName;
    private TextView fileDiesc;
    private View rootView;
    private CharSequence mName;
    private CharSequence mDesc;
    private int nameColor;
    private int descColor;

    public FileView(@NonNull Context context) {
        this(context, null);
    }

    public FileView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FileView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        preparViews(context);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FileView,
                    defStyleAttr, R.style.Widget_File);
            mName = a.getString(R.styleable.FileView_fileName);
            mDesc = a.getString(R.styleable.FileView_fileDesc);
            nameColor = a.getColor(R.styleable.FileView_nameColor, getResources().getColor(R.color.filename_color));
            descColor = a.getColor(R.styleable.FileView_descColor, getResources().getColor(R.color.filedesc_color));
            if (a.hasValue(R.styleable.FileView_fileIcon)) {
                fileIcon = a.getDrawable(R.styleable.FileView_fileIcon);
                setFileIcon(fileIcon);
            }
            a.recycle();
            setFileName(mName);
            setFileDesc(mDesc);
            setNameColor(nameColor);
            setDescColor(descColor);
        }
    }


    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
    }

    private void preparViews(Context context) {
        rootView = LayoutInflater.from(context).inflate(R.layout.file_item_layout, null);
        this.fileName = rootView.findViewById(R.id.tvfilename);
        this.fileDiesc = rootView.findViewById(R.id.tvfiledesc);
        this.ivIcon = rootView.findViewById(R.id.ivfileic);
        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(rootView, lp);

    }

    public void setFileIcon(Drawable fileIcon) {
        this.fileIcon = fileIcon;
        this.ivIcon.setImageDrawable(fileIcon);
    }

    public void setFileName(CharSequence fileName) {
        this.mName = fileName;
        this.fileName.setText(fileName);
    }

    public void setFileDesc(CharSequence fileDiesc) {
        this.mDesc = fileDiesc;
        this.fileDiesc.setText(fileDiesc);
    }

    public CharSequence getFileName() {
        return mName;
    }

    public CharSequence getFileDiesc() {
        return mDesc;
    }

    public void setFileDesc(int resId) {
        setFileDesc(getResources().getString(resId));
    }

    public void setFileName(int resId) {
        setFileName(getResources().getString(resId));
    }

    public void setFileIcon(int resId) {
        setFileIcon(getResources().getDrawable(resId));
    }

    public void setNameColor(int nameColorl) {
        this.nameColor = nameColorl;
        this.fileName.setTextColor(nameColorl);
    }

    public void setDescColor(int descColorl) {
        this.descColor = descColorl;
        this.fileDiesc.setTextColor(descColorl);
    }
}
