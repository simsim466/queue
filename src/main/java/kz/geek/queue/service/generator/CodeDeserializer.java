package kz.geek.queue.service.generator;

import java.math.BigInteger;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import kz.geek.queue.model.CompositeNumber;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Конвертация уникального кода в {@link CompositeNumber}
 */
@Service
@Slf4j
class CodeDeserializer implements Converter<String, BigInteger> {

    @Override
    @NonNull
    public BigInteger convert(@NonNull final String code) {
        int length = code.length();
        BigInteger number = transformSingleCellToNumber(code.substring(length - 2));
        if (code.substring(0, length - 2).length() > 0) {
            number = convert(code.substring(0, length - 2))
                    .multiply(BigInteger.valueOf(NumericData.getNumeralSystem()))
                    .add(number);
        }

        return number;
    }

    /**
     * Перевод разряда в число
     * @param rank разряд
     */
    @NonNull
    private BigInteger transformSingleCellToNumber(@NonNull final String rank) {
        return BigInteger
                .valueOf((rank.charAt(0) - NumericData.INITIAL_CHARACTER_CODE) * NumericData.NUMBER_OF_DIGITS)
                .add(BigInteger.valueOf(Character.getNumericValue(rank.charAt(1)) + 1));
    }

}
