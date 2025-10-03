package org.lessons.java.esao_backoffice.controller;

import org.lessons.java.esao_backoffice.model.Condition;
import org.lessons.java.esao_backoffice.service.ConditionService;
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
@RequestMapping("/conditions")
public class ConditionController {

  @Autowired
  private ConditionService conditionService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("conditions", conditionService.findAll());
    return "conditions/index";
  }

  @GetMapping("/{id}")
  public String show(@PathVariable Integer id, Model model) {
    model.addAttribute("condition", conditionService.getById(id));
    return "conditions/show";
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("condition", new Condition());
    return "conditions/create-edit";
  }

  @PostMapping("/create")
  public String store(@Valid @ModelAttribute Condition conditionToStore, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return "conditions/create-edit";
    }
    conditionService.create(conditionToStore);
    return "redirect:/conditions";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    model.addAttribute("condition", conditionService.getById(id));
    model.addAttribute("edit", true);
    return "conditions/create-edit";
  }

  @PostMapping("/edit/{id}")
  public String update(@Valid @ModelAttribute Condition conditionToUpdate, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return "conditions/create-edit";
    }
    conditionService.edit(conditionToUpdate);
    return "redirect:/conditions";
  }

  @PostMapping("/delete/{id}")
  public String delete(@PathVariable Integer id) {
    conditionService.deleteById(id);
    return "redirect:/conditions";
  }

}
