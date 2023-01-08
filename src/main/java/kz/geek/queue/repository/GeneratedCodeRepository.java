package kz.geek.queue.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kz.geek.queue.model.GeneratedCode;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class GeneratedCodeRepository {

    private final JpaGeneratedCodeRepository jpaGeneratedCodeRepository;

    /**
     * Обновление записи в БД c целью сохранения нового сгенерированного значения
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public GeneratedCode update(@NonNull final GeneratedCode generatedCode) {
        log.info("The unique code has been saved in database: {}", generatedCode.getLatestUniqueGeneratedCode());

        return jpaGeneratedCodeRepository.save(generatedCode);
    }

    /**
     * Загрузка заведомо имеющейся сущности с последним сгенерированным уникальным кодом.
     * Согласно бизнес-логике, она должна присутствовать в таблице в единственном экземпляре.
     */
    @NonNull
    public GeneratedCode loadObviouslyPresented() {
        return jpaGeneratedCodeRepository.findById(-1);
    }

}
