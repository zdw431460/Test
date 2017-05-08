package dxm.product.dyk.myrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */

public class MyRecycleViewAdapter extends BaseRecyclerAdapter<MyRecycleViewAdapter.MyViewHolder> {
    private List<String> list=new ArrayList<>();
    private Context context;

    public MyRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder getViewHolder(View view) {
        return new MyViewHolder(view, false);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);


        return new MyViewHolder(view,true);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position, boolean isItem) {
        String s = list.get(position);
        holder.tv.setText(s);

    }

    @Override
    public int getAdapterItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;

        public MyViewHolder(View itemView,boolean isItem) {
            super(itemView);
            if (isItem){
                tv= (TextView) itemView.findViewById(R.id.tv);

            }
        }
    }
}
