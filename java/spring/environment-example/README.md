# Example for externalized Spring configuration

First, build `.jar`

```bash
./gradlew build
```

Then run with internalized configuration file.

```
java -jar build/libs/environment-example-0.0.1-SNAPSHOT.jar
```

The output will look like following:

```
INFO 24212 --- [           main] uration$$EnhancerBySpringCGLIB$$694976cb : someValue: included
```

Next, add external configuration file and re-run:

```bash
cd build/libs
echo foo.bar=external> application.properties
java -jar environment-example-0.0.1-SNAPSHOT.jar
```

Since Spring [specifies the locations of property files](https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/html/boot-features-external-config.html#boot-features-external-config-application-property-files) as fowlloing, It is important to move into the directory where the `.jar` file is in.

* A /config subdirectory of the current directory
* The current directory
* A classpath /config package
* The classpath root

Now, we can see the extenralized configuration is applied:

```
INFO 24852 --- [           main] uration$$EnhancerBySpringCGLIB$$fa119404 : someValue: external
```
