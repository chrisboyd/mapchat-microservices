package com.eureka.mapgroup.repository;

import com.eureka.mapgroup.entities.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	Page<Message> findByPostId(int mapGroupId, Pageable pageable);
    Optional<Message> findByIdAndPostId(int id, int mapGroupId);
}
