package firstSemester.pse;

enum PowerSource {
    HUMAN, FUEL, ELECTRICITY
}

interface Vehicle {
    PowerSource getPowerSource();
    void printVehicleInfo();
}

interface RegisteredVehicle extends Vehicle {
    String getNumberPlate();
}

abstract class VehicleBase implements Vehicle {
    private final PowerSource powerSource;

    public VehicleBase(final PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    @Override
    public void printVehicleInfo() {
        System.out.format("Vehicle Type: %s%nPowered By: %s%n", getClass().getName(), this.powerSource);
    }

    @Override
    public PowerSource getPowerSource() {
        return this.powerSource;
    }
}

abstract class RegisteredVehicleBase extends VehicleBase implements RegisteredVehicle {
    protected final String numberPlate;

    public RegisteredVehicleBase(final PowerSource powerSource, final String numberPlate) {
        super(powerSource);
        this.numberPlate = numberPlate;
    }

    @Override
    public String getNumberPlate() {
        return this.numberPlate;
    }

    @Override
    public void printVehicleInfo() {
        super.printVehicleInfo();
        System.out.format("Number plate: %s%n", this.numberPlate);
    }
}

class Car extends RegisteredVehicleBase implements RegisteredVehicle {
    public Car(final String numberPlate) {
        super(PowerSource.FUEL, numberPlate);
    }
}

class Riksha extends RegisteredVehicleBase implements RegisteredVehicle {
    public Riksha(final String numberPlate) {
        super(PowerSource.HUMAN, numberPlate);
    }
}

class EBike extends VehicleBase implements Vehicle {
    public EBike() {
        super(PowerSource.ELECTRICITY);
    }
}
