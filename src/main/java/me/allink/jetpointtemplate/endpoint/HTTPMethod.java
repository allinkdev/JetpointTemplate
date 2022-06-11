package me.allink.jetpointtemplate.endpoint;

public enum HTTPMethod {
	GET("GET"),
	HEAD("HEAD"),
	POST("POST"),
	PUT("PUT"),
	DELETE("DELETE"),
	CONNECT("CONNECT"),
	OPTIONS("OPTIONS"),
	TRACE("TRACE"),
	PATCH("PATCH");

	public final String val;

	HTTPMethod(String val) {
		this.val = val;
	}


	@Override
	public String toString() {
		return val;
	}
}
