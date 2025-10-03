package org.lessons.java.esao_backoffice.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.esao_backoffice.model.Condition;
import org.lessons.java.esao_backoffice.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionService {

  @Autowired
  private ConditionRepository conditionRepository;

  public List<Condition> findAll() {
    return conditionRepository.findAll();
  }

  public Optional<Condition> findById(Integer id) {
    return conditionRepository.findById(id);
  }

  public Condition getById(Integer id) {
    Optional<Condition> conditionAttempt = conditionRepository.findById(id);
    return conditionAttempt.get();
  }

  public void create(Condition conditionToCreate) {
    conditionRepository.save(conditionToCreate);
  }

  public void edit(Condition conditionToEdit) {
    conditionRepository.save(conditionToEdit);
  }

  public void delete(Condition conditionToDelete) {
    conditionRepository.delete(conditionToDelete);
  }

  public void deleteById(Integer id) {
    Optional<Condition> conditionAttempt = conditionRepository.findById(id);
    conditionRepository.delete(conditionAttempt.get());
  }

}
