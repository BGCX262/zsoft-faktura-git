package no.zsoft.multitenant.hibernate;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class MultiTenantIdentifierResolver implements CurrentTenantIdentifierResolver{

	@Override
	public String resolveCurrentTenantIdentifier() {
		return "";
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return false;
	}

}
