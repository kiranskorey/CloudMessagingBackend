package com.sony.rest;


import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class LDAPAuthentication {

	
	private static final Logger LOG = Logger.getLogger(LDAPAuthentication.class);
	
	/*public static boolean doLogin(String user, String pass){
		boolean success = false;
		if(StringUtils.isNotBlank(pass)){
    	Hashtable<String, String> authEnv = new Hashtable<String, String>(11);
    	//SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    	//String ldapURL = "ldap://146.215.36.20:389";
//    	String ldapURL = "ldap://43.88.62.92:389";server was down due to hardware crash
    	String ldapURL = "ldap://43.88.67.72:389";
 
    	authEnv.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
   		authEnv.put(Context.PROVIDER_URL, ldapURL);
   		authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
   		authEnv.put(Context.SECURITY_PRINCIPAL, user);
   		authEnv.put(Context.SECURITY_CREDENTIALS, pass);
 
    	try {
    		new InitialDirContext(authEnv);
    		LOG.info("Authentication Success!");
    		success = true;
    	} catch (AuthenticationException authEx) {
    		LOG.error("Authentication failed!");
    		authEx.printStackTrace();
    	} catch (NamingException namEx) {
    		LOG.error("Something went wrong!");
    		namEx.printStackTrace();
    	}
		}
    	return success;
    }
*/
	public static boolean doLogin(String user, String pass){
		LOG.info("user "+user+" tried to Login");
		boolean success = false;
		if(StringUtils.isNotBlank(pass)){
    	if(user.equals("kiran")&& pass.equals("korey"))
    	success=true;
    }
		return success;
}}
