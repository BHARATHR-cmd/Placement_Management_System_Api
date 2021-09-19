package net.Placement_Manage_System.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.Placement_Manage_System.springboot.exception.ResourceNotFoundException;
import net.Placement_Manage_System.springboot.model.Placement;
import net.Placement_Manage_System.springboot.repository.PlacementRepository;
import net.Placement_Manage_System.springboot.service.PlacementService;

@Service
public class PlacementServiceImpl implements PlacementService{

	private PlacementRepository placementRepository;
	
	public PlacementServiceImpl(PlacementRepository placementRepository) {
		super();
		this.placementRepository = placementRepository;
	}

	@Override
	public Placement savePlacement(Placement placement) {
		return placementRepository.save(placement);
	}

	@Override
	public List<Placement> getAllPlacements() {
		return placementRepository.findAll();
	}

	@Override
	public Placement getPlacementById(long id) {
//		Optional<Placement> placement = placementRepository.findById(id);
//		if(placement.isPresent()) {
//			return placement.get();
//		}else {
//			throw new ResourceNotFoundException("Placement", "Id", id);
//		}
		return placementRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Placement", "Id", id));
		
	}

	@Override
	public Placement updatePlacement(Placement placement, long id) {
		
		// we need to check whether placement with given id is exist in DB or not
		Placement existingPlacement = placementRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Placement", "Id", id)); 
		
		existingPlacement.setName(placement.getName());
		existingPlacement.setCollege(placement.getCollege());
		existingPlacement.setDate(placement.getDate());
		existingPlacement.setQualification(placement.getQualification());
		existingPlacement.setYear(placement.getYear());
		
		// save existing placement to DB
		placementRepository.save(existingPlacement);
		return existingPlacement;
	}

	@Override
	public void deletePlacement(long id) {
		
		// check whether a placement exist in a DB or not
		placementRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Placement", "Id", id));
		placementRepository.deleteById(id);
	}
	
}
