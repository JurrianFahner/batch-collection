# How to make batches from one collection

```java
// Example:
List<String> words = Stream.of("this", "is", "an", "example", "collection", "to", "prove", "that", "it", "will", "work").collect(toList());

List<List<String>> lists = CollectionUtils.makeBatch(words, 2);

// Will return:
// [[this, is], [an, example], [collection, to], [prove, that], [it, will], [work]]
```

## which implmentations

There is a [java 7](https://github.com/JurrianFahner/batch-collection/tree/java7) implementation, in this implementation no streams are used. Version: `1.0.0-java7`.

There is a [java 8](https://github.com/JurrianFahner/batch-collection/tree/java8) implementation, in this implementation only a stream is used. Version: `1.0.0-java8`.

## how to use this library in your own project

You can use it in your own project with jitpack.io:

- add the jitpack repository to your pom/gradle file

```xml
  <repositories>
    <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
    </repository>
  </repositories>
```

- add the dependency:

```xml
	<dependency>
	    <groupId>com.github.JurrianFahner</groupId>
	    <artifactId>batch-collection</artifactId>
	    <version>1.0.0-java8</version>
	</dependency>
```
