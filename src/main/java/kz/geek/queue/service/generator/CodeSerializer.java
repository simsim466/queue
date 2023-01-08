package kz.geek.queue.service.generator;

import java.math.BigInteger;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import kz.geek.queue.model.CompositeNumber;
import lombok.NonNull;

/**
 * Конвертация {@link CompositeNumber} в уникальный код
 */
@Service
class CodeSerializer implements Converter<CompositeNumber, String> {

    @Override
    @NonNull
    public String convert(@NonNull final CompositeNumber compositeNumber) {
        BigInteger result = compositeNumber.getWholePart();
        int remainder = compositeNumber.getRemainder();
        StringBuilder stringBuilder = new StringBuilder();
        if (result.compareTo(BigInteger.ZERO) > 0) {
            CompositeNumber followingCompositeNumber = CompositeNumber.instanceOf(result, NumericData.getNumeralSystem());
            stringBuilder.append(convert(followingCompositeNumber));
        }

        return stringBuilder
                .append(transformNumberToCharacter((remainder - 1) / NumericData.NUMBER_OF_DIGITS))
                .append(transformNumberToCodeNumber(remainder % NumericData.NUMBER_OF_DIGITS))
                .toString();
    }

    private char transformNumberToCharacter(final int number) {
        return (char) (number + NumericData.INITIAL_CHARACTER_CODE);
    }

    private int transformNumberToCodeNumber(final int initialNumber) {
        return (initialNumber + NumericData.NUMBER_OF_DIGITS - 1) % NumericData.NUMBER_OF_DIGITS;
    }
}
