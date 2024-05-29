package com.JO.JOProject.repositories;

import com.JO.JOProject.domain.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<EventEntity, Long> {
}
