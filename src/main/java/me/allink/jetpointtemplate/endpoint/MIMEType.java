package me.allink.jetpointtemplate.endpoint;

public enum MIMEType {
	TXT("text/plain"),
	JSON("application/json"),
	JSONLD("application/ld+json"),
	HTML("text/html"),
	AAC("audio/acc"),
	ABW("application/x-abiword"),
	ARC("application/x-freearc"),
	AVIF("image/avif"),
	AVI("video/x-msvideo"),
	AZW("application/vnd.amazon.ebook"),
	BIN("application/octet-stream"),
	BMP("image/bmp"),
	BZ("application/x-bzip"),
	BZ2("application/x-bzip2"),
	CDA("application/x-cdf"),
	CSH("application/x-csh"),
	CSS("text/css"),
	CSV("text/csv"),
	DOC("application/msword"),
	DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
	EOT("application/vnd.ms-fontobject"),
	EBOOK("application/epub+zip"),
	GZIP("application/gzip"),
	GIF("image/gif"),
	ICO("image/vnd.microsoft.icon"),
	ICS("text/calendar"),
	JAR("application/java-archive"), // that's me!
	JPEG("image/jpeg"),
	JS("text/javascript"),
	MP3("audio/mpeg"),
	MP4("video/mp4"),
	MPEG("video/mpeg"),
	MPKG("application/vnd.apple.installer+xml"),
	ODP("application/vnd.oasis.opendocument.presentation"),
	ODS("application/vnd.oasis.opendocument.spreadsheet"),
	ODT("application/vnd.oasis.opendocument.text"),
	OGG("audio/ogg"),
	OGV("video/ogg"),
	OGX("application/ogg"),
	OPUS("audio/opus"),
	OTF("font/otf"),
	PNG("image/png"),
	PDF("application/pdf"),
	PHP("application/x-httpd-php"),
	PPT("application/vnd.ms-powerpoint"),
	PPTX("application/vnd.openxmlformats-officedocument.presentationml.presentation"),
	RAR("application/vnd.rar"),
	RTF("application/rtf"),
	SH("application/x-sh"),
	SVG("image/svg+xml"),
	SWF("application/x-shockwave-flash"),
	TAR("application/x-tar"),
	TIFF("image/tiff"),
	TS("video/mp2t"),
	TTF("font/ttf"),
	VSD("application/vnd.visio"),
	WAV("audio/wav"),
	WEBA("audio/webm"),
	WEBM("video/webm"),
	WEBP("image/webp"),
	WOFF("font/woff"),
	WOFF2("font/woff2"),
	XHTML("application/xhtml+xml"),
	XLS("application/vnd.ms-excel"),
	XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
	XML("application/xml"),
	XUL("application/vnd.mozilla.xul+xml"),
	ZIP("application/zip"),
	THREEGPP_VID("video/3gpp"),
	THREEGPP2_VID("video/3gpp2"),
	THREEGPP_AUD("audio/3gpp"),
	THREEGPP2_AUD("audio/3ggp2"),
	SEVENZIP("application/x-7z-compressed");

	public final String val;

	MIMEType(String val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return val;
	}
}
