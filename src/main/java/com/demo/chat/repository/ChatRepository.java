package com.demo.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.chat.entity.PayloadEntity;

public interface ChatRepository extends JpaRepository<PayloadEntity, Long> {

}
