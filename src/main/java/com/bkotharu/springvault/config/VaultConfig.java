package com.bkotharu.springvault.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

	@Value("${valult.uri}")
	private String uri;

	@Value("${valult.token}")
	private String token;

	public ClientAuthentication clientAuthentication() {
		return new TokenAuthentication(token);
	}

	public VaultEndpoint vaultEndpoint() {
		return VaultEndpoint.from(new URI(uri));
	}

}
