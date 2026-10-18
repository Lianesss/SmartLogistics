import cargo.CargoItem;
import cargo.FragileItem;
import cargo.StandartBox;
import cargo.Warehouse;
import service.Report;
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

        // Дженерик - универсальный код не зависящий от конкретных типов +- работает как шаблонные функции в плюсах


        // ПРОВЕРКА ЭТАПА 4
        System.out.println("\nДемонстрация Дженериков (Warehouse и Report)");
        Warehouse<StandartBox> standartBoxWarehouse= new Warehouse<>();
        standartBoxWarehouse.addItem(new StandartBox("BOX-101", "Большая коробка", 25.5));
        standartBoxWarehouse.addItem(new StandartBox("BOX-102", "Маленькая коробка коробка", 5.0));
        standartBoxWarehouse.addItem(new StandartBox("BOX-103", "Маленькая коробка коробка", 10.0));
        standartBoxWarehouse.addItem(new StandartBox("BOX-104", "Маленькая коробка коробка", 15.0));
        standartBoxWarehouse.addItem(new StandartBox("BOX-105", "Маленькая коробка коробка", 25.0));

        Warehouse<FragileItem> fragileItemWarehouse = new Warehouse<>();
        fragileItemWarehouse.addItem(new FragileItem("FRAG-555", "Хрупкое зеркало", 12.0));
        fragileItemWarehouse.addItem(new FragileItem("FRAG-556", "Хрупкое зеркало", 16.0));
        fragileItemWarehouse.addItem(new FragileItem("FRAG-557", "Хрупкое зеркало", 19.0));
        fragileItemWarehouse.addItem(new FragileItem("FRAG-558", "Хрупкое зеркало", 21.0));

        //standartBoxWarehouse.addItem(new FragileItem("FRAG-555", "Хрупкое зеркало", 12.0));
        //Класс Warehouse использует параметризацию типов (дженерики) <T extends ICargo>.
        //         Когда мы создали standardBoxWarehouse, мы жестко указали конкретный тип: Warehouse<StandardBox>.
        //         Это означает, что внутрь этого конкретного объекта компилятор разрешает добавлять
        //         ИСКЛЮЧИТЕЛЬНО объекты класса StandardBox (или его наследников).
        //         FragileItem является соседним классом-наследником BaseCargo, но он НЕ является StandardBox.
        //         Строгая типизация Java не позволяет смешивать несовместимые типы на этапе компиляции,
        //         защищая нас от ошибок в будущем.

        System.out.println("Проверка ограничения типов пройдена успешно (ошибка компиляции защищает склад от чужих типов).");

        // ОТЧЕТЫ
        System.out.println("--- Генерация отчетов ---");
        // отчет стандартного склада
        Report<Warehouse<StandartBox>> standartReport = new Report<>(standartBoxWarehouse);
        System.out.println("Отчет по складу стандартных коробок:");
        standartReport.printReport();
        standartBoxWarehouse.printManifest();

        System.out.println();

        //отчет хрупких грузов
        Report<Warehouse<FragileItem>> fragileReport = new Report<>(fragileItemWarehouse);
        System.out.println("Отчет по складу хрупких грузов:");
        fragileReport.printReport();
        fragileItemWarehouse.printManifest();
    }
}