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

public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.ViewHolder> {
    List<Show.ResultBean.MlssBean> mlss;
    Context context;
    LayoutInflater layoutInflater;
/*    MlssInterface mlssInterface ;

    public void getMlssInterface(MlssInterface mlssInterface ) {
        this.mlssInterface = mlssInterface ;
    }*/

    public MlssAdapter(List<Show.ResultBean.MlssBean> mlss, Context context) {
        this.mlss = mlss;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item_mlss, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.img.setImageURI(mlss.get(0).getCommodityList().get(i).getMasterPic());
        viewHolder.money.setText(mlss.get(0).getCommodityList().get(i).getPrice());
        viewHolder.title.setText(mlss.get(0).getCommodityList().get(i).getCommodityName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(mlss.get(0).getCommodityList().get(i).getCommodityId());
                Intent intent = new Intent(context, XiangActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlss.get(0).getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView img;
        private final TextView money;
        private final TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.mlss_img);
            money = itemView.findViewById(R.id.mlss_money);
            title = itemView.findViewById(R.id.mlss_title);
        }
    }
    public interface MlssInterface{
        public void getonclick();
    }
}
