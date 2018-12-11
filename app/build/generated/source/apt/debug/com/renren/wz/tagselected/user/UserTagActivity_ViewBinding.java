// Generated code from Butter Knife. Do not modify!
package com.renren.wz.tagselected.user;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.renren.wz.tagselected.R;
import com.renren.wz.tagselected.widget.FlowLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserTagActivity_ViewBinding implements Unbinder {
  private UserTagActivity target;

  @UiThread
  public UserTagActivity_ViewBinding(UserTagActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserTagActivity_ViewBinding(UserTagActivity target, View source) {
    this.target = target;

    target.flowLayoutTags = Utils.findRequiredViewAsType(source, R.id.flowLayout_tags, "field 'flowLayoutTags'", FlowLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserTagActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.flowLayoutTags = null;
  }
}
