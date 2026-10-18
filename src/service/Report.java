package service;

public class Report<T> {
    private T data;

    public Report(T data) {
        this.data = data;
    }

    public void printReport() {
        System.out.println();
        System.out.println("--- НАЧАЛО ОТЧЕТА ---");
        System.out.println("Тип данных: " + data.getClass().getSimpleName());
        System.out.println("Содержимое:");
        System.out.println(data.toString());
        System.out.println("--- КОНЕЦ ОТЧЕТА ---");
        System.out.println();
    }

    public T getData() {
        return data;
    }
}
