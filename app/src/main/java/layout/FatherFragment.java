package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jdevlab.pointersharp.addressbook.R;
import com.jdevlab.pointersharp.addressbook.adapter.DBHelper;
import com.jdevlab.pointersharp.addressbook.adapter.MyAdapter;
import com.jdevlab.pointersharp.addressbook.adapter.RecyclerViewClickListener;
import com.jdevlab.pointersharp.addressbook.adapter.RecyclerViewTouchListener;
import com.jdevlab.pointersharp.addressbook.model.Member;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class FatherFragment extends Fragment {

    private DatabaseReference db;

    private RecyclerView rv;

    private SlidingUpPanelLayout slidingLayout;

    private MyAdapter adapter;

    private static List<Member> memberList = new ArrayList<Member>();

    DBHelper dbHelper;

    public static FatherFragment NewInstance() {
        FatherFragment fatherFragment = new FatherFragment();

        return fatherFragment;
    }

    public FatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        dbHelper = new DBHelper(getActivity().getApplicationContext());

        memberList = dbHelper.GetMembersByType("1");

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_father, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.father_fragment);

        slidingLayout = (SlidingUpPanelLayout) rootView.findViewById(R.id.sliding_layout);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new MyAdapter(getActivity(), memberList);

        rv.setAdapter(adapter);

        rv.addOnItemTouchListener(new RecyclerViewTouchListener(getActivity().getApplicationContext(), rv, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                SetSlidingPanelDetail(position);
            }

            @Override
            public void onLongClick(View view, int position) {
                //do something on long click
            }
        }));
        return rootView;
    }

    private void InitializeData() {


    }


    private void SetSlidingPanelDetail(int position) {
        //English Name
        ((TextView) slidingLayout.findViewById(R.id.eNameTv)).setText(memberList.get(position).geteName());

        //Korean Name
        ((TextView) slidingLayout.findViewById(R.id.kNameTv)).setText(memberList.get(position).getkName());

        //Address
        ((TextView) slidingLayout.findViewById(R.id.addressTv)).setText(memberList.get(position).getAddress() + " " + memberList.get(position).getZip());

        //Region
        ((TextView) slidingLayout.findViewById(R.id.regionTv)).setText(memberList.get(position).getRegion());

        //Phone number
        ((TextView) slidingLayout.findViewById(R.id.phoneTv)).setText(memberList.get(position).getCell());

        //DOB
        ((TextView) slidingLayout.findViewById(R.id.dobTv)).setText(memberList.get(position).getDob());

        //DOS
        ((TextView) slidingLayout.findViewById(R.id.dosTv)).setText(memberList.get(position).getDos());

    }

    public String toString() {
        return "Father Fragment";
    }
}
