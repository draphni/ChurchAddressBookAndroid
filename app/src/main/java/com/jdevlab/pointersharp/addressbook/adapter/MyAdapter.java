package com.jdevlab.pointersharp.addressbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jdevlab.pointersharp.addressbook.R;

import org.w3c.dom.Text;

/**
 * Created by Jaehyeong on 1/19/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RecyclerVH> {

    Context c;
    String[] members;

    public MyAdapter(Context c, String[] members) {
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
        holder.eName.setText(members[position]);
    }

    @Override
    public int getItemCount() {
        return members.length;
    }


    public class RecyclerVH extends RecyclerView.ViewHolder {
        TextView eName;

        public RecyclerVH(View itemView) {
            super(itemView);

            eName = (TextView) itemView.findViewById(R.id.eName);
        }
    }
}
