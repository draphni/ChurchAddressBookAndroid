package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jdevlab.pointersharp.addressbook.R;
import com.jdevlab.pointersharp.addressbook.adapter.MyAdapter;

public class StudentFragment extends Fragment {

    private RecyclerView rv;
    private static String[] students = {"Giyoun", "Jaehyeong", "Junsung", "Sunga"};

    public static StudentFragment NewInstance() {
        StudentFragment studentFragment = new StudentFragment();

        return studentFragment;
    }

    public StudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_student, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.student_fragment);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        //rv.setAdapter(new MyAdapter(getActivity(), students));
        return rootView;
    }

    public String toString() {
        return "Student Fragment";
    }
}
