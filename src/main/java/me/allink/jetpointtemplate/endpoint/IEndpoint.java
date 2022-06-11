package me.allink.jetpointtemplate.endpoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IEndpoint {

	void handle(HttpServletRequest request,
		HttpServletResponse response) throws IOException, ServletException;
}
