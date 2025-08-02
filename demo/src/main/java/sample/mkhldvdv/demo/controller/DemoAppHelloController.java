package sample.mkhldvdv.demo.controller;

import sample.mkhldvdv.demo.dto.DemoAppDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/hello")
public class DemoAppHelloController {

    @Value("${api.version}")
    public String apiVersion;

    @GetMapping
    public ResponseEntity<DemoAppDto> hello() {
        var helloWorld = new DemoAppDto("Hello World", apiVersion);
        log.info("/api/hello response: {}", helloWorld);
        return ResponseEntity.ok(helloWorld);
    }

}