package adven.crimeintent.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CrimesServiceImpl implements CrimesService {

    private final Map<Integer, Crime> crimesRepo = new HashMap<>();
    public CrimesServiceImpl() {
        crimesRepo.put(0, new Crime(0, "first", new Date()));
        crimesRepo.put(1, new Crime(1, "second", new Date()));
    }

    @Override
    public Collection<Crime> getCrimes() {
        return crimesRepo.values();
    }

    @Override
    public Crime getCrime(int uuid) {
        return crimesRepo.get(uuid);
    }
}
