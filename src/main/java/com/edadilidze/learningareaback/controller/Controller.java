package com.edadilidze.learningareaback.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("${service-method-path}")
public class Controller {

  private String message;

  @Autowired
  public Controller(@Value("${message:message}") String message) {
    this.message = message;
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getMessage() {
    return ResponseEntity.ok()
      .header("Access-Control-Allow-Origin", "*")
      .body(message);
  }
}
