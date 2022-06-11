package me.allink.jetpointtemplate.endpoint;

public @interface EndpointRequest {

	HTTPMethod method() default HTTPMethod.GET;
}
