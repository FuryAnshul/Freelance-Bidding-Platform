package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bid;
import com.example.demo.model.Project;
import com.example.demo.repositories.BidRepository;
import com.example.demo.repositories.ProjectRepository;

@Service
public class BidService {

	@Autowired
	private BidRepository bidRepo;
	@Autowired
	private ProjectRepository projectRepo;

	public Bid placeBid(Long projectId, Bid bid) {
		Project project = projectRepo.findById(projectId).orElseThrow();
		if (project.getStatus() != Project.Status.OPEN) {
			throw new RuntimeException("Project not open for bidding");
		}
		bid.setProject(project);
		return bidRepo.save(bid);
	}

	public List<Bid> getBids(Long projectId) {
		Project project = projectRepo.findById(projectId).orElseThrow();
		return bidRepo.findByProject(project);
	}
}