// Generated code from Butter Knife. Do not modify!
package com.renren.wz.tagselected;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f070024;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_jump, "field 'btnJump' and method 'onViewClicked'");
    target.btnJump = Utils.castView(view, R.id.btn_jump, "field 'btnJump'", Button.class);
    view7f070024 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tvContent'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnJump = null;
    target.tvContent = null;

    view7f070024.setOnClickListener(null);
    view7f070024 = null;
  }
}
