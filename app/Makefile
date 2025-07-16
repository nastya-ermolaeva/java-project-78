.PHONY: build

run-jshell:
	jshell --class-path build/classes/java/main imports.jsh

build:
	./gradlew clean build

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

report:
	./gradlew jacocoTestReport