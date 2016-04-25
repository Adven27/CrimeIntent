package adven.crimeintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adven.crimeintent.model.CrimesService;
import adven.crimeintent.model.Injection;

import static adven.crimeintent.CrimeListActivity.REQ_CODE_NOTIFY_ITEM_CHANGED;

public class CrimeListFragment extends CrimeFragment {
    private RecyclerView recycler;
    private CrimeListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CrimeListAdapter(Injection.provide(CrimesService.class));
        recycler.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (REQ_CODE_NOTIFY_ITEM_CHANGED == requestCode) {
            adapter.notifyItemChanged(data.getIntExtra(CrimeActivity.EXTRA_EDITED_CRIME_ID, 0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
