import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerarSalarios {

    static final String[] NOMBRES = {
        "Carlos", "María", "José", "Ana", "Luis", "Laura", "Jorge", "Patricia",
        "Roberto", "Gabriela", "Fernando", "Alejandra", "Ricardo", "Sofía",
        "Eduardo", "Valeria", "Miguel", "Daniela", "Arturo", "Mónica",
        "Francisco", "Verónica", "Alejandro", "Claudia", "Javier", "Diana",
        "Sergio", "Elena", "Raúl", "Karla", "Héctor", "Liliana", "Oscar",
        "Leticia", "Mauricio", "Norma", "Enrique", "Adriana", "Guillermo",
        "Beatriz", "Pablo", "Ximena", "Andrés", "Mariana", "Diego", "Lucía",
        "Iván", "Paulina", "Rubén", "Fernanda", "Armando", "Estefanía",
        "Rodrigo", "Itzel", "Marco", "Brenda", "Ernesto", "Cynthia",
        "Gerardo", "Marisol", "Víctor", "Rebeca", "Manuel", "Gloria",
        "Ignacio", "Sandra", "Alfredo", "Yolanda", "Ramón", "Irene",
        "César", "Alicia", "Daniel", "Guadalupe", "Ángel", "Rocío",
        "Tomás", "Esmeralda", "Benjamín", "Natalia", "Leonardo", "Isabel",
        "Emilio", "Samantha", "Nicolás", "Paola", "Sebastián", "Vanessa",
        "Josué", "Margarita", "Maximiliano", "Concepción", "Ulises", "Hilda",
        "Mateo", "Esperanza", "Joel", "Estela", "Adrián", "Pilar"
    };

    static final String[] APELLIDOS = {
        "García", "Martínez", "López", "Hernández", "González", "Pérez",
        "Rodríguez", "Sánchez", "Ramírez", "Torres", "Flores", "Rivera",
        "Gómez", "Díaz", "Cruz", "Morales", "Reyes", "Gutiérrez", "Ortiz",
        "Chávez", "Ramos", "Vargas", "Castillo", "Jiménez", "Moreno",
        "Romero", "Herrera", "Medina", "Aguilar", "Vásquez", "Rojas",
        "Mendoza", "Ruiz", "Álvarez", "Delgado", "Navarro", "Cabrera",
        "Santos", "Ríos", "Alvarado", "Fuentes", "Figueroa", "Guerrero",
        "Luna", "Salinas", "Acosta", "Vega", "Campos", "Espinoza", "Núñez",
        "Cortés", "Miranda", "Lara", "Molina", "Montes", "Carrillo", "Juárez",
        "Palacios", "Valdez", "Tapia", "Suárez", "Osorio", "Peña", "Villa",
        "Contreras", "Téllez", "Cisneros", "Pacheco", "Villanueva", "Montoya",
        "León", "Soto", "Serrano", "Ávila", "Domínguez", "Zamora", "Ibarra",
        "Carrasco", "Robles", "Vergara", "Nava", "Pineda", "Escobar", "Zavala",
        "Sandoval", "Camacho", "Trejo", "Quintero", "Cervantes", "Ochoa",
        "Meza", "Velázquez", "Zúñiga", "Ponce", "Bravo", "Gallegos",
        "Barajas", "Magaña", "Valencia", "Becerra", "Monroy", "Palma"
    };

    public static void main(String[] args) {
        Random random = new Random();
        String[] rangos = {"asistente", "asociado", "titular"};

        try (PrintWriter writer = new PrintWriter(new FileWriter("salarios.txt"))) {
            for (int i = 0; i < 1000; i++) {
                String nombre   = NOMBRES[random.nextInt(NOMBRES.length)];
                String apellido = APELLIDOS[random.nextInt(APELLIDOS.length)];
                String rango    = rangos[random.nextInt(rangos.length)];
                double salario  = generarSalario(rango, random);

                writer.printf("%s %s %s %.2f%n", nombre, apellido, rango, salario);
            }
            System.out.println("Archivo salarios.txt generado con 1,000 líneas y nombres reales.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    private static double generarSalario(String rango, Random random) {
        return switch (rango) {
            case "asistente" -> 50000 + random.nextDouble() * 30000;
            case "asociado"  -> 60000 + random.nextDouble() * 50000;
            case "titular"   -> 75000 + random.nextDouble() * 55000;
            default -> 0;
        };
    }
}
