package com.sony.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

//http://localhost:8080/RESTLogin/rest/login/dologin
@Path("/login")
public class MessageRestService {

	@GET
	@Path("/dologin")
	public Response doLogin(@QueryParam("p1") String encodedUserName, @QueryParam("p2") String encodedPassword) {
		boolean isAuthenticated = false;
		
		
		try {
			encodedUserName=URLDecoder.decode(encodedUserName,"UTF-8");
			encodedPassword=URLDecoder.decode(encodedPassword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] userNameBytes = Base64.decodeBase64(encodedUserName.getBytes());
		byte[] passwordBytes = Base64.decodeBase64(encodedPassword.getBytes());

		String userName = new String(userNameBytes);
		String password = new String(passwordBytes);

		String result = "User Name : " + userName + "--> Password : " + password;
		if (StringUtils.isNotBlank(userName)) {
			isAuthenticated = LDAPAuthentication.doLogin(userName, password);
		}
		if (isAuthenticated) {
			return Response.status(200).entity(result + " = " + isAuthenticated).build();
		} else {
			return Response.status(400).entity(result + " = " + isAuthenticated).build();
		}
	}

}