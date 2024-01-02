package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RandomCursorMoverApp {

    public static void main(String[] args) {
// Intervalo de tiempo en milisegundos (por ejemplo, 2000 ms = 2 segundos)
        int interval = 2000;

// Crear un objeto Timer para mover el cursor cada 'interval' milisegundos
        Timer timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCursorRandomly();
            }
        });

// Iniciar el Timer
        timer.start();

// Programar el cierre del programa después de 2 horas (7200000 ms)
        Timer exitTimer = new Timer(7200000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitTimer.setRepeats(false);
        exitTimer.start();

// Mantener el programa en ejecución
        JOptionPane.showMessageDialog(null, "Presione OK para detener el movimiento aleatorio del cursor.");
        timer.stop();
        exitTimer.stop();
    }

    private static void moveCursorRandomly() {
        try {
// Obtener la resolución de la pantalla
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

// Generar coordenadas aleatorias dentro de los límites de la pantallanull
            int randomX = (int) (Math.random() * screenSize.getWidth());
            int randomY = (int) (Math.random() * screenSize.getHeight());

// Mover el cursor a la posición aleatoria
            Robot robot = new Robot();
            robot.mouseMove(randomX, randomY);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}