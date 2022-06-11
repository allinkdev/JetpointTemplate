package me.allink.jetpointtemplate.endpoint;

public @interface EndpointHeaders {

	String[] keys() default "";

	String[] values() default "";
}
