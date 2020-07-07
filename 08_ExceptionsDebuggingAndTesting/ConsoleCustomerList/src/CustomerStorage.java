import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IllegalArgumentException {

        if (data != null) {
            String[] components = data.split("\\s+");
            if (components.length != 4) {
                throw new IllegalArgumentException("неверный формат строки");
            }
            else {
                if (!components[0].matches("[A-ZА-ЯЁ][a-zа-яё]*")) {
                    throw new IllegalArgumentException("Неверный формат имени 1");
                } else if (!components[1].matches("[A-ZА-ЯЁ][a-zа-яё]*")) {
                    throw new IllegalArgumentException("Неверный формат имени 2");
                } else if (!components[3].matches("(\\+)\\d{11}$")) {
                    throw new IllegalArgumentException("Неверный формат телефона");
                } else if (!components[2].matches("[a-z0-9._-]+@[a-z0-9-]+\\.[a-z]{2,4}")) {
                    throw new IllegalArgumentException("Неверный формат почты");
                } else {
                    String name = components[0] + " " + components[1];
                    storage.put(name, new Customer(name, components[3], components[2]));
                }
            }
        } else {
            throw new IllegalArgumentException("Данные отсутствуют");
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}