package me.allink.jetpointtemplate.endpoint.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import me.allink.jetpointtemplate.endpoint.EndpointMetadata;
import me.allink.jetpointtemplate.endpoint.EndpointResponse;
import me.allink.jetpointtemplate.endpoint.IEndpoint;
import me.allink.jetpointtemplate.endpoint.MIMEType;

@EndpointMetadata(path = "/json", response = @EndpointResponse(contentType = MIMEType.JSON))
public class JSON implements IEndpoint {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.getWriter().write("{\"some_json\":\"here\"}");
	}
}
