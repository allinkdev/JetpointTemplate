package me.allink.jetpointtemplate.endpoint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EndpointMetadata {

	String path();

	EndpointResponse response();

	EndpointRequest request() default @EndpointRequest;


}
