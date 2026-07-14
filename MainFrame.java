package ui;

import data.GestorEntidades;
import model.GuiaTuristico;
import model.Vehiculo;
import javax.swing.*;

public class MainFrame {
    public static void main(String[] args) {
        GestorEntidades gestor = new GestorEntidades();
        boolean continuar = true;

        while (continuar) {
            String mensaje = "Seleccione una opción de gestión para Llanquihue Tour:";
            Object[] opciones = {"Registrar Guía", "Registrar Vehículo", "Mostrar Reporte", "Salir"};

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    mensaje,
                    "Sistema de Control Interno - Llanquihue Tour",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones
            );

            if (seleccion == JOptionPane.CLOSED_OPTION) {
                seleccion = 3;
            }

            switch (seleccion) {
                case 0: // Registrar Guía
                    String nombre = "";
                    boolean nombreValido = false;

                    while (!nombreValido) {
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del guía:", "Registro de Guía", JOptionPane.QUESTION_MESSAGE);

                        if (nombre == null) {
                            break;
                        }

                        nombre = nombre.trim();

                        if (!nombre.isEmpty() && nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                            nombreValido = true;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Error: El nombre es obligatorio y debe contener únicamente letras y espacios (sin números).",
                                    "Formato Incorrecto", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (nombreValido) {
                        String idioma = JOptionPane.showInputDialog(null, "Ingrese el idioma del guía:", "Registro de Guía", JOptionPane.QUESTION_MESSAGE);
                        if (idioma != null && !idioma.trim().isEmpty()) {
                            gestor.agregarEntidad(new GuiaTuristico(nombre, idioma.trim()));
                            JOptionPane.showMessageDialog(null, "Guía registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;

                case 1: // Registrar Vehículo
                    String patente = "";
                    boolean patenteValida = false;

                    while (!patenteValida) {
                        patente = JOptionPane.showInputDialog(null,
                                "Ingrese la patente del vehículo:\n" +
                                        "(Formatos válidos: AABB12 o AB1234 - 6 caracteres)",
                                "Registro de Vehículo", JOptionPane.QUESTION_MESSAGE);

                        if (patente == null) {
                            break;
                        }

                        patente = patente.trim().toUpperCase();

                        if (patente.matches("^([A-Z]{4}[0-9]{2}|[A-Z]{2}[0-9]{4})$")) {
                            patenteValida = true;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Error: La patente debe tener exactamente 6 caracteres.\n" +
                                            "Formatos permitidos:\n" +
                                            "- 4 letras y 2 números (Ej: BBBB12)\n" +
                                            "- 2 letras y 4 números (Ej: BB1234)",
                                    "Formato Incorrecto", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (patenteValida) {
                        String capStr = JOptionPane.showInputDialog(null, "Ingrese la capacidad de pasajeros:", "Registro de Vehículo", JOptionPane.QUESTION_MESSAGE);
                        if (capStr != null && !capStr.trim().isEmpty()) {
                            try {
                                int capacidad = Integer.parseInt(capStr);
                                gestor.agregarEntidad(new Vehiculo(patente, capacidad));
                                JOptionPane.showMessageDialog(null, "Vehículo registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error: La capacidad debe ser un número entero.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    break;

                case 2:
                    String reporte = gestor.obtenerReporteFiltrado();
                    JOptionPane.showMessageDialog(null, reporte, "Registros Actuales", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3: 
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema Llanquihue Tour.", "Fin del Programa", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    }
}
