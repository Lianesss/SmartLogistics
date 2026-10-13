import cargo.CargoItem;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Drone;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("ТЕСТ\n");

        // Создаем разные транспортные средства
        Vehicle myCar = new Car("CAR-777", 1200);
        // Грузовик с прицепом: лимит 10000 + 5000 = 15000 кг
        Truck heavyTruck = new Truck("TR-01", 10000.0, true);
        Drone deliveryDrone = new Drone("DRONE-99");

        // Тестируем перегрузку метода load()
        System.out.println("--- Проверка загрузки ---");

        // просто вес (в Vehicle)
        myCar.load(300.0);

        // одиночный именованный груз (CargoItem)
        CargoItem box1 = new CargoItem("Коробка с книгами", 150.0);
        heavyTruck.load(box1);

        // целая партия грузов (List<CargoItem>)
        List<CargoItem> batch = new ArrayList<>();
        batch.add(new CargoItem("Ящик с фруктами", 200.0));
        batch.add(new CargoItem("Пакет с электроникой", 50.0));
        heavyTruck.load(batch); // Загружаем всю партию в грузовик

        System.out.println();

        // Собираем всё в общий список для проверки полиморфизма (пункт 2.3)
        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.add(myCar);
        allVehicles.add(heavyTruck);
        allVehicles.add(deliveryDrone);

        System.out.println("--- Проверка полиморфизма (метод move) ---");

        // Заставляем все транспортные средства ехать/лететь в цикле
        for (Vehicle v : allVehicles) {
            v.move();
        }

        // Еще раз дрон, чтобы увидеть, как садится батарея
        System.out.println("\n--- Дрон летит еще раз ---");
        deliveryDrone.move();
        deliveryDrone.move();
    }
}