package com.easyjob.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyjob.model.Easyjob;

public interface EasyjobService extends JpaRepository<Easyjob,Long>{

}
