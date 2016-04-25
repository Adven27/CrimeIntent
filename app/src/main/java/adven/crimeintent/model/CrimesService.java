package adven.crimeintent.model;

import java.util.Collection;

public interface CrimesService {

    Collection<Crime> getCrimes();
    Crime getCrime(int uuid);
}
