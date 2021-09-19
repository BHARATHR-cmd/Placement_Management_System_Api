package net.Placement_Manage_System.springboot.service;

import java.util.List;

import net.Placement_Manage_System.springboot.model.Certificate;

public interface CertificateService {
	Certificate saveCertificate(Certificate certificate);
	List<Certificate> getAllCertificates();
	Certificate getCertificateById(long id);
	Certificate updateCertificate(Certificate certificate, long id);
	void deleteCertificate(long id);
}
