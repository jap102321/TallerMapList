package Taller;


import java.util.ArrayList;


public class Empleado {

    private String nombre;
    private String apellido;
    private int edad;
    private String departamento;

    private ArrayList<Empleado> listaEmpleados;

    public Empleado(){
        listaEmpleados = new ArrayList<>();
    }
    public Empleado(String nombre, String apellido, int edad, String departamento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public int getEdad() {
        return edad;
    }


    public String getDepartamento() {
        return departamento;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }

    public void addEmployee(String nombre, String apellido, int edad, String departamento){
        listaEmpleados.add(new Empleado(nombre, apellido, edad, departamento));
    }

    public void removeEmployee(String nombre, String apellido){
        String inputUsuario = nombre + " " + apellido;
        ArrayList <Empleado> empAEliminar = new ArrayList<>();

        for(Empleado employee : listaEmpleados){
            if(employee.getNombreCompleto().equalsIgnoreCase(inputUsuario)){
                empAEliminar.add(employee);
            }
        }

        listaEmpleados.removeAll(empAEliminar);
    }

    public void getEmployees(){
        for (Empleado employee : listaEmpleados){
            System.out.println("Nombre: " + employee.getNombre() + " Apellido: " + employee.getApellido() +
                    " Edad: " + employee.getEdad() + " Departamento: "+ employee.getDepartamento());
            System.out.println();
        }
    }

    public void getOneEmployee(String nombre, String apellido){
        String inputUsuario = nombre + " " + apellido;

        for(Empleado employee: listaEmpleados){
            if(employee.getNombreCompleto().equalsIgnoreCase(inputUsuario)){
                System.out.println("Nombre: " + employee.getNombre() + " Apellido: " + employee.getApellido() +
                        " Edad: " + employee.getEdad() + " Departamento: "+ employee.getDepartamento());
            }
        }
    }



}
