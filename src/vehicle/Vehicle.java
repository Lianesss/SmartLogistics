package vehicle;

import cargo.CargoItem;

import java.util.ArrayList;
import java.util.List;

//Абстрактный класс позволил нам объединить разные тс
// под «одной крышей» (Vehicle), гарантировал,
// что у каждого будет метод какой-то,
// но оставил логику расчета уникальной для каждой тс.
public abstract class Vehicle {
    private String id;
    private Double maxCapacityKg;
    private Double currentLoadKg;
    private List<CargoItem> cargoList;

    public Vehicle(String id, Double maxCapacityKg) {
        this.id = id;
        if (maxCapacityKg <= 0) {
            // создает новый объект ошибки
            throw new IllegalArgumentException("Грузоподъёмность должна быть > 0");
        }
        this.maxCapacityKg = maxCapacityKg;
        this.currentLoadKg = 0.0;
        this.cargoList = new ArrayList<>();
    }

    public abstract void move();

    // полиморфизм ad-hoc
    // ТОЛЬКО ВЕС
    public void load(double weight) {
        if (weight <= 0) {
            System.out.println("Вес должен быть положительным.");
            return;
        }

        if (currentLoadKg + weight <= maxCapacityKg) {
            currentLoadKg += weight;
            cargoList.add(new CargoItem("FastLoad", weight));
            System.out.println("Загружено " + weight + "кг в тс " + id);
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }
    }

    // ИМЕНОВАННЫЙ ГРУЗ
    public void load(CargoItem item) {
        double weight = item.getWeight();
        if (currentLoadKg + weight <= maxCapacityKg) {
            currentLoadKg += weight;

            // загрузка самого груза в список
            cargoList.add(item);
            System.out.println("Загружен груз '" + item.getName() + "' (" + weight + "кг) в тс " + id);
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }
    }

    // ПАРТИЯ ГРУЗОВ
    public void load(List<CargoItem> items) {
        double totalWeight = 0;
        for (CargoItem item : items){
            totalWeight +=item.getWeight();
        }
        if (currentLoadKg + totalWeight <= maxCapacityKg) {
            currentLoadKg += totalWeight;

            //addAll добавляет всю партию из items в cargoList
            cargoList.addAll(items);
            System.out.println("Партия из " + items.size() + " предметов успешно загружена в " + id);
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }

    }


    // ГЕТЕРЫ
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


