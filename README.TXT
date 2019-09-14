To Execute the program, run in a command line:

java -jar koa4-app\target\koa4-app-1.0-SNAPSHOT-jar-with-dependencies.jar

Implementation Notes
====================


URL Shortening service
----------------------

The requirements are to use TinyUrl service to do it. This could prove brittle if the service goes down. 
I wrote the service using Java SPI. It can then easily be extended to add more providers.
Once there is more than one provider implemented, one can also extend the current URLShortenerService to check if the service is available.
One can then write different strategies to return an available service when needed.

Caching
-------

A very simple implementation consists of a Map of strings. This is not very scalable when we start having millions of records.
I would look into JSR107 (https://jcp.org/aboutJava/communityprocess/implementations/jsr107/index.html)

Validating a URL
----------------

This was not a requirement per say, however it seems wasteful to send a url to a service when it is not a valid one. 
There are several ways to do that, I have written 3 implementations of it.
- regex way (RegexURLValidator)
- java.net (JavaNetURLValidator)
- using a third party library (apache commons)
Ultimately the shortening url service will decide which url it accepts, but we should not pass in obviously wrong URLs.


Environment
-----------

This was built with Eclipse IDE for Java Developers
Version: 2019-06 (4.12.0)
Build id: 20190614-1200

OS: Windows 10 Pro N version 1809
Java: Oracle Jdk 1.8.0_221

To package the whole application, one can run on the parent directy (koa4-parent)
mvn clean package

It was also tested on a CentOS 7 Linux server.