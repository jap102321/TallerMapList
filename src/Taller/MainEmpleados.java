package Taller;

import java.util.*;

public class MainEmpleados {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        Map<String, List<Empleado>> empleadosPorDepartamento = new HashMap<>();
        Empleado emp = new Empleado();

        do{
            System.out.println("Menú de opciones");
            System.out.println("1. Agregar empleados");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Mostrar empleados por departamento");
            System.out.println("4. Mostrar información de un empleado");
            System.out.println("5. Eliminar el empleado.");
            System.out.println("0. Salir de la aplicación");
            System.out.println("Menú de opciones");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    addEmployeeToDepartment(emp);
                    break;
                case 2:
                    showEmployees(emp);
                    break;
                case 3:
                    orderByDepartment(empleadosPorDepartamento, emp);
                    break;
                case 4:
                    getOneEmployee(emp);
                    break;
                case 5:
                    deleteEmployee(emp);
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Option not available");
                    break;
            }


        }while(opcion!=0);
    }

    public static void addEmployeeToDepartment(Empleado emp){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del empleado nuevo: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido del empleado nuevo: ");
        String apellido = sc.nextLine();
        System.out.print("Edad del empleado nuevo: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Departamento del empleado nuevo: ");
        String dep = sc.nextLine();


        emp.addEmployee(nombre,apellido,edad,dep);
        System.out.println(" ");

    }

    public static void showEmployees(Empleado emp){
        emp.getEmployees();
        System.out.println(" ");

    }

    public static void orderByDepartment(Map<String, List<Empleado>> empleadosPorDepartamento, Empleado emp) {

        // Recorremos la lista de empleados del objeto emp
        for (Empleado employee : emp.getListaEmpleados()) {
            // Obtenemos el departamento del empleado
            String departamento = employee.getDepartamento();

            // Verificamos si el mapa ya contiene el departamento
            if (!empleadosPorDepartamento.containsKey(departamento)) {
                // Si no contiene el departamento, creamos una nueva lista para ese departamento
                empleadosPorDepartamento.put(departamento, new ArrayList<>());
            }

            // Agregamos el empleado a la lista correspondiente al departamento en el mapa
            // Al acceder al departamento con el get podemos acceder también al ArrayList de arriba.
            empleadosPorDepartamento.get(departamento).add(employee);
        }

        // Recorremos cada entrada del mapa empleadosPorDepartamento usando un bucle for-each
        // Por como funciona el forEach el Map.Entry tiene los tipos de datos que necesita el map y luego se itera
        // El entry set del map que llenamos arriba
        for (Map.Entry<String, List<Empleado>> entry : empleadosPorDepartamento.entrySet()) {
            // Obtenemos el nombre del departamento de la entrada actual del mapa
            String departamento = entry.getKey();


            // Imprimimos en pantalla el nombre del departamento actual
            System.out.println("Departamento: " + departamento);

            // Recorremos cada empleado en la lista de empleados del departamento actual
            for (Empleado empleado : entry.getValue()) {
                // Imprimimos en pantalla los detalles de cada empleado (nombre, apellido y edad)
                System.out.println("Nombre: " + empleado.getNombre() + " Apellido: " + empleado.getApellido() +
                        " Edad: " + empleado.getEdad());
            }

            System.out.println(" ");
        }
      }

    public static void deleteEmployee(Empleado emp){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre empleado a buscar: ");
        String nombre = sc.nextLine();
        System.out.println("Apellido empleado a buscar: ");
        String apellido = sc.nextLine();

        emp.removeEmployee(nombre, apellido);

        System.out.println("Empleado eliminado ");
        System.out.println(" ");

      }

    public static void getOneEmployee(Empleado emp){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre empleado a buscar: ");
        String nombre = sc.nextLine();
        System.out.println("Apellido empleado a buscar: ");
        String apellido = sc.nextLine();

        emp.getOneEmployee(nombre, apellido);
        System.out.println(" ");
    }

    }

