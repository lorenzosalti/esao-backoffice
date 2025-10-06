package org.lessons.java.esao_backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.lessons.java.esao_backoffice.model.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {

  public List<Record> findByTitleContaining(String title);

}
