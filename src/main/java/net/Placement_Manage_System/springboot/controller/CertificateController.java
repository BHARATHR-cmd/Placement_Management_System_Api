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

import net.Placement_Manage_System.springboot.model.Certificate;
import net.Placement_Manage_System.springboot.service.CertificateService;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {
	
	private CertificateService certificateService;

	public CertificateController(CertificateService certificateService) {
		super();
		this.certificateService = certificateService;
	}
	
	// build create certificate REST API
	@PostMapping()
	public ResponseEntity<Certificate> saveCertificate(@RequestBody Certificate certificate){
		return new ResponseEntity<Certificate>(certificateService.saveCertificate(certificate), HttpStatus.CREATED);
	}
	
	// build get all certificates REST API
	@GetMapping
	public List<Certificate> getAllCertificates(){
		return certificateService.getAllCertificates();
	}
	
	// build get certificate by id REST API
	// http://localhost:8080/api/certificates/1
	@GetMapping("{id}")
	public ResponseEntity<Certificate> getCertificateById(@PathVariable("id") long certificateId){
		return new ResponseEntity<Certificate>(certificateService.getCertificateById(certificateId), HttpStatus.OK);
	}
	
	// build update certificate REST API
	// http://localhost:8080/api/certificates/1
	@PutMapping("{id}")
	public ResponseEntity<Certificate> updateCertificate(@PathVariable("id") long id
												  ,@RequestBody Certificate certificate){
		return new ResponseEntity<Certificate>(certificateService.updateCertificate(certificate, id), HttpStatus.OK);
	}
	
	// build delete certificate REST API
	// http://localhost:8080/api/certificates/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCertificate(@PathVariable("id") long id){
		
		// delete certificate from DB
		certificateService.deleteCertificate(id);
		
		return new ResponseEntity<String>("Certificate deleted successfully!.", HttpStatus.OK);
	}
	
}
