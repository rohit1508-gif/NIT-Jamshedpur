package com.example.nitjamshedpurfaculty.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nitjamshedpurfaculty.Activity.WebViewActivity;
import com.example.nitjamshedpurfaculty.ModalClass.FacultyInfo;
import com.example.nitjamshedpurfaculty.R;

import java.util.List;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.ViewHolder> {
    List<FacultyInfo> list;
    Context ctx;
    public FacultyAdapter(List<FacultyInfo> list,Context ctx){
        this.list=list;
        this.ctx=ctx;
    }
    @NonNull
    @Override
    public FacultyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new FacultyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyAdapter.ViewHolder holder, int position) {
        FacultyInfo l = list.get(position);
        holder.t.setText(l.getName());
        holder.t1.setText(l.getDes());
        holder.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Uri uri = Uri.parse(l.getLink());
//                ctx.startActivity(new Intent(Intent.ACTION_VIEW,uri));
                Intent i = new Intent(ctx, WebViewActivity.class);
                i.putExtra("url",l.getLink());
                ctx.startActivity(i);
            }
        });
        Glide.with(ctx).load(l.getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t,t1;
        Button b;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.name);
            t1=itemView.findViewById(R.id.des);
            b=itemView.findViewById(R.id.link);
            img=itemView.findViewById(R.id.img);
        }
    }
}
