package kz.geek.queue.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import kz.geek.queue.model.CompositeNumber;
import kz.geek.queue.model.GeneratedCode;
import kz.geek.queue.repository.GeneratedCodeRepository;
import kz.geek.queue.service.generator.NextValueGenerator;
import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * Диспетчер процессов: загрузка из БД, генерация нового значения, сохранение нового значения в БД
 */
@Service
@AllArgsConstructor
public class QueueDispatcher {

    private final GeneratedCodeRepository repository;
    private final NextValueGenerator nextValueGenerator;

    /**
     * @return сгенерированный уникальный код
     */
    @NonNull
    public String generateCode() {
        GeneratedCode generatedCode = repository.loadObviouslyPresented();
        String nextUniqueCode = nextValueGenerator.perform(generatedCode.getLatestUniqueGeneratedCode());

        return repository
                .update(new GeneratedCode(generatedCode.getId(), nextUniqueCode))
                .getLatestUniqueGeneratedCode();
    }
}
