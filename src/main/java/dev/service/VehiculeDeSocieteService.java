package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.VehiculeDeSociete;
import dev.repository.VehiculeDeSocieteRepo;

@Service
@Transactional
public class VehiculeDeSocieteService {
	
	private VehiculeDeSocieteRepo vehiculeDeSocieteRepo;
	
	public VehiculeDeSocieteService(VehiculeDeSocieteRepo vehiculeDeSocieteRepo) {
		super();
		this.vehiculeDeSocieteRepo = vehiculeDeSocieteRepo;
	}


	public List<VehiculeDeSociete> listerVehiculeDeSociete() {

		return this.vehiculeDeSocieteRepo.findAll();
	}

}
