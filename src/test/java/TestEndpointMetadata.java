import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import me.allink.jetpointtemplate.endpoint.EndpointMetadata;
import me.allink.jetpointtemplate.endpoint.IEndpoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

class TestEndpointMetadata {

	private static final Reflections REFLECTIONS = new Reflections("me.allink.jetpointtemplate.endpoint.impl");

	private List<EndpointMetadataContainer> getEndpoints() {
		final List<EndpointMetadataContainer> containers = new ArrayList<>();

		Set<Class<? extends IEndpoint>> endpoints = REFLECTIONS.getSubTypesOf(IEndpoint.class);

		for (Class<? extends IEndpoint> endpoint : endpoints) {
			EndpointMetadata metadata = endpoint.getDeclaredAnnotation(EndpointMetadata.class);

			try {
				containers.add(new EndpointMetadataContainer(endpoint.getConstructor().newInstance(), metadata));
			} catch (Exception e) {
				throw new IllegalStateException(
					String.format("Endpoint %s was unable to be instantiated", endpoint.getSimpleName()), e);
			}
		}

		return containers;
	}

	@Test
	@DisplayName("Endpoints should have EndpointMetadata")
	void endpointsGotMeta() {
		for (EndpointMetadataContainer endpoint : getEndpoints()) {
			Assertions.assertNotNull(endpoint.metadata);
		}
	}

	@Test
	@DisplayName("Endpoint header keys and values arrays should have equal lengths")
	void endpointHeaders() {
		for (EndpointMetadataContainer endpoint : getEndpoints()) {
			Assertions.assertEquals(endpoint.metadata.response().headers().keys().length,
				endpoint.metadata.response().headers().values().length);
		}
	}

	private record EndpointMetadataContainer(IEndpoint endpoint, EndpointMetadata metadata) {

	}

}
