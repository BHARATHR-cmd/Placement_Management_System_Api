package net.Placement_Manage_System.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.Placement_Manage_System.springboot.model.Placement;
import net.Placement_Manage_System.springboot.service.PlacementService;

@RestController
@RequestMapping("/api/placements")
public class PlacementController {
	
	private PlacementService placementService;

	public PlacementController(PlacementService placementService) {
		super();
		this.placementService = placementService;
	}
	
	// build create placement REST API
	@PostMapping()
	public ResponseEntity<Placement> savePlacement(@RequestBody Placement placement){
		return new ResponseEntity<Placement>(placementService.savePlacement(placement), HttpStatus.CREATED);
	}
	
	// build get all placements REST API
	@GetMapping
	public List<Placement> getAllPlacements(){
		return placementService.getAllPlacements();
	}
	
	// build get placement by id REST API
	// http://localhost:8080/api/placements/1
	@GetMapping("{id}")
	public ResponseEntity<Placement> getPlacementById(@PathVariable("id") long placementId){
		return new ResponseEntity<Placement>(placementService.getPlacementById(placementId), HttpStatus.OK);
	}
	
	// build update placement REST API
	// http://localhost:8080/api/placements/1
	@PutMapping("{id}")
	public ResponseEntity<Placement> updatePlacement(@PathVariable("id") long id
												  ,@RequestBody Placement placement){
		return new ResponseEntity<Placement>(placementService.updatePlacement(placement, id), HttpStatus.OK);
	}
	
	// build delete placement REST API
	// http://localhost:8080/api/placements/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePlacement(@PathVariable("id") long id){
		
		// delete placement from DB
		placementService.deletePlacement(id);
		
		return new ResponseEntity<String>("Placement deleted successfully!.", HttpStatus.OK);
	}
	
}
