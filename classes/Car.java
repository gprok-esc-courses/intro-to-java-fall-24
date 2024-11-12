package classes;

public class Car {
    private int speed = 0;
    private boolean lightsOn = false;

    public void accelerate() {
        speed++;
    }

    public void slowDown() {
        speed--;
    }

    public void stop() {
        speed = 0;
    }

    public void turnLightsOn() {
        lightsOn = true;
    }

    public void turnLightsOff() {
        lightsOn = false;
    }

    public String toString() {
        return speed + " " + lightsOn;
    }

    public static void main(String[] args) {
        Car car = new Car();

        for(int i = 0; i < 45; i++) {
            car.accelerate();
        }
        System.out.println(car);
        car.turnLightsOn();
        System.out.println(car);
        car.stop();
        System.out.println(car);
        car.turnLightsOff();
        System.out.println(car);
    }
}
