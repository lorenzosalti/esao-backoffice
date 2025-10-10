package org.lessons.java.esao_backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.lessons.java.esao_backoffice.model.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {

}
