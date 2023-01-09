package kz.geek.queue.model;

import java.math.BigInteger;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * Составное число
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CompositeNumber {

    /**
     * целая часть частного от деления сохраняемого числа на основание системы счисления
     */
    @NonNull
    private final BigInteger wholePart;

    /**
     * остаток от деления сохраняемого числа на основание системы счисления; не может быть равным нулю
     */
    final int remainder;

    /**
     * Статический конструктор.
     * В случае, если сохраняемое число кратно разрядности, перед сохранением оно будет увеличено на единицу.
     * @param number сохраняемое число
     * @param numeralSystem основание система счисления
     */
    @NonNull
    public static CompositeNumber instanceOf(@NonNull final BigInteger number, final int numeralSystem) {
        int remainder = number.remainder(BigInteger.valueOf(numeralSystem)).intValue();
        if (remainder == 0) {
            remainder++;
        }

        return new CompositeNumber(number.divide(BigInteger.valueOf(numeralSystem)), remainder);
    }
}
