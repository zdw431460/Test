package dxm.product.dyk.myrecycleview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.refreshview.callback.IHeaderCallBack;

/**
 * Created by Administrator on 2017/4/28.
 */

public class Custom  extends LinearLayout implements IHeaderCallBack {
    private TextView tv;
    private ImageView iv;
    private AnimationDrawable drawable;

    public Custom(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.animation, this);
        iv= (ImageView) view.findViewById(R.id.animation_image);
        tv= (TextView) view.findViewById(R.id.animation_tv);

    }

    public Custom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }




    @Override
    public void onStateNormal() {
      //  drawable.start();
                iv.setImageResource(R.mipmap.pull_26);
       tv.setText("下拉刷新");


    }

    @Override
    public void onStateReady() {
         iv.setImageResource(R.drawable.animation);
         drawable = (AnimationDrawable) iv.getDrawable();
        tv.setText(R.string.xrefreshview_header_hint_ready);
    }

    @Override
    public void onStateRefreshing() {
        drawable = (AnimationDrawable) iv.getDrawable();
        drawable.start();
        iv.setImageResource(R.mipmap.back_20);
       tv.setText(R.string.xrefreshview_header_hint_refreshing);
    }
    @Override
    public void onStateFinish(boolean success) {
        tv.setText(success ? R.string.xrefreshview_header_hint_loaded : R.string.xrefreshview_header_hint_loaded_fail);
    }

    @Override
    public void onHeaderMove(double headerMovePercent, int offsetY, int deltaY) {

    }

    @Override
    public void setRefreshTime(long lastRefreshTime) {

    }

    @Override
    public void hide() {
        setVisibility(GONE);

    }

    @Override
    public void show() {
        setVisibility(VISIBLE);

    }

    @Override
    public int getHeaderHeight() {
        return getMeasuredHeight();
    }
}
