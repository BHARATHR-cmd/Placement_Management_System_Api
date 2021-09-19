package net.Placement_Manage_System.springboot.service;

import java.util.List;

import net.Placement_Manage_System.springboot.model.Placement;

public interface PlacementService {
	Placement savePlacement(Placement placement);
	List<Placement> getAllPlacements();
	Placement getPlacementById(long id);
	Placement updatePlacement(Placement placement, long id);
	void deletePlacement(long id);
}
