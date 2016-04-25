package adven.crimeintent.model;

import java.util.HashMap;
import java.util.Map;

public class Injection {

    private static final Map<Class, Object> services;
    static {
        Map<Class, Object> aMap = new HashMap<>();
        aMap.put(CrimesService.class, new CrimesServiceImpl());
        services = aMap;
    }

    public static <T> T provide(Class<T> aClass) {
        return (T) services.get(aClass);
    }

    public static <T> void bind(Class<T> aClass, Object impl) {
        services.put(aClass, impl);
    }
}