package com.example.fragmentdatatransfer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {


    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_button, container);

        // Get the Activity to which the Fragment belonged
        final FragmentActivity fragmentBelongActivity = getActivity();

        if (rootView != null) {
            //Tap on the Show button will reveal the Student ID in Fragment Student ID
            final Button btShow = rootView.findViewById(R.id.bt_show);
            btShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Do not use fragmentBelongActivity.getFragmentManager() method which is not compatible with older android os version. .
                    FragmentManager fragmentManager = fragmentBelongActivity.getSupportFragmentManager();

                    // Get Fragment Student ID object.
                    Fragment studentFragment = fragmentManager.findFragmentById(R.id.fragment3);

                    // Get the TextView object in Fragment Student ID.
                    TextView tvStudent = studentFragment.getView().findViewById(R.id.tv_student_id);
                    tvStudent.setVisibility(View.VISIBLE);
                }
            });

            //Tap on the Hide button will hide the the Student ID in fragment Student ID
            final Button btHide = rootView.findViewById(R.id.bt_hide);
            btHide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentManager fragmentManager = fragmentBelongActivity.getSupportFragmentManager();
                    Fragment studentFragment = fragmentManager.findFragmentById(R.id.fragment3);
                    TextView tvStudent = studentFragment.getView().findViewById(R.id.tv_student_id);
                    tvStudent.setVisibility(View.GONE);
                }
            });
        }

        return rootView;
        //return inflater.inflate(R.layout.fragment_button, container, false);
    }

}
