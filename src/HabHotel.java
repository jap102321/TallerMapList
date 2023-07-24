import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class HabHotel {

// TODO Sistema de reservas de un hotel.
// TODO Supongamos que estás desarrollando un sistema de reservas para un hotel y necesitas almacenar la información de las
// TODO habitaciones disponibles y las reservas realizadas por los huéspedes.
// TODO En este sistema, utilizaremos Set para llevar un registro de las habitaciones disponibles y Map para almacenar
// TODO las reservas realizadas por los huéspedes, donde la clave será el nombre del huésped y el valor será el número
// TODO de la habitación reservada.

    public static void main(String[] args) {
        Set<Integer> numeroHabitacion = new HashSet<>();
        for (int i=101; i<=110; i++ ){
            numeroHabitacion.add(i);
        }
        String huesped="";


        Map<String, Integer> reservasHuespedes = new HashMap<>();

        hacerReserva(reservasHuespedes, 102,"Marcelino");
        hacerReserva(reservasHuespedes, 103, "Sebastiáno");
        hacerReserva(reservasHuespedes, 105, "Vanezo");
        hacerReserva(reservasHuespedes, 109, "Paulo");

        System.out.println("Reservas realizadas");
        mostrarReserva(reservasHuespedes);

        System.out.println("Habitaciones disponibles");
        mostrarHabitacionesDisponibles(reservasHuespedes, numeroHabitacion);




    }
    public static void hacerReserva(Map<String, Integer> reservasHuespedes, int numeroHabitacion, String huesped){
        if(reservasHuespedes.containsValue(numeroHabitacion)){
            System.out.println("La habitación " + numeroHabitacion + " ya está reservada");
        }else {
            reservasHuespedes.put(huesped, numeroHabitacion);
            System.out.println("El huesped llamado " + huesped + " ha hecho una reserva en la habitación " + numeroHabitacion);
        }
    }

    public static void mostrarReserva(Map<String, Integer> reservaHuespedes){

        for (Map.Entry<String, Integer>entry:reservaHuespedes.entrySet()){
            String huesped= entry.getKey();
            int numeroHabitaciones= entry.getValue();
            System.out.println(huesped+ " tiene reservado la habitación "+ numeroHabitaciones);
        }
    }

    public static void mostrarHabitacionesDisponibles(Map<String, Integer> reservaHuespedes, Set<Integer> numeroHabitacion){

        for(int habitacionDisponible : numeroHabitacion){
            if(!reservaHuespedes.containsValue(habitacionDisponible)){
                System.out.println("La habitación n° " + habitacionDisponible + " está disponible");
            }
        }
    }
}