package ltw.content.web.model;

public class Motorcycle {
    public Motorcycle(long motorcycleId, String motorcycleName, String motorcycleManufacturing, int motorcycleYear) {
        _motorcycleId = motorcycleId;
        _motorcycleName = motorcycleName;
        _motorcycleManufacturing = motorcycleManufacturing;
        _motorcycleYear = motorcycleYear;
    }

    public long getMotorcycleId() {
        return _motorcycleId;
    }

    public String getMotorcycleName() {
        return _motorcycleName;
    }

    public String getMotorcycleManufacturing() {
        return _motorcycleManufacturing;
    }

    public int getMotorcycleYear() {
        return _motorcycleYear;
    }

    private final long _motorcycleId;
    private final String _motorcycleName;
    private final String _motorcycleManufacturing;
    private final int _motorcycleYear;
}
