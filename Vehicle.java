enum VehicleType {
    RACE,NOT_FOR_RACE, Family
}

enum CarType {
    Sport, Sedan, Hatchback, SUV
}

enum Gear {
    Manual, Automatic
}

// Vehicle class
abstract class Vehicle {

    String make, plate, color;
    VehicleType category;

    Vehicle(String make, String plate, String color,  VehicleType category) {
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.category = category;
    }
    abstract String vehicleInfo();

}


class Car extends Vehicle {
    Gear gear;
    CarType type;

    Car(String make, String plate, String color, VehicleType category, Gear gear, CarType type) {
        super(make, plate, color, category);
        this.gear = gear;
        this.type = type;
    }
    public String vehicleInfo() {
        return String.format("Employee has a %s%n- make: %s%n- plate: %s%n- Gear Type: %s%n- color: %s%n- category: %s%n",
                getClass().getSimpleName(),make, plate,gear,color,category);
    }
}

class Motorcycle extends Vehicle {
    boolean sidecar;

    Motorcycle(String make, String plate, String color, VehicleType category, boolean sidecar) {
        super(make, plate, color, category);
        this.sidecar = sidecar;
    }
    public String vehicleInfo() {
        return String.format("Employee has a %s%n- make: %s%n- plate: %s%n- color: %s%n- category: %s%n",
                getClass().getSimpleName(),make, plate,color,category);

    }
}