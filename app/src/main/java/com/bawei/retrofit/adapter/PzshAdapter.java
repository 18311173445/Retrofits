package com.bawei.retrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.retrofit.R;
import com.bawei.retrofit.XiangActivity;
import com.bawei.retrofit.bean.Show;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class PzshAdapter extends RecyclerView.Adapter<PzshAdapter.ViewHolder> {
    List<Show.ResultBean.PzshBean> pzsh ;
    Context context;
    LayoutInflater layoutInflater;

    public PzshAdapter(List<Show.ResultBean.PzshBean> pzsh, Context context) {
        this.pzsh = pzsh;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item_pzsh, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.img.setImageURI(pzsh.get(0).getCommodityList().get(i).getMasterPic());
        viewHolder.money.setText(pzsh.get(0).getCommodityList().get(i).getPrice());
        viewHolder.title.setText(pzsh.get(0).getCommodityList().get(i).getCommodityName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(pzsh.get(0).getCommodityList().get(i).getCommodityId());
                Intent intent = new Intent(context, XiangActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pzsh.get(0).getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img;
        private final TextView money;
        private final TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.pzsh_img);
            money = itemView.findViewById(R.id.pzsh_money);
            title = itemView.findViewById(R.id.pzsh_title);
        }
    }
}
