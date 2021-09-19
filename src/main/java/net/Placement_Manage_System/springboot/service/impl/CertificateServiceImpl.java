package net.Placement_Manage_System.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.Placement_Manage_System.springboot.exception.ResourceNotFoundException;
import net.Placement_Manage_System.springboot.model.Certificate;
import net.Placement_Manage_System.springboot.repository.CertificateRepository;
import net.Placement_Manage_System.springboot.service.CertificateService;

@Service
public class CertificateServiceImpl implements CertificateService{

	private CertificateRepository certificateRepository;
	
	public CertificateServiceImpl(CertificateRepository certificateRepository) {
		super();
		this.certificateRepository = certificateRepository;
	}

	@Override
	public Certificate saveCertificate(Certificate certificate) {
		return certificateRepository.save(certificate);
	}

	@Override
	public List<Certificate> getAllCertificates() {
		return certificateRepository.findAll();
	}

	@Override
	public Certificate getCertificateById(long id) {
//		Optional<Certificate> certificate = certificateRepository.findById(id);
//		if(certificate.isPresent()) {
//			return certificate.get();
//		}else {
//			throw new ResourceNotFoundException("Certificate", "Id", id);
//		}
		return certificateRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Certificate", "Id", id));
		
	}

	@Override
	public Certificate updateCertificate(Certificate certificate, long id) {
		
		// we need to check whether certificate with given id is exist in DB or not
		Certificate existingCertificate = certificateRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Certificate", "Id", id)); 
		
		existingCertificate.setYear(certificate.getYear());
		existingCertificate.setCollege(certificate.getCollege());
		
		
		
		// save existing certificate to DB
		certificateRepository.save(existingCertificate);
		return existingCertificate;
	}

	@Override
	public void deleteCertificate(long id) {
		
		// check whether a certificate exist in a DB or not
		certificateRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Certificate", "Id", id));
		certificateRepository.deleteById(id);
	}
	
}
