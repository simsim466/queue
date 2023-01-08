package kz.geek.queue.service.generator;

import java.beans.BeanInfo;
import java.math.BigInteger;

import org.springframework.stereotype.Service;

import kz.geek.queue.model.CompositeNumber;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс генерации уникального кода
 */
@Service
@AllArgsConstructor
@Slf4j
public class NextValueGenerator {

    private final CodeDeserializer deserializer;
    private final CodeSerializer serializer;

    /**
     * Функция генерации уникального кода
     * @param currentCode начальное значение
     * @return новое сгенерированное значение
     */
    @NonNull
    public String perform(@NonNull final String currentCode) {
        BigInteger nextValue = deserializer.convert(currentCode);
        log.info("The current unique code value is converted to long number: <{}> -> <{}>", currentCode, nextValue);

        return serializer.convert(CompositeNumber.instanceOf(
                nextValue.add(BigInteger.ONE),
                NumericData.getNumeralSystem()
        ));
    }
}
