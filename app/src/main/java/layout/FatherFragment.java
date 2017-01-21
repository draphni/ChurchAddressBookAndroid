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

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new MyAdapter(getActivity(), memberList);

        rv.setAdapter(adapter);

        rv.addOnItemTouchListener(new RecyclerViewTouchListener(getActivity().getApplicationContext(), rv, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext().getApplicationContext(), memberList.get(position).geteName() + " is clicked!", Toast.LENGTH_SHORT).show();
                //do something
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getContext().getApplicationContext(), memberList.get(position).geteName() + " is long pressed!", Toast.LENGTH_SHORT).show();
                //do something
            }
        }));
        return rootView;
    }

    private void InitializeData() {


    }


    public String toString() {
        return "Father Fragment";
    }
}
