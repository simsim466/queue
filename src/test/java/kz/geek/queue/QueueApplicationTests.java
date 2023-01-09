package kz.geek.queue;

import kz.geek.queue.service.generator.NextValueGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QueueApplicationTests {

    @Autowired
    private NextValueGenerator nextValueGenerator;

    @Test
    void last_value_in_first_rank_is_passed() {
        Assertions.assertEquals("a4b8a0", nextValueGenerator.perform("a4b7z9"));
    }

    @Test
    void last_value_in_second_rank_is_passed() {
        Assertions.assertEquals("k4m8a0", nextValueGenerator.perform("k4m7z9"));
    }

    @Test
    void last_value_in_second_rank_is_passed_and_third_rank_is_added() {
        Assertions.assertEquals("a0a0a0", nextValueGenerator.perform("z9z9"));
    }

    @Test
    void last_value_in_third_rank_is_passed() {
        Assertions.assertEquals("d0a0a0a0", nextValueGenerator.perform("c9z9z9z9"));
    }

    @Test
    void last_value_in_third_rank_is_passed_and_forth_rank_is_added() {
        Assertions.assertEquals("a0a0a0a0", nextValueGenerator.perform("z9z9z9"));
    }

    @Test
    void last_value_is_over_for_random_length_code() {
        Assertions.assertEquals(
                "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y6a0",
                nextValueGenerator.perform("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z9")
        );
    }

    @Test
    void each_rank_last_value_is_over_for_random_length_code() {
        Assertions.assertEquals(
                "a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a0",
                nextValueGenerator.perform("z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9z9")
        );
    }

}
