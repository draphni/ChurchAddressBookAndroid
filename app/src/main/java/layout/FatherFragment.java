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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jdevlab.pointersharp.addressbook.R;
import com.jdevlab.pointersharp.addressbook.adapter.MyAdapter;
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

        InitializeData();

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_father, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.father_fragment);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new MyAdapter(getActivity(), memberList);

        rv.setAdapter(adapter);

        return rootView;
    }

    private void InitializeData() {
        memberList = new ArrayList<Member>();

        DatabaseReference db = FirebaseDatabase.getInstance().getReference("church-member");

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                memberList = new ArrayList<Member>();

                long c = dataSnapshot.getChildrenCount();

                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                while (iterator.hasNext()) {

                    Object value = iterator.next().getValue();

                    value.toString();

                    Map<String, Object> td = (HashMap<String, Object>) iterator.next().getValue();

                    String text = (String) td.get("eName");

                    text.toString();

                    List<Object> values = new ArrayList<>(td.values());

                    value.toString();

                    Member m = new Member();

                    String k = (String)values.get(0);

                    m.setkName((String)values.get(0));
                    //memberList.add(value);
                }

                MyAdapter adapter = new MyAdapter(getActivity(), memberList);
                rv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public String toString() {
        return "Father Fragment";
    }
}
