package adven.crimeintent;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import adven.crimeintent.model.Crime;

import static adven.crimeintent.CrimeListActivity.REQ_CODE_NOTIFY_ITEM_CHANGED;

public class CrimeViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

    private final CheckBox mSolvedView;
    private final TextView mTitleView;
    private final TextView mDateView;
    private Crime mCrime;

    public CrimeViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mSolvedView = (CheckBox) itemView.findViewById(R.id.crime_list_item_solved);
        mDateView = (TextView) itemView.findViewById(R.id.crime_list_item_date);
        mTitleView = (TextView) itemView.findViewById(R.id.crime_list_item_title);
    }


    @Override
    public void onClick(View v) {
        CrimeListActivity cla = (CrimeListActivity) v.getContext();
        Intent intent = CrimeActivity.newIntent(cla, mCrime.getId());
        cla.getHostedFragment().startActivityForResult(intent, REQ_CODE_NOTIFY_ITEM_CHANGED);
    }

    public void bind(Crime crime) {
        mCrime = crime;
        mSolvedView.setChecked(crime.isSolved());
        mDateView.setText(crime.getDate().toString());
        mTitleView.setText(crime.getTitle());
    }
}
