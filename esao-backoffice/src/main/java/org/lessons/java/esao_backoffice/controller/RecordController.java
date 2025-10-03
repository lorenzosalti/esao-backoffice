package org.lessons.java.esao_backoffice.controller;

import org.lessons.java.esao_backoffice.model.Record;
import org.lessons.java.esao_backoffice.service.ConditionService;
import org.lessons.java.esao_backoffice.service.RecordService;
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
  private RecordService recordService;

  @Autowired
  private ConditionService conditionService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("records", recordService.findAll());
    return "records/index";
  }

  @GetMapping("/{id}")
  public String show(@PathVariable Integer id, Model model) {
    model.addAttribute("record", recordService.getById(id));
    return "records/show";
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("record", new Record());
    model.addAttribute("conditions", conditionService.findAll());
    return "records/create-edit";
  }

  @PostMapping("/create")
  public String store(@Valid @ModelAttribute("record") Record recordToStore, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      model.addAttribute("conditions", conditionService.findAll());
      return "records/create-edit";
    }

    recordService.create(recordToStore);
    return "redirect:/records";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    model.addAttribute("record", recordService.getById(id));
    model.addAttribute("conditions", conditionService.findAll());
    model.addAttribute("edit", true);
    return "records/create-edit";
  }

  @PostMapping("/edit/{id}")
  public String update(@Valid @ModelAttribute("record") Record recordToStore, BindingResult bindingResult,
      Model model) {

    if (bindingResult.hasErrors()) {
      model.addAttribute("conditions", conditionService.findAll());
      return "records/create-edit";
    }

    recordService.edit(recordToStore);
    return "redirect:/records";
  }

  @PostMapping("/delete/{id}")
  public String delete(@PathVariable Integer id) {
    recordService.deleteById(id);
    return "redirect:/records";
  }
}
