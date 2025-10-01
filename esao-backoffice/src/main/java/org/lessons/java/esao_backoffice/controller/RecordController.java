package org.lessons.java.esao_backoffice.controller;

import org.lessons.java.esao_backoffice.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/records")
public class RecordController {

  @Autowired
  private RecordRepository recordRepository;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("records", recordRepository.findAll());
    return "records/index";
  }

  @GetMapping("/{id}")
  public String show(@PathVariable Integer id, Model model) {
    model.addAttribute("record", recordRepository.findById(id).get());
    return "records/show";
  }
}
