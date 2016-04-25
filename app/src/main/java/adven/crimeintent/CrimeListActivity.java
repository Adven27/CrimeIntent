package adven.crimeintent;


import android.support.annotation.NonNull;

public class CrimeListActivity extends AbstractFragmentActivity {
    public static final int REQ_CODE_NOTIFY_ITEM_CHANGED = 0;

    @NonNull
    @Override
    public CrimeFragment createFragment() {
        return new CrimeListFragment();
    }
}
