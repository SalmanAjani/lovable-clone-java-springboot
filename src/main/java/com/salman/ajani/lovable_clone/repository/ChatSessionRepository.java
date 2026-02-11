package com.salman.ajani.lovable_clone.repository;

import com.salman.ajani.lovable_clone.entity.ChatSession;
import com.salman.ajani.lovable_clone.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}