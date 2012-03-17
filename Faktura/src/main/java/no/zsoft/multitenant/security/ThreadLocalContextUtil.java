package no.zsoft.multitenant.security;

import org.springframework.util.Assert;

public class ThreadLocalContextUtil {
	 private static final ThreadLocal<String> contextHolder =
	            new ThreadLocal<String>();
	 
	   public static void setTenantId(String tenantId) {
	      Assert.notNull(tenantId, "customerType cannot be null");
	      contextHolder.set(tenantId);
	   }
	 
	   public static String getTenantId() {
	      return (String) contextHolder.get();
	   }
	 
	   public static void clearTenant() {
	      contextHolder.remove();
	   }

}
