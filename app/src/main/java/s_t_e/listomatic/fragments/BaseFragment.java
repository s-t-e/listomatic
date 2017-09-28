package s_t_e.listomatic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import s_t_e.listomatic.R;

/**
 * Created by Ste on 28/09/2017.
 */

public class BaseFragment extends Fragment {

    public static final String ARG_FRAGMENT_NAME = "fragment_name";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        String pageName = getArguments().getString(ARG_FRAGMENT_NAME);
        getActivity().setTitle(pageName);
        return rootView;
    }
}
