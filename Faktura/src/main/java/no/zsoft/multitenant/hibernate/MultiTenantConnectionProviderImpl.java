package no.zsoft.multitenant.hibernate;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.service.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MultiTenantConnectionProviderImpl extends
		AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	Map<String, DataSource> map;
	
	public MultiTenantConnectionProviderImpl() {
		map = new HashMap<String, DataSource>();

		DataSource dataSource1=new DriverManagerDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost/mehdi?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8","root","");
		map.put("mehdi", dataSource1);
		
		DataSource dataSource2=new DriverManagerDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost/ims?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8","root","");
		map.put("arash", dataSource2);
	}

	@Override
	protected DataSource selectAnyDataSource() {

		return map.get("mehdi");
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		System.err.println("tenantIdentifier************"+tenantIdentifier);
		return map.get(tenantIdentifier);
	}

	public void setMap(Map<String, DataSource> map) {
		this.map = map;
	}

}
