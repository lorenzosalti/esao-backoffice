package org.lessons.java.esao_backoffice.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.esao_backoffice.model.Record;
import org.lessons.java.esao_backoffice.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

  @Autowired
  private RecordRepository recordRepository;

  public List<Record> findAll() {
    return recordRepository.findAll();
  }

  public List<Record> findByTitle(String title) {
    return recordRepository.findByTitleContaining(title);
  }

  public Optional<Record> findById(Integer id) {
    return recordRepository.findById(id);
  }

  public Record getById(Integer id) {
    Optional<Record> recordAttempt = recordRepository.findById(id);
    return recordAttempt.get();
  }

  public void create(Record recordToCreate) {
    recordRepository.save(recordToCreate);
  }

  public void edit(Record recordToEdit) {
    recordRepository.save(recordToEdit);
  }

  public void delete(Record recordToDelete) {
    recordRepository.delete(recordToDelete);
  }

  public void deleteById(Integer id) {
    Optional<Record> recordAttempt = recordRepository.findById(id);
    recordRepository.delete(recordAttempt.get());
  }

}
