package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slawomirmakurat.agromarket.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomemadePreservesFragment extends Fragment {


    public HomemadePreservesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homemade_preserves_, container, false);
    }

}
