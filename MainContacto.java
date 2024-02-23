
import java.util.Scanner;

public class MainContacto {
    public static void main(String[] args) {
        TelefonoMovil myPhone = new TelefonoMovil("663924963");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("0. Salir.");
            System.out.println("1. Imprimir contactos.");
            System.out.println("2. Agregar nuevo contacto.");
            System.out.println("3. Actualizar contacto existente.");
            System.out.println("4. Eliminar contacto de la lista.");
            System.out.println("5. Buscar/encontrar contacto por nombre.");
            System.out.println("6. Volver a imprimir lista de opciones.");

            System.out.println("Ingresa la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    myPhone.printContacts();
                    break;
                case 2:
                    System.out.println("Ingresa el nombre del nuevo contacto: ");
                    String nuevoNombre = scanner.next();
                    System.out.println("Ingresa el número de teléfono del nuevo contacto: ");
                    String nuevoTelefono = scanner.next();
                    Contacto nuevoContacto = Contacto.createContact(nuevoNombre, nuevoTelefono);
                    if (myPhone.addNewContact(nuevoContacto)) {
                        System.out.println("Contacto añadido correctamente.");
                    } else {
                        System.out.println("No es posible añadir el contacto. Ya existe.");
                    }
                    break;
                case 3:
                    System.out.println("Ingresa el nombre del contacto que quiere actualizar: ");
                    String nombreAntiguo = scanner.next();
                    Contacto antiguoContacto = myPhone.queryContact(nombreAntiguo);

                    if (antiguoContacto != null) {
                        System.out.println("Ingresa el nuevo nombre del contacto: ");
                        String nuevoNombreContacto = scanner.next();
                        System.out.println("Ingresa el nuevo número de teléfono del contacto: ");
                        String nuevoTelefonoContacto = scanner.next();

                        Contacto nuevoContactoActualizado = Contacto.createContact(nuevoNombreContacto, nuevoTelefonoContacto);

                        if (myPhone.updateContact(antiguoContacto, nuevoContactoActualizado)) {
                            System.out.println("Contacto actualizado con éxito.");
                        } else {
                            System.out.println("Uy, el nuevo contacto ya existe.");
                        }
                    } else {
                        System.out.println("Uy, el contacto no existe.");
                    }
                    break;
                case 4:
                    System.out.println("Ingresa el nombre del contacto que desea eliminar: ");
                    String nombreEliminar = scanner.next();
                    Contacto contactoEliminar = myPhone.queryContact(nombreEliminar);

                    if (contactoEliminar != null) {
                        if (myPhone.removeContact(contactoEliminar)) {
                            System.out.println("El contacto ha sido eliminado correctamente.");
                        } else {
                            System.out.println("Uy, el contacto no ha podido ser eliminado.");
                        }
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    break;
                case 5:
                    System.out.println("Ingresa el nombre del contacto que desea buscar: ");
                    String nombreBuscar = scanner.next();
                    Contacto contactoBuscado = myPhone.queryContact(nombreBuscar);

                    if (contactoBuscado != null) {
                        System.out.println("Información del contacto:");
                        System.out.println("Nombre: " + contactoBuscado.getName());
                        System.out.println("Número de teléfono: " + contactoBuscado.getPhoneNumber());
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción no válida. Selecciona una opción correcta.");
            }
        } while (opcion != 0);

        System.out.println("Adiós.");

        Contacto contact1 = Contacto.createContact("Antonio", "965492301");
        Contacto contact2 = Contacto.createContact("Juan", "965497735");

        myPhone.addContact(contact1);
        myPhone.addContact(contact2);

        int position = myPhone.findContact(contact1);
        if (position != -1) {
            System.out.println("Contacto encontrado en la posición: " + position);
        } else {
            System.out.println("Contacto no encontrado.");
        }

        position = myPhone.findContact("María");
        if (position != -1) {
            System.out.println("Contacto encontrado en la posición: " + position);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }
}
