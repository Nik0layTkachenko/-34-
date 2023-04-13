package task06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс EnterCommand реализует команду для ввода чисел в консоль
 */
public class EnterCommand implements ConsoleCommand {
    private ViewTable view;

    /**
     * Конструктор класса EnterCommand
     *
     * @param view объект класса ViewTable
     */
    public EnterCommand(ViewTable view) {
        this.view = view;
    }

    /**
     * Возвращает символ ключа команды
     *
     * @return символ ключа команды
     */
    @Override
    public char getKey() {
        return 'X';
    }

    /**
     * Возвращает строковое представление команды
     *
     * @return строковое представление команды
     */
    @Override
    public String toString() {
        return "(X)Enter";
    }

    /**
     * Выполняет команду
     */
    @Override
    public void execute() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Запрашиваем количество чисел, которые будут введены
        System.out.println("Enter an amount of numbers which you want to enter or type anything else if you want to enter 2 numbers");
        int size;
        try {
            size = Integer.parseInt(in.readLine());
        } catch (Exception e) {
            size = 2;
        }

        // Запрашиваем ввод чисел
        System.out.println("Enter your " + size + " numbers like this - +38 0xx xxx xx xx");
        String[] numbers = new String[size];
        for (int i = 0; i < size; i++) {
            try {
                numbers[i] = in.readLine();
            } catch (IOException e) {
                System.out.println("Error: " + e);
                System.exit(0);
            }
        }

        // Выводим результат
        System.out.print(view.viewInit(numbers));
    }
}
