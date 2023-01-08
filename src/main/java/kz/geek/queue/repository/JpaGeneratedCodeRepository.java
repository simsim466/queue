package kz.geek.queue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.geek.queue.model.GeneratedCode;
import lombok.NonNull;

interface JpaGeneratedCodeRepository extends JpaRepository<GeneratedCode, Integer> {

    @NonNull
    GeneratedCode findById(int id);
}
