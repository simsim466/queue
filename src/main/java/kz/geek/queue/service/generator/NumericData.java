package kz.geek.queue.service.generator;

/**
 *  Значения параметров разряда вида XY; X - буква, Y - цифра
 */
class NumericData {

    /**
     * Количество символов, кодирующих цифровую часть разряда
     */
    static final int NUMBER_OF_DIGITS = 10;

    /**
     * Количество символов, кодирующих буквенную часть разряда
     */
    private static final int NUMBER_OF_LETTERS = 26;

    /**
     * Код первого символа системы счисления (латинская буква 'a')
     */
    static final int INITIAL_CHARACTER_CODE = 97;

    /**
     * Основание системы счисления
     */
    static int getNumeralSystem() {
        return NUMBER_OF_DIGITS * NUMBER_OF_LETTERS + 1;
    }
}
