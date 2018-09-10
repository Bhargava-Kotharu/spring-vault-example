package com.bkotharu.springvault.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultTemplate;

@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

	@Value("${valult.host}")
	private String host;

	@Value("${valult.port}")
	private int port;

	@Value("${valult.token}")
	private String token;

	@Bean
	public ClientAuthentication clientAuthentication() {
		return new TokenAuthentication(token);
	}

	@Bean
	public VaultEndpoint vaultEndpoint() {
		return VaultEndpoint.create(host, port);
	}

	@Bean
	public VaultTemplate vaultTemplate() {
		VaultTemplate vaultTemplate = new VaultTemplate(vaultEndpoint(), clientAuthentication());
		return vaultTemplate;
	}

}
