// Generated by view binder compiler. Do not edit!
package com.example.final_71190463.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.final_71190463.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCrudBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText genBook;

  @NonNull
  public final EditText jdlBook;

  @NonNull
  public final Button subBtn;

  @NonNull
  public final TextView subTxt;

  @NonNull
  public final EditText thBook;

  @NonNull
  public final Button updBtn;

  private ActivityCrudBinding(@NonNull LinearLayout rootView, @NonNull EditText genBook,
      @NonNull EditText jdlBook, @NonNull Button subBtn, @NonNull TextView subTxt,
      @NonNull EditText thBook, @NonNull Button updBtn) {
    this.rootView = rootView;
    this.genBook = genBook;
    this.jdlBook = jdlBook;
    this.subBtn = subBtn;
    this.subTxt = subTxt;
    this.thBook = thBook;
    this.updBtn = updBtn;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCrudBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCrudBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_crud, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCrudBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.gen_book;
      EditText genBook = ViewBindings.findChildViewById(rootView, id);
      if (genBook == null) {
        break missingId;
      }

      id = R.id.jdl_book;
      EditText jdlBook = ViewBindings.findChildViewById(rootView, id);
      if (jdlBook == null) {
        break missingId;
      }

      id = R.id.sub_btn;
      Button subBtn = ViewBindings.findChildViewById(rootView, id);
      if (subBtn == null) {
        break missingId;
      }

      id = R.id.sub_txt;
      TextView subTxt = ViewBindings.findChildViewById(rootView, id);
      if (subTxt == null) {
        break missingId;
      }

      id = R.id.th_book;
      EditText thBook = ViewBindings.findChildViewById(rootView, id);
      if (thBook == null) {
        break missingId;
      }

      id = R.id.upd_btn;
      Button updBtn = ViewBindings.findChildViewById(rootView, id);
      if (updBtn == null) {
        break missingId;
      }

      return new ActivityCrudBinding((LinearLayout) rootView, genBook, jdlBook, subBtn, subTxt,
          thBook, updBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}