# How to make batches from one collection

```java
// Example:
List<String> words = Stream.of("this", "is", "an", "example", "collection", "to", "prove", "that", "it", "will", "work").collect(toList());

List<List<String>> lists = CollectionUtils.makeBatch(words, 2);

// Will return:
// [[this, is], [an, example], [collection, to], [prove, that], [it, will], [work]]
```

You can use it in your own project with jitpack.io:

* add the jitpack repository to your pom/gradle file
* add the dependency:

```xml
	<dependency>
	    <groupId>com.github.JurrianFahner</groupId>
	    <artifactId>batch-collection</artifactId>
	    <version>1.0.0-RC1</version>
	</dependency>
```