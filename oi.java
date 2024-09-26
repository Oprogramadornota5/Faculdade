import java.util.Random;

public class Sensor {
    private String id;
    private double value;
    
    public Sensor(String id) {
        this.id = id;
    }
    
    public double readValue() {
        Random random = new Random();
        this.value = 20 + (80 * random.nextDouble());
        return this.value;
    }
    
    public String getId() {
        return id;
    }
    
    public double getValue() {
        return value;
    }
}
