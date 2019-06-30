package com.javalec.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {

	private Environment env;
	private String adminId;
	private String adminPw;
	
	public AdminConnection() {
		System.out.println("constructor was called!");
	}
	
	public void setEnv(Environment env) {
		this.env = env;
	}
	
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
	public String getAdminId() {
		return adminId;
	}
	
	public String getAdminPw() {
		return adminPw;
	}
	
	@Override
	public void setEnvironment(Environment env) {
		System.out.println("setEnvironment() method was called!");
		setEnv(env);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() method was called!");
		setAdminId(env.getProperty("admin.id"));
		setAdminPw(env.getProperty("admin.pw"));
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() method was called!");
	}

}
