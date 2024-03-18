package com.example.springbootinterview.healthCheck;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

@RestController
class HealthcheckController {
    public HealthCheckResponse getHealthCheckDetail(String format) throws Exception {
        try {
            if ("full".equals(format)) {
                Instant currentTimestamp = Instant.now();
                String formattedTimestamp = DateTimeFormatter.ISO_INSTANT.format(currentTimestamp);

                return new HealthCheckResponse("OK", formattedTimestamp);
            } else if ("short".equals(format)) {
                return new HealthCheckResponse("OK", null);
            } else {
                throw new BadRequestException("Bad Request");
            }
        } catch (Exception error) {
            throw new BadRequestException("Bad Request", error);
        }
    }

    @GetMapping(value = "/healthcheck")
    @ResponseStatus(HttpStatus.OK)
    public HealthCheckResponse healthcheck(@RequestParam(name = "format") String format) throws Exception {
        return getHealthCheckDetail(format);
    }

    @PutMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheckPut() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
    }

    @PostMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheckPost() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
    }


    @DeleteMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheckDelete() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class HealthCheckResponse {
        private String status;
        private String currentTime;

        public HealthCheckResponse(String status, String currentTime) {
            this.status = status;
            this.currentTime = currentTime;
        }

        public String getStatus() {
            return status;
        }

        public String getCurrentTime() {
            return currentTime;
        }
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public class BadRequestException extends RuntimeException {
        public BadRequestException(String message, Throwable cause) {
            super(message, cause);
        }

        public BadRequestException(String message) {
            super(message);
        }
    }
}
