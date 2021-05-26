package my.virkato.java.logging;

import java.util.logging.*;

public class MyLogger {

    public static void main(String[] args) {
        configureLogging();
    }

    /** Настраиваем логгер программно
     * Логгер с именем "my.virkato.java.logging.ClassA" принимал сообщения всех уровней.
     * Логгер с именем "my.virkato.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
     * Все сообщения, пришедшие от нижестоящих логгеров на уровень "my.virkato.java", независимо
     * от серьезности сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим
     * обработчикам на уровнях "my.virkato", "my" и "".
     *
     * (*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл.
     * Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так. (Stepik)
     *
     * Подсказки:
     * Level есть не только у Logger, но и у Handler.
     * Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.
     */
    private static void configureLogging() {
        Logger loggerA = Logger.getLogger(ClassA.class.getName());
        loggerA.setLevel(Level.ALL);

        Logger loggerB = Logger.getLogger(ClassB.class.getName());
        loggerB.setLevel(Level.WARNING);

        Logger loggerM = Logger.getLogger("my.virkato.java");
        loggerM.setLevel(Level.ALL);

        Formatter formatterM = new XMLFormatter();
        Handler handlerM = new ConsoleHandler();

        handlerM.setFormatter(formatterM);
        handlerM.setLevel(Level.ALL);
        loggerM.addHandler(handlerM);
        loggerM.setUseParentHandlers(false);
    }
}
