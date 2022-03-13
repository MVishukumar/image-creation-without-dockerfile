# Getting Started

## Build image 
### From Spring Boot's built-in plugin.
1. Configure `bootBuildImage` in `gradle.build`.
```
bootBuildImage {
	imageName = "${project.name}:${version}"
	/* Uncomment below part to publish created image to docker registry.
	publish = true
	docker {
		publishRegistry {
			username = "user"
			password = "secret"
			url = "https://docker.example.com/v1/"
			email = "user@example.com"
		}
	}*/
}
```
2. Create image.
```
./gradlew bootBuildImage
```
3. Run the image (specify image and tag name properly).
```
docker run --rm -p 8080:8080 image-creation-without-dockerfile:0.0.1-SNAPSHOT
```
4. Publish image.
```
./gradlew bootBuildImage --publishImage
```


### From Jib

1. Add `jib` plugin in `build.gradle`. 
```
id 'com.google.cloud.tools.jib' version '3.2.0'
```
2. Configure `jib` in `build.gradle`.
```
jib {
	from {
		image = "azul/zulu-openjdk:17-jre"
	}
	to {
		image = "${project.name}:${version}"
	}
}
```
3. Create image.
```
./gradlew jibDockerBuild
```
4. Run the image (specify image and tag name properly).
```
docker run --rm -p 8080:8080 image-creation-without-dockerfile:0.0.1-SNAPSHOT
```
5. Publish image.
```
./gradlew jib
```