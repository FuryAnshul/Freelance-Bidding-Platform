package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@PostMapping
	public Project create(@RequestBody Project project) {
		return projectService.createProject(project);
	}

	@GetMapping
	public List<Project> get(@RequestParam String status) {
		return projectService.getByStatus(Project.Status.valueOf(status));
	}

	@PostMapping("/{pid}/select-bid/{bidId}")
	public String selectBid(@PathVariable Long pid, @PathVariable Long bidId) {
		projectService.selectBid(pid, bidId);
		return "Bid Selected";
	}

	@PostMapping("/{pid}/complete")
	public String complete(@PathVariable Long pid) {
		projectService.completeProject(pid);
		return "Project Completed";
	}
}