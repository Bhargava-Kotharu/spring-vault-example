package com.bkotharu.springvault.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bkotharu.springvault.dto.Credentials;
import com.bkotharu.springvault.service.CredentialService;

@RestController
@RequestMapping("/credentials")
public class Controller {

	@Autowired
	private CredentialService service;

	@PostMapping("/{path}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void saveCredentials(@RequestBody Credentials credentials, @PathVariable String path) {
		service.storeCredentials(credentials, path);
	}

	@GetMapping("/{path}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Credentials getCredentials(@PathVariable String path) {
		return service.retrieveCredentials(path);
	}

}
