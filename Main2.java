import java.util.*;

class Notebook {
    private String brand;
    private int ram; // in GB
    private int storage; // in GB
    private String os;
    private String color;

    // Конструктор
    public Notebook(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    // Геттеры
    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Dell", 16, 512, "Windows 10", "Black"));
        notebooks.add(new Notebook("Apple", 8, 256, "macOS", "Silver"));
        notebooks.add(new Notebook("HP", 32, 1024, "Windows 11", "Gray"));
        notebooks.add(new Notebook("Lenovo", 16, 512, "Linux", "Black"));

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        String input = scanner.nextLine();
        switch (input) {
            case "1":
                System.out.println("Введите минимальное значение ОЗУ (в ГБ):");
                filters.put("ram", scanner.nextInt());
                break;
            case "2":
                System.out.println("Введите минимальное значение объема ЖД (в ГБ):");
                filters.put("storage", scanner.nextInt());
                break;
            case "3":
                System.out.println("Введите необходимую операционную систему:");
                filters.put("os", scanner.next());
                break;
            case "4":
                System.out.println("Введите необходимый цвет:");
                filters.put("color", scanner.next());
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;
        }

        for (Notebook notebook : notebooks) {
            boolean matches = true;
            if (filters.containsKey("ram") && notebook.getRam() < (int) filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("storage") && notebook.getStorage() < (int) filters.get("storage")) {
                matches = false;
            }
            if (filters.containsKey("os") && !notebook.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("color") && !notebook.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                matches = false;
            }
            if (matches) {
                System.out.println(notebook);
            }
        }
    }
}