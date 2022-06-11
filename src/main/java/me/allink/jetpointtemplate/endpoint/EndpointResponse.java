package me.allink.jetpointtemplate.endpoint;

public @interface EndpointResponse {

	MIMEType contentType();

	EndpointHeaders headers() default @EndpointHeaders;
}
