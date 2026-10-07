package vehicle;

//Абстрактный класс позволил нам объединить разные тс
// под «одной крышей» (Vehicle), гарантировал,
// что у каждого будет метод какой-то,
// но оставил логику расчета уникальной для каждой тс.
public abstract class Vehicle {
    private String id;
    private Double maxCapacityKg;
    private Double currentLoadKg;

    public Vehicle(String id, Double maxCapacityKg) {
        this.id = id;
        if (maxCapacityKg <= 0) {
            // создает новый объект ошибки
            throw new IllegalArgumentException("Грузоподъёмность должна быть > 0");
        }
        this.maxCapacityKg = maxCapacityKg;
        this.currentLoadKg = 0.0;
    }

    public abstract void move();

    //инкапсуляция
    public void load(double weight) {
        if (currentLoadKg + weight <= maxCapacityKg) {
            currentLoadKg += weight;
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }
    }

    public String getId() {
        return id;
    }

    public Double getMaxCapacityKg() {
        return maxCapacityKg;
    }

    public Double getCurrentLoadKg() {
        return currentLoadKg;
    }

    // полиморфизм - Одинаковый метод ведёт себя по-разному
    // в зависимости от реального объекта.
    // интерфейс - пока что хз
}


