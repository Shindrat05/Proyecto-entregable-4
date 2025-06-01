import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String, String> contacts = new HashMap<>();
    private final String FILE_NAME = "contacts.txt";

    public void load() {
        contacts.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    contacts.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo. Puede que aún no exista.");
        }
    }

    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    public void list() {
        System.out.println("\nContactos:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void create(String number, String name) {
        if (contacts.containsKey(number)) {
            System.out.println("Ya existe un contacto con ese número.");
        } else {
            contacts.put(number, name);
            System.out.println("Contacto agregado.");
        }
    }

    public void delete(String number) {
        if (contacts.remove(number) != null) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("No se encontró el número.");
        }
    }
}
