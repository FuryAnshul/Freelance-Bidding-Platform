package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bid;
import com.example.demo.model.Project;
import com.example.demo.repositories.BidRepository;
import com.example.demo.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private BidRepository bidRepo;

	public Project createProject(Project p) {
		p.setStatus(Project.Status.OPEN);
		return projectRepo.save(p);
	}

	public List<Project> getByStatus(Project.Status status) {
		return projectRepo.findByStatus(status);
	}

	public void selectBid(Long projectId, Long bidId) {
		Project project = projectRepo.findById(projectId).orElseThrow();
		Bid bid = bidRepo.findById(bidId).orElseThrow();

		if (bidRepo.existsByProjectAndStatus(project, Bid.Status.ACCEPTED)) {
			throw new RuntimeException("Bid already selected");
		}

		bid.setStatus(Bid.Status.ACCEPTED);
		bidRepo.save(bid);

		for (Bid b : bidRepo.findByProject(project)) {
			if (!b.getBidId().equals(bidId)) {
				b.setStatus(Bid.Status.REJECTED);
				bidRepo.save(b);
			}
		}
		project.setStatus(Project.Status.IN_PROGRESS);
		projectRepo.save(project);
	}

	public void completeProject(Long projectId) {
		Project project = projectRepo.findById(projectId).orElseThrow();
		project.setStatus(Project.Status.COMPLETED);
		projectRepo.save(project);
	}
}