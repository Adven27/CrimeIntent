package adven.crimeintent;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adven.crimeintent.model.CrimesService;
import hugo.weaving.DebugLog;

@DebugLog
public class CrimeListAdapter extends RecyclerView.Adapter<CrimeViewHolder> {
    private final CrimesService crimesService;

    public CrimeListAdapter(CrimesService crimesService) {
        this.crimesService = crimesService;
    }

    @Override
    public CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.crime_list_item, parent, false);
        return new CrimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CrimeViewHolder holder, int position) {
        holder.bind(crimesService.getCrime(position));
    }

    @Override
    public int getItemCount() {
        return crimesService.getCrimes().size();
    }
}
