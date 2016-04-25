package adven.crimeintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class AbstractFragmentActivity extends AppCompatActivity {

    public Fragment getHostedFragment() {
        return mFragment;
    }

    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_host);

        FragmentManager fm = getSupportFragmentManager();
        mFragment = fm.findFragmentById(R.id.fragment_container);
        if (mFragment == null) {
            mFragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, mFragment).commit();
        }
    }

    @NonNull
    abstract public CrimeFragment createFragment();

}
