package com.ordermanagement.backend.infrastructure.persistence.order;

import com.ordermanagement.backend.domain.modal.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJPARepository extends JpaRepository<Order, UUID> {
}
