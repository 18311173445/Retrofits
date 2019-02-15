package com.bawei.retrofit.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bawei.retrofit.R;
import com.bawei.retrofit.bean.Show;
import com.facebook.drawee.view.SimpleDraweeView;

public class ShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Show show;
    Context context;
    LayoutInflater layoutInflater ;
    final  int OME =0;
    final  int TWO =1;
    final  int THREE =2;
    public ShowAdapter(Show show, Context context) {
        this.show = show;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i==OME)
        {
            View view = layoutInflater.inflate(R.layout.show_pzsh, viewGroup, false);
            ViewHolder1 viewHolder = new ViewHolder1(view);
            return viewHolder;
        }
        if(i==TWO)
        {
            View view = layoutInflater.inflate(R.layout.show_rxxp, viewGroup, false);
            ViewHolder2 viewHolder2 = new ViewHolder2(view);
            return viewHolder2;
        }
        if(i==THREE)
        {
            View view = layoutInflater.inflate(R.layout.show_mlss, viewGroup, false);
            ViewHolder3 viewHolder3 = new ViewHolder3(view);
            return viewHolder3;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof ViewHolder1)
        {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
            ((ViewHolder1)viewHolder).pzsg.setLayoutManager(gridLayoutManager);
            PzshAdapter pzshAdapter = new PzshAdapter(show.getResult().getPzsh(), context);
 /*           rxxpRecycleView.setRXXPInterface(new RXXPRecycleView.RXXPInterface() {
                @Override
                public void RXXPonclick(String uid) {
                    myRecycleViewInterface.getuid(uid);
                }
            });*/
            ((ViewHolder1)viewHolder).pzsg.setAdapter(pzshAdapter);
        }
        if(viewHolder instanceof  ViewHolder2)
        {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            ((ViewHolder2)viewHolder).rxxp.setLayoutManager(linearLayoutManager);
            RxxpAdapter rxxpAdapter = new RxxpAdapter(show.getResult().getRxxp(), context);
 /*           rxxpRecycleView.setRXXPInterface(new RXXPRecycleView.RXXPInterface() {
                @Override
                public void RXXPonclick(String uid) {
                    myRecycleViewInterface.getuid(uid);
                }
            });*/
            ((ViewHolder2)viewHolder).rxxp.setAdapter(rxxpAdapter);
        }
        if(viewHolder instanceof  ViewHolder3)
        {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            ((ViewHolder3)viewHolder).mlss.setLayoutManager(gridLayoutManager);
            MlssAdapter mlssAdapter = new MlssAdapter(show.getResult().getMlss(), context);
 /*           rxxpRecycleView.setRXXPInterface(new RXXPRecycleView.RXXPInterface() {
                @Override
                public void RXXPonclick(String uid) {
                    myRecycleViewInterface.getuid(uid);
                }
            });*/
            ((ViewHolder3)viewHolder).mlss.setAdapter(mlssAdapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position%3;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        private final RecyclerView pzsg;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            pzsg = itemView.findViewById(R.id.pzsh_recycleview);
        }
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder {
        private final RecyclerView rxxp;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            rxxp = itemView.findViewById(R.id.rxxp_recycleview);
        }
    }
    public class ViewHolder3 extends RecyclerView.ViewHolder {
        private final RecyclerView mlss;
        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            mlss = itemView.findViewById(R.id.mlss_recycleview);
        }
    }
}
