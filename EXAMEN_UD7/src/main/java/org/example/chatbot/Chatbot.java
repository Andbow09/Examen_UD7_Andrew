package org.example.chatbot;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> respuestas = new LinkedHashMap<>();
        respuestas.put("hola","Hola, ¿En qué te puedo ayudar?");
        respuestas.put("adios","¡Hasta luego!");
        respuestas.put("como estas","¡Estoy listo para ayudarte!");
        respuestas.put("gracias","De nada, ¡Que tengas un buen día!");
        respuestas.put("salir","¡Adiós!");

        System.out.println("Chatbot: Bienvenid@! Escribe <salir> cuando quieras acabar la conversación...");

        boolean salir = false;

        do {
            System.out.print("Tu: ");
            String respuesta = scanner.nextLine();

            for (Map.Entry<String, String> resp : respuestas.entrySet()) {
                if (resp.getKey().equalsIgnoreCase(respuesta)) {
                    System.out.println("Chatbot: " + resp.getValue());
                    break;
                } else if (resp.getKey().equalsIgnoreCase(respuesta) && respuesta.equalsIgnoreCase("salir")){
                    System.out.println("Chatbot: " + resp.getValue());
                    salir = true;
                } else {
                    System.out.println("Chatbot: no te entiendo :(");
                    break;
                }
            }
        } while (!salir);
    }
}
