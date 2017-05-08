package dxm.product.dyk.myrecycleview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private XRefreshView  xRefreshView;
    private RecyclerView rv;
    private ArrayList<String> data;
    private MyRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("小伟"+i);
        }
//        View inflate = LayoutInflater.from(this).inflate(R.layout.headerview, null);
//        adapter.setHeaderView(inflate,rv);

        adapter.setList(data);
        rv.setAdapter(adapter);
        Custom custom = new Custom(this);
        xRefreshView.setCustomHeaderView(custom);
        xRefreshView.setPinnedTime(1000);
        xRefreshView.setMoveForHorizontal(true);
        xRefreshView.setPullLoadEnable(true);
        xRefreshView.setAutoLoadMore(false);
       xRefreshView.enableReleaseToLoadMore(true);
        adapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
        xRefreshView.enableRecyclerViewPullUp(true);
        xRefreshView.enablePullUpWhenLoadCompleted(true);
      // xRefreshView.setPreLoadCount(4);

    }

    @Override
    protected void onStart() {
        super.onStart();

     xRefreshView.setXRefreshViewListener(new  XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       xRefreshView.stopRefresh();
                    }
                }, 500);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            data.add("老杨"+i);
                        }
                       // adapter.setList(data);
                        adapter.notifyDataSetChanged();
                       xRefreshView.setLoadComplete(true);
                    }
                }, 1000);
            }
        });
            }

    private void initView() {
        xRefreshView= (XRefreshView) findViewById(R.id.xrefreshview);
        rv= (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        adapter = new MyRecycleViewAdapter(this);



        //  GridLayoutManager layoutManager = new GridLayoutManager(this, 1);

    }
}
