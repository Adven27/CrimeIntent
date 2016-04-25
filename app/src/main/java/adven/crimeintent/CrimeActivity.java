package adven.crimeintent;

import android.content.Intent;
import android.support.annotation.NonNull;

public class CrimeActivity extends AbstractFragmentActivity {

    private static final String EXTRA_CRIME_ID = "adven.crimeintent.crime_id";
    public static String EXTRA_EDITED_CRIME_ID = "adven.crimeintent.edited_crime_id";

    @NonNull
    @Override
    public CrimeFragment createFragment() {
        int crimeId = getIntent().getIntExtra(EXTRA_CRIME_ID, 0);
        return CrimeFragment.newInstance(crimeId);
    }

    public static Intent newIntent(CrimeListActivity crimeListActivity, int crime) {
        Intent intent = new Intent(crimeListActivity, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crime);
        return intent;
    }
}
