package com.jdevlab.pointersharp.addressbook.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jdevlab.pointersharp.addressbook.R;
import com.jdevlab.pointersharp.addressbook.model.Member;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RecyclerVH> {

    Context c;
    List<Member> members;

    public MyAdapter(Context c, List<Member> members) {
        this.c = c;
        this.members = members;
    }

    @Override
    public RecyclerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.layout_row, parent, false);
        return new RecyclerVH(v);
    }

    @Override
    public void onBindViewHolder(RecyclerVH holder, int position) {
        holder.eName.setText(members.get(position).geteName());
        holder.kName.setText(members.get(position).getkName());
        holder.region.setText(members.get(position).getRegion());

        String id = members.get(position).getId();

        if (!id.equals("\n")) {
            int n = Integer.parseInt(id) % 23;
            String imageSrc = "animal_" + n;

            int imageId = c.getResources().getIdentifier(imageSrc, "drawable", c.getPackageName());
            holder.imageView.setImageResource(imageId);
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }


    public class RecyclerVH extends RecyclerView.ViewHolder {
        TextView eName;
        TextView kName;
        TextView region;
        ImageView imageView;

        public RecyclerVH(View itemView) {
            super(itemView);

            eName = (TextView) itemView.findViewById(R.id.eName);
            kName = (TextView) itemView.findViewById(R.id.kName);
            region = (TextView) itemView.findViewById(R.id.region);
            imageView = (ImageView) itemView.findViewById(R.id.animal_profile);
        }

    }

}
