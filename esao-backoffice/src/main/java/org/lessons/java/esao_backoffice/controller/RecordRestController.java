package org.lessons.java.esao_backoffice.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.esao_backoffice.model.Record;
import org.lessons.java.esao_backoffice.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/records")
public class RecordRestController {

  @Autowired
  private RecordService recordService;

  @GetMapping
  public ResponseEntity<List<Record>> index() {
    List<Record> recordListAttempt = recordService.findAll();
    if (recordListAttempt.isEmpty()) {
      return new ResponseEntity<List<Record>>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<List<Record>>(recordListAttempt, HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Record>> search(@RequestParam String title) {
    List<Record> recordListAttempt = recordService.findByTitle(title);
    if (recordListAttempt.isEmpty()) {
      return new ResponseEntity<List<Record>>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<List<Record>>(recordListAttempt, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Record> show(@PathVariable Integer id) {
    Optional<Record> recordAttempt = recordService.findById(id);
    if (recordAttempt.isEmpty()) {
      return new ResponseEntity<Record>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Record>(recordAttempt.get(), HttpStatus.OK);
  }

}
