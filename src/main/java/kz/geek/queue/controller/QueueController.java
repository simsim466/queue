package kz.geek.queue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.geek.queue.service.QueueDispatcher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/queue")
public class QueueController {

    private final QueueDispatcher queueDispatcher;

    @Transactional
    @PostMapping("/generate")
    public ResponseEntity<String> generateCode() {
        log.info("__________Unique code generator has started operating__________");

        long startMoment = System.currentTimeMillis();
        String uniqueCode = queueDispatcher.generateCode();
        log.info(
                "__________The unique code <{}> has been generated in {} ms__________",
                uniqueCode,
                System.currentTimeMillis() - startMoment
        );

        return ResponseEntity.ok(uniqueCode);
    }

}
