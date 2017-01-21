package com.jdevlab.pointersharp.addressbook.adapter;

import android.view.View;

/**
 * Created by Jaehyeong on 1/21/2017.
 */

public interface RecyclerViewClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);

}
