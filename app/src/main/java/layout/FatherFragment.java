package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jdevlab.pointersharp.addressbook.R;
import com.jdevlab.pointersharp.addressbook.adapter.MyAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FatherFragment extends Fragment {

    private RecyclerView rv;
    private static String[] fathers = {"Jaehyeong", "Giyoun", "Jungho"};

    public static FatherFragment NewInstance(){
        FatherFragment fatherFragment = new FatherFragment();

        return fatherFragment;
    }

    public FatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_father, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.father_fragment);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv.setAdapter(new MyAdapter(getActivity(), fathers));
        return rootView;
    }

    public String toString(){
        return "Father Fragment";
    }
}
