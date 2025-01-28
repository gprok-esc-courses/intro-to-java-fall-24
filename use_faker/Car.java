package use_faker;

public class Car {
    private int id;
    private String manufacturer;
    private String model;

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public Car(int id, String manufacturer, String model) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }
}
