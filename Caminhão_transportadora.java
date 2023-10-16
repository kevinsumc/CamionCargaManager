/*
El objetivo de esta tarea es crear una aplicación (JOptionPanes) que tenga una función que reciba pedidos (nombre, origen, destinatario y volumen).
Si llenas el 100% del espacio de un camión caja de 25m² (Si el conjunto de cargas recibidas supera los 25m²)
dejar la última carga en el almacén y recibir la siguiente carga para ver si el camión cierra).
Crea otra opción, cierra la carga y muestra un mensaje si todavía hay espacio en la carga (y muestra el espacio restante).
Crear una opción que elimine la carga más cercana a la salida y muestre todo su contenido, si no hay más cargas informar al usuario.
 */
package Semana9;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Caminhão_transportadora {

    public static void main(String[] args) {

        ArrayList<encomendas> lista2 = new ArrayList<encomendas>();
        int opcion = -1;

        while (opcion != 4) {

            String op = JOptionPane.showInputDialog(
                    "\nELIGE UNA OPCION"
                    + "\n0. Ingresar encomiendas."
                    + "\n1. Mostrar encomiendas."
                    + "\n2. Llenar camión(Volumen max 25m²)"
                    + "\n3. Retirar la carga mas proxima."
                    + "\n4.Salir"
            );

            opcion = Integer.parseInt(op);

            switch (opcion) {
                case 0:
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantas encomiendas desea ingresar? "));
                    for (int i = 0; i < cantidad; i++) {
                        String nome = JOptionPane.showInputDialog(null, "Nombre de la encomienda: ");
                        String origem = JOptionPane.showInputDialog(null, "Origen de la encomienda: ");
                        String destino = JOptionPane.showInputDialog(null, "Destino de la encomienda: ");
                        int volume = Integer.parseInt(JOptionPane.showInputDialog(null, "Volumen de la encomienda: "));

                        encomendas encomiendas = new encomendas(nome, origem, destino, volume);
                        lista2.add(encomiendas);

                    }

                    break;
                case 1:
                    // Mostrar todos os dados em um unico JOptionPane
                    StringBuilder result = new StringBuilder("\nEncomiendas:\n");
                    for (int i = 0; i < lista2.size(); i++) {
                        result.append(" ").append(i + 1).append(" - ").append(lista2.get(i)).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, result.toString());

                    break;

                case 2:
                    //Creamos un Stack, nos sirve para llenarlo con el arraylist "encomendas"
                    Stack<Integer> caminhão = new Stack<Integer>();

                    int auxi = 0; // Inicializamos auxi fuera del bucle para acumular el volumen.

                    // El for recorre el ArrayList "lista2", toma el valor del volumen y lo compara si está dentro de los 25m²
                    for (int i = 0; i < lista2.size(); i++) {
                        auxi += lista2.get(i).getVolume(); // Acumula el volumen

                        if (auxi <= 25) {
                            caminhão.push(lista2.get(i).getVolume());
                        } else {
                            auxi -= lista2.get(i).getVolume(); // Resta el volumen que excedió los 25m²
                            break; // Sale del bucle porque ya no se pueden agregar más elementos
                        }
                    }

                    // Mostramos el mensaje después de acumular y verificar
                    if (auxi <= 25) {
                        JOptionPane.showMessageDialog(null, "Volumen dentro de los 25m²" + "\nVolumen acumulado: " + auxi + "m²");
                    } else {
                        JOptionPane.showMessageDialog(null, "Volumen superado los 25m²" + "\nVolumen acumulado: " + auxi + "m²");
                    }

                    JOptionPane.showMessageDialog(null, "Camión: " + caminhão);

                    break;
                case 3:
                    // Calcula o i­ndice do ultimo elemento
                    int index = lista2.size() - 1;

                    // Exclui o ultimo elemento passando o i­ndice
                    lista2.remove(index);

                    System.out.println("Lista Modificada: " + lista2);
                    // Mostrar todos os dados em um unico JOptionPane
                    StringBuilder listaMod = new StringBuilder("\nEncomiendas:\n");
                    for (int i = 0; i < lista2.size(); i++) {
                        listaMod.append(" ").append(i + 1).append(" - ").append(lista2.get(i)).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, listaMod.toString());

                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Exit");
                    break;

            }

        }

    }

}
