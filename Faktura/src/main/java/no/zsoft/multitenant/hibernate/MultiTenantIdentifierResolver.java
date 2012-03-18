package no.zsoft.multitenant.hibernate;

import no.zsoft.multitenant.security.ThreadLocalContextUtil;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class MultiTenantIdentifierResolver implements CurrentTenantIdentifierResolver{

	@Override
	public String resolveCurrentTenantIdentifier() {
		return ThreadLocalContextUtil.getTenantId();
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}
