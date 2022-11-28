package com.easyjob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyjob.model.Easyjob;
import com.easyjob.service.EasyjobService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/easyjob/admin")

public class EasyjobController {
	
	@Autowired
	private EasyjobService easyjobservice;
	
	@PutMapping("/approve")
	public ResponseEntity<Easyjob> update(@RequestBody Easyjob easyjob)
	//public ResponseEntity<Easyjob> update(jobStatus=false)
	{
		return ResponseEntity.ok(easyjobservice.save(easyjob));
	}
	
	@DeleteMapping("/delete/{jobId}")
	public ResponseEntity<Easyjob> delete(@PathVariable Long jobId)
	{
		easyjobservice.findById(jobId).ifPresent(easyjobservice::delete);
		return ResponseEntity.ok().build();
	}

}
