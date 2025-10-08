package org.lessons.java.esao_backoffice.controller;

import java.util.List;

import org.lessons.java.esao_backoffice.model.Condition;
import org.lessons.java.esao_backoffice.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/conditions")
public class ConditionRestController {

  @Autowired
  private ConditionService conditionService;

  @GetMapping
  public ResponseEntity<List<Condition>> index() {
    List<Condition> conditionListAttempt = conditionService.findAll();
    if (conditionListAttempt.isEmpty()) {
      return new ResponseEntity<List<Condition>>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<List<Condition>>(conditionListAttempt, HttpStatus.OK);
  }
}
