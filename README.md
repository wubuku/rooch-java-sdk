# Rooch Java SDK

This is a [Rooch]https://rooch.network) Java SDK. 

## How to use

### Maven

Add the following dependency to the project's `pom.xml` file.

```xml
<dependencies>
    <!-- ... -->
    <dependency>
        <groupId>com.github.wubuku</groupId>
        <artifactId>rooch-java-sdk</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    <!-- ... -->
</dependencies>

<repositories>
    <!-- ... -->
    <repository>
        <id>rooch-java-sdk-github</id>
        <name>rooch-java-sdk-bot</name>
        <url>https://maven.pkg.github.com/wubuku/rooch-java-sdk</url>
    </repository>
    <!-- ... -->
</repositories>
```

Add the following code to maven's `settings.xml` file.

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <!-- ... -->
    <servers>
        <!-- ... -->
        <server>
            <id>rooch-java-sdk-github</id>
            <username>rooch-java-sdk-bot</username>
            <password>&#103;hp_3WHxC5s37YYb3KO3Y3Sn7qMv1K2rCy28tWLk</password>
        </server>
        <!-- ... -->
    </servers>
    <!-- ... -->
</settings>
```

## Examples

### Encode then execute a transaction

```java
//...
```

### More examples

See unit tests in directory `src/test/java/com/github/wubuku/rooch`.
