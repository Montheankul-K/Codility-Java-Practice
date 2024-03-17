package com.example.springbootinterview.healthCheck;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RestController
public class healthCheckController {

    public HealthCheckResponse getHealthCheckDetail(String format) throws Exception {
        if(Objects.equals(format, "full")) {
            Instant currentTimestamp = Instant.now();
            String formattedTimestamp = DateTimeFormatter.ISO_INSTANT.format(currentTimestamp);

            HealthCheckResponse healthCheckResponse = new HealthCheckResponse("OK", formattedTimestamp);
            return healthCheckResponse;
        } else if (format == null) {
            HealthCheckResponse healthCheckResponse = new HealthCheckResponse("OK", null);
            return healthCheckResponse;
        } else {
            throw new BadRequestException();
        }
    }

    @GetMapping("/healthcheck")
    @ResponseStatus(HttpStatus.OK)
    public HealthCheckResponse getHealthCheck(@RequestParam(name = "format", required = false) String format) throws Exception {
            return getHealthCheckDetail(format);
    }

    @PostMapping("/healthcheck")
    public ResponseEntity<String> postHealthCheck() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
    }

    @PutMapping("/healthcheck")
    public ResponseEntity<String> putHealthCheck() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
    }

    @DeleteMapping("/healthcheck")
    public ResponseEntity<String> deleteHealthCheck() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    record HealthCheckResponse(String status, String currentTime) {

        public String getStatus() {
            return status;
        }

        public String getCurrentTime() {
            return currentTime;
        }
    }
}
