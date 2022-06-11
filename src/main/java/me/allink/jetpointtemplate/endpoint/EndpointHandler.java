package me.allink.jetpointtemplate.endpoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import me.allink.jetpointtemplate.Main;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndpointHandler extends AbstractHandler {

	private final List<IEndpoint> endpoints = new ArrayList<>();
	private final Map<String, IEndpoint> pathToEndpoint = new HashMap<>();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public EndpointHandler() {
		final Reflections reflections = new Reflections("me.allink.jetpointtemplate.endpoint.impl");
		final Set<Class<? extends IEndpoint>> endpoints = reflections.getSubTypesOf(IEndpoint.class);

		for (Class<? extends IEndpoint> endpoint : endpoints) {
			try {
				IEndpoint createdEndpoint = endpoint.getConstructor().newInstance();
				this.endpoints.add(createdEndpoint);
			} catch (Exception e) {
				throw new IllegalStateException(
					String.format("Endpoint %s was unable to be loaded.", endpoint.getSimpleName()), e);
			}
		}

		this.computeEndpointToPathMap();
	}

	private EndpointMetadata getMetadataFor(IEndpoint endpoint) throws IllegalStateException {
		final Class<?> clazz = endpoint.getClass();
		final EndpointMetadata metadata = clazz.getDeclaredAnnotation(EndpointMetadata.class);

		if (metadata == null) {
			throw new IllegalStateException(
				String.format("Endpoint %s does not have any metadata!", endpoint.getClass().getSimpleName()));
		}

		return metadata;
	}

	private void computeEndpointToPathMap() {
		for (IEndpoint endpoint : endpoints) {
			final EndpointMetadata metadata = getMetadataFor(endpoint);

			pathToEndpoint.put(metadata.path(), endpoint);
		}
	}

	private IEndpoint getEndpointForPath(String path) {
		return pathToEndpoint.get(path);
	}

	@Override
	public void handle(String path, Request request, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) throws IOException, ServletException {
		logger.info("Receiving request from \"{}\" (ua: \"{}\") to access the path \"{}\"!", request.getRemoteAddr(),
			Main.clean(request.getHeader("User-Agent")), Main.clean(path));

		final IEndpoint endpoint = getEndpointForPath(path);

		if (endpoint == null) {
			httpServletResponse.setStatus(404);
			request.setHandled(true);
			return;
		}

		final EndpointMetadata metadata = getMetadataFor(endpoint);
		final EndpointRequest endpointRequest = metadata.request();
		final EndpointResponse endpointResponse = metadata.response();

		if (!Objects.equals(endpointRequest.method().toString(), httpServletRequest.getMethod())) {
			httpServletResponse.setStatus(405);
			request.setHandled(true);
			return;
		}

		httpServletResponse.setHeader("Content-Type", metadata.response().contentType().toString());

		final String[] keys = endpointResponse.headers().keys();
		final String[] values = endpointResponse.headers().values();

		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			String value = values[i];

			if (key.isEmpty() || value.isEmpty()) {
				break;
			}

			httpServletResponse.setHeader(key, value);
		}

		endpoint.handle(httpServletRequest, httpServletResponse);
		request.setHandled(true);
	}
}
