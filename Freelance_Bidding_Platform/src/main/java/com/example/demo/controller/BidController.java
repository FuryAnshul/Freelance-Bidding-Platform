package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bid;
import com.example.demo.service.BidService;

@RestController
@RequestMapping("/api/projects/{pid}/bids")
public class BidController {
	@Autowired
	private BidService bidService;

	@PostMapping
	public Bid placeBid(@PathVariable Long pid, @RequestBody Bid bid) {
		return bidService.placeBid(pid, bid);
	}

	@GetMapping
	public List<Bid> getBids(@PathVariable Long pid) {
		return bidService.getBids(pid);
	}
}