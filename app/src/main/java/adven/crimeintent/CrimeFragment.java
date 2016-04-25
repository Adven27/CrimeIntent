package adven.crimeintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import adven.crimeintent.model.Crime;
import adven.crimeintent.model.CrimesService;
import adven.crimeintent.model.Injection;


public class CrimeFragment extends Fragment {

    private static final String KEY_CRIME_ID = "adven.crimeintent.crime_id";
    private EditText mEditTextTitle;
    private Button mCrimeDateBtn;
    private CheckBox mCrimeSolvedCb;

    public CrimeFragment() { /* Required empty public constructor*/ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Crime mCrime = Injection.provide(CrimesService.class).getCrime(getArguments().getInt(KEY_CRIME_ID));

        Intent data = new Intent();
        data.putExtra(CrimeActivity.EXTRA_EDITED_CRIME_ID, mCrime.getId());
        getActivity().setResult(Activity.RESULT_OK, data);

        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        mEditTextTitle = (EditText) v.findViewById(R.id.crimeTitle);
        mEditTextTitle.setText(mCrime.getTitle());
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
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
        String dateBtnTxt = DateFormat.format("EEEE, MMM d, yyyy", mCrime.getDate()).toString();
        mCrimeDateBtn.setText(dateBtnTxt);
        mCrimeDateBtn.setEnabled(false);

        mCrimeSolvedCb = (CheckBox) v.findViewById(R.id.crimeSolvedCb);
        mCrimeSolvedCb.setChecked(mCrime.isSolved());
        mCrimeSolvedCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }

    public static CrimeFragment newInstance(int crimeId) {
        CrimeFragment fragment = new CrimeFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_CRIME_ID, crimeId);
        fragment.setArguments(args);
        return fragment;
    }
}
