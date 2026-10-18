import cargo.CargoItem;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Drone;
import vehicle.Vehicle;
import service.LogisticsCenter;
import interfaces.ITrackable;

import java.util.ArrayList;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("ТЕСТ\n");

        // Разные транспортные средства
        Vehicle myCar = new Car("CAR-777", 1200);
        Truck heavyTruck = new Truck("TR-01", 10000.0, true);
        Drone deliveryDrone = new Drone("DRONE-99");

        // Тест перегрузки метода load()
        System.out.println("--- Проверка загрузки ---");
        myCar.load(300.0);

        // Одиночный именованный груз (CargoItem)
        CargoItem box1 = new CargoItem("Коробка с книгами", 150.0);
        heavyTruck.load(box1);

        // целая партия грузов (List<CargoItem>)
        List<CargoItem> batch = new ArrayList<>();
        batch.add(new CargoItem("Ящик с фруктами", 200.0));
        batch.add(new CargoItem("Пакет с электроникой", 50.0));
        heavyTruck.load(batch); // Загружаем всю партию в грузовик

        System.out.println();

        // Проверка полиморфизма (пункт 2.3)
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

        System.out.println();

        // Проверка этапа 3
        List<ITrackable> trackableFleet = new ArrayList<>();
        trackableFleet.add(heavyTruck);
        trackableFleet.add(deliveryDrone);
        //trackableFleet.add(myCar); car - не реализует интерфейс ITrackable

        LogisticsCenter center = new LogisticsCenter();
        center.dispatch(trackableFleet); // Отправка статуса

        // Транспорт в движении - смена координат
        System.out.println();
        System.out.println("[Транспорт в движении...]");
        heavyTruck.move();
        deliveryDrone.move();

        // Мониторинг координат
        center.monitorFleet(trackableFleet);
    }
}