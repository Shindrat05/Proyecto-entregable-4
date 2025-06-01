import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        String option;

        book.load();

        do {
            System.out.println("\n--- Agenda Telefónica ---");
            System.out.println("1. Ver contactos");
            System.out.println("2. Agregar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    book.list();
                    break;
                case "2":
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Número: ");
                    String number = scanner.nextLine();
                    book.create(number, name);
                    break;
                case "3":
                    System.out.print("Número a eliminar: ");
                    String delNumber = scanner.nextLine();
                    book.delete(delNumber);
                    break;
                case "4":
                    book.save();
                    System.out.println("Agenda guardada. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (!option.equals("4"));

        scanner.close();
    }
}
