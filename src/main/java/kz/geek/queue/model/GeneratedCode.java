package kz.geek.queue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Сущность для хранения последнего значения уникального сгенерированного кода
 */
@Entity
@Table(name = "generated_codes", schema = "geek_partners")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class GeneratedCode {

    /**
     * Идентификатор
     */
    @Id
    @NonNull
    private Integer id;

    /**
     * Последнее (крайнее) значение сгенерированного уникального кода
     */
    @NonNull
    private String latestUniqueGeneratedCode;

}
