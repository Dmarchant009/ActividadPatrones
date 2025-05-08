import java.util.ArrayList;
import java.util.Scanner;

class Credencial implements Cloneable {
    private String cargo;
    private String rut;
    private String nombre;
    private String institucion;

    public Credencial(String cargo, String rut, String nombre, String institucion) {
        this.cargo = cargo;
        this.rut = rut;
        this.nombre = nombre;
        this.institucion = institucion;
    }

    @Override
    public Credencial clone() {
        try {
            return (Credencial) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    @Override
    public String toString() {
        return "Credencial{" +
                "Nombre='" + nombre + '\'' +
                ", Cargo='" + cargo + '\'' +
                ", RUT='" + rut + '\'' +
                ", Institución='" + institucion + '\'' +
                '}';
    }
}

class SingletonEvento {
    private static SingletonEvento instancia;
    private String institucion;

    private SingletonEvento() {
        this.institucion = "Hackaton 2021";
    }

    public static SingletonEvento getInstancia() {
        if (instancia == null) {
            instancia = new SingletonEvento();
        }
        return instancia;
    }

    public String atributo(String tipo) {
        if (tipo.equalsIgnoreCase("institucion")) {
            return institucion;
        }
        return "Atributo no encontrado";
    }
}


public class patrones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Credencial> credenciales = new ArrayList<>();
        Credencial plantilla = new Credencial("Asistente", "00000000-0","Nombre base", SingletonEvento.getInstancia().atributo("institucion")
        );

        int opcion;
        do {
            System.out.println("\n----------------- MENÚ ------------------");
            System.out.println("1. Agregar nueva credencial");
            System.out.println("2. Ver credenciales generadas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del asistente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese cargo (En el evento): ");
                    String cargo = scanner.nextLine();
                    System.out.print("Ingrese su RUT: ");
                    String rut = scanner.nextLine();

                    Credencial nueva = plantilla.clone();
                    nueva.setNombre(nombre);
                    nueva.setCargo(cargo);
                    nueva.setRut(rut);
                    nueva.setInstitucion(SingletonEvento.getInstancia().atributo("institucion"));

                    credenciales.add(nueva);
                    System.out.println("Credencial generada correctamente.");
                    break;
                case 2:
                    System.out.println("\n Lista de credenciales generadas:");
                    if (credenciales.isEmpty()) {
                        System.out.println("No hay credenciales generadas.");
                    } else {
                        for (Credencial c : credenciales) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:
                    System.out.println("salir");
                    break;
                default:
                    System.out.println("Seleccione una opcion valida");
            }

        } while (opcion != 3);

        scanner.close();
    }
}
