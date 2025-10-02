package org.lessons.java.esao_backoffice.controller;

import org.lessons.java.esao_backoffice.model.Record;
import org.lessons.java.esao_backoffice.repository.ConditionRepository;
import org.lessons.java.esao_backoffice.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/records")
public class RecordController {

  @Autowired
  private RecordRepository recordRepository;

  @Autowired
  private ConditionRepository conditionRepository;

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

  @GetMapping("/create")
  public String create(Model model) {
    Record record = new Record();
    model.addAttribute("record", record);
    model.addAttribute("conditions", conditionRepository.findAll());
    return "records/create-edit";
  }

  @PostMapping("/create")
  public String store(@Valid @ModelAttribute("record") Record recordToStore, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      model.addAttribute("conditions", conditionRepository.findAll());
      return "records/create-edit";
    }

    recordRepository.save(recordToStore);
    return "redirect:/records";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    model.addAttribute("record", recordRepository.findById(id).get());
    model.addAttribute("conditions", conditionRepository.findAll());
    model.addAttribute("edit", true);
    return "records/create-edit";
  }

  @PostMapping("/edit/{id}")
  public String update(@Valid @ModelAttribute("record") Record recordToStore, BindingResult bindingResult,
      Model model) {

    if (bindingResult.hasErrors()) {
      model.addAttribute("conditions", conditionRepository.findAll());
      return "records/create-edit";
    }

    recordRepository.save(recordToStore);
    return "redirect:/records";
  }
}
