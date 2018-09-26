package com.example.fragmentdatatransfer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFragment extends Fragment {


    public EditTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_edit_text, container);

        // Get the Fragment belonged Activity
        final FragmentActivity fragmentBelongActivity = getActivity();

        if (rootView != null) {

            // Any change on the EditText will be reflected in Fragment Button
            final EditText etContent = rootView.findViewById(R.id.et_content);
            etContent.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    // Do not use fragmentBelongActivity.getFragmentManager() method which is not compatible with older android os version. .
                    FragmentManager fragmentManager = fragmentBelongActivity.getSupportFragmentManager();

                    // Get Fragment Button object.
                    Fragment buttonFragment = fragmentManager.findFragmentById(R.id.fragment2);

                    // Get the TextView object in Fragment Button.
                    final TextView editTextContent = buttonFragment.getView().findViewById(R.id.tv_edittext_content);
                    editTextContent.setText(charSequence);
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        return rootView;
        //return inflater.inflate(R.layout.fragment_edit_text, container, false);
    }

}
