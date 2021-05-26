package my.virkato.java.logging;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDemo {

    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.FINE, "Запущено с аргументами: {0}", Arrays.toString(args));

        try {
            randomlyFailingAlgorithm();
        } catch (IllegalStateException ise) {
            LOGGER.log(Level.SEVERE, "Получено исключение", ise);
            System.exit(2);
        }
        LOGGER.fine("Завершено успешно");
    }

    private static void randomlyFailingAlgorithm() {
        double randomNumder = Math.random();
        LOGGER.log(Level.FINE, "Сгенерировано случайное число: {0}", randomNumder);
        if (randomNumder < 0.5) {
            throw new IllegalStateException("Любое сообщение");
        }
    }
}
