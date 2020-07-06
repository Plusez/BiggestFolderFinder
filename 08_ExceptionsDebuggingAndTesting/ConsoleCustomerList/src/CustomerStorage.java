import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        try {

            if (data != null) {
                String[] components = data.split("\\s+");
                if (components[0].matches("[A-ZА-Я][a-zа-я]*")
                        && components[1].matches("[A-ZА-Я][a-zа-я]*")
                        && components[3].matches("(\\+)\\d{11}$")
                        && components[2].matches("[a-z0-9._-]+@[a-z0-9.-]+")) {
                    String name = components[0] + " " + components[1];
                    storage.put(name, new Customer(name, components[3], components[2]));
                } else {
                    System.out.println("неверный формат ");
                }
            } else {
                System.out.println("Данные отсутствуют");
            }
        } catch (Exception exception) {
            //exception.printStackTrace();
            System.out.println("Неверный формат строки");
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