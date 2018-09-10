package com.bkotharu.springvault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import com.bkotharu.springvault.dto.Credentials;

@Service
public class CredentialService {

	@Autowired
	private VaultTemplate vaultTemplate;

	public void storeCredentials(Credentials credentials, String path) {
		vaultTemplate.write(path, credentials);
	}

	public Credentials retrieveCredentials(String path) {
		VaultResponseSupport<Credentials> response = vaultTemplate.read(path, Credentials.class);
		return response.getData();
	}
}
