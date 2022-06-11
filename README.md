[The Unlicense]: https://unlicense.org/

[Guide Document]: https://google.github.io/styleguide/javaguide.html

[IntelliJ Code Style XML File]: https://raw.githubusercontent.com/google/styleguide/gh-pages/intellij-java-google-style.xml

[human rights]: https://www.un.org/sites/un2.un.org/files/2021/03/udhr.pdf

# Jetpoint Template

An example of a simple wrapper I wrote for Jetty to serve endpoints. I've descided to call it "Jetpoint". Sounds cool,
right?

## Features

- Built on the fast Jetty library.
- Uses Reflections to load endpoints at run-time.
- Uses annotations for endpoint metadata for the supported HTTP method, response headers and Content-Type.

## Building

All you have to run to build it is:

```
mvn clean package
```

## Running

1. Copy the Jar file from the target/ directory.
2. Simply run `java -jar JetpointTemplate.jar` with a JRE of at-least 17, and enjoy!

## Contributing

### Rules

1. Your contributions must be formatted in the Google Java Code
   Style ([Guide Document], [IntelliJ Code Style XML File])
2. Your contributions must not violate, or lead to the violation of, any international/European law or [human rights].
3. Your contributions may not be "borrow" from any project with a license other than one as permissive or comparably
   permissive
   as
   the license this project is under, [The Unlicense].
4. Your contributions must be licensed under [The Unlicense].
5. Your contributions must follow common sense.