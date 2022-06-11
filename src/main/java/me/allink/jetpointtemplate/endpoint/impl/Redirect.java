package me.allink.jetpointtemplate.endpoint.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import me.allink.jetpointtemplate.endpoint.EndpointHeaders;
import me.allink.jetpointtemplate.endpoint.EndpointMetadata;
import me.allink.jetpointtemplate.endpoint.EndpointResponse;
import me.allink.jetpointtemplate.endpoint.IEndpoint;
import me.allink.jetpointtemplate.endpoint.MIMEType;

@EndpointMetadata(path = "/redirect", response = @EndpointResponse(contentType = MIMEType.TXT, headers = @EndpointHeaders(keys = "Location", values = "https://www.google.com")))
public class Redirect implements IEndpoint {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		response.setStatus(301);
	}
}
