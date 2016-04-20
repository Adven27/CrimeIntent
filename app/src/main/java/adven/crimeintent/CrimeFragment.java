package adven.crimeintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;

import adven.crimeintent.model.Crime;


public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mEditText;
    private Button mCrimeDateBtn;
    private CheckBox mCrimeSolvedCb;

    public CrimeFragment() { /* Required empty public constructor*/ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        mEditText = (EditText) v.findViewById(R.id.crimeTitle);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        mCrimeDateBtn = (Button) v.findViewById(R.id.crimeDateBtn);
        mCrimeDateBtn.setText(new Date().toString());
        mCrimeDateBtn.setEnabled(false);

        mCrimeSolvedCb = (CheckBox) v.findViewById(R.id.crimeSolvedCb);
        mCrimeSolvedCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }

}
