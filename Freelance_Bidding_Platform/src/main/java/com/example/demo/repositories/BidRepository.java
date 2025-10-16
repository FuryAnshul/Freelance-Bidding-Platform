package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bid;
import com.example.demo.model.Project;

public interface BidRepository extends JpaRepository<Bid, Long> {
	List<Bid> findByProject(Project project);

	boolean existsByProjectAndStatus(Project project, Bid.Status status);
}