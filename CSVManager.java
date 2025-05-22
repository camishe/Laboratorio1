package paqueteprincipal;

import java.io.*;
import java.util.*;

public class CSVManager {
    // Escribir una lista de reservas en un archivo CSV usando PrintWriter
    public void escribirReservasCSV(String rutaArchivo, List<Reservas> reservas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo, true))) {
            // Escribir encabezado
            writer.println("habitacion,numDias,nombreCompleto,cedula,telefono");
            int habitacionNum = 1;
            for (Reservas reserva : reservas) {
                String nombreCompleto = reserva.getNombreCompletoCliente();
                String[] datos = {
                    String.valueOf(habitacionNum),
                    String.valueOf(reserva.getNumDias()),
                    nombreCompleto,
                    String.valueOf(reserva.getCliente().getCedulaIdentidad()),
                    String.valueOf(reserva.getCliente().getTelefono())
                };
                writer.println(String.join(",", datos));
                habitacionNum++;
            }
        } catch (IOException e) {
            System.out.println("Error al escribir reservas en el archivo CSV: " + e.getMessage());
        }
    }

    // Leer reservas desde un archivo CSV y reconstruir objetos Reservas
    public List<Reservas> leerReservasCSV(String rutaArchivo) {
        List<Reservas> reservas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean esPrimera = true;
            while ((linea = br.readLine()) != null) {
                if (esPrimera) { // Saltar encabezado
                    esPrimera = false;
                    continue;
                }
                String[] datos = linea.split(",");
                if (datos.length >= 5) {
                    // datos[0] = habitacion (se ignora para reconstruccion)
                    int numDias = Integer.parseInt(datos[1]);
                    String[] nombreApellido = datos[2].split(" ", 2);
                    String nombre = nombreApellido.length > 0 ? nombreApellido[0] : "";
                    String apellido = nombreApellido.length > 1 ? nombreApellido[1] : "";
                    long cedula = Long.parseLong(datos[3]);
                    long telefono = Long.parseLong(datos[4]);
                    Clientes cliente = new Clientes(nombre, apellido, cedula, telefono);
                    Reservas reserva = new Reservas(numDias, cliente);
                    reservas.add(reserva);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo CSV no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al reconstruir reservas: " + e.getMessage());
        }
        return reservas;
    }
}
