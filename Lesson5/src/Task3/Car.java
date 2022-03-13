package Task3;

import Task3.Engine.Engine;
import Task3.Engine.Gas90;
import Task3.Model.Model;
import Task3.Model.Vesta;

import java.io.Serializable;

public class Car implements Serializable {
    private String vin;
    private int ownersCount;
    private Model model;
    private Engine engine;

    public Car(String vin) {
        this.vin = vin;
        this.ownersCount = 0;
        this.model = new Vesta();
        this.engine = new Gas90();
    }

    public String getVin() {
        return vin;
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public Model getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setOwnersCount(int ownersCount) {
        this.ownersCount = ownersCount;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return String.format("%s\n VIN: %s\n Двигатель: %s\n Кол-во владельцев: %s\n", model, vin, engine, ownersCount);
    }
}
