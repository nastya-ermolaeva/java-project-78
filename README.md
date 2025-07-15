### Hexlet tests and linter status:
[![Actions Status](https://github.com/nastya-ermolaeva/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/nastya-ermolaeva/java-project-78/actions)
[![Java CI & SonarQube](https://github.com/nastya-ermolaeva/java-project-78/actions/workflows/build.yml/badge.svg)](https://github.com/nastya-ermolaeva/java-project-78/actions/workflows/build.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=nastya-ermolaeva_java-project-78&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=nastya-ermolaeva_java-project-78)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=nastya-ermolaeva_java-project-78&metric=bugs)](https://sonarcloud.io/summary/new_code?id=nastya-ermolaeva_java-project-78)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=nastya-ermolaeva_java-project-78&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=nastya-ermolaeva_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=nastya-ermolaeva_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=nastya-ermolaeva_java-project-78)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=nastya-ermolaeva_java-project-78&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=nastya-ermolaeva_java-project-78)

# Description
**Validator** is a library you can use to check if your data is correct — like strings, numbers, and maps.


For **strings**, you have methods like:

* _required()_ — makes sure the data is filled in. This means no null or empty strings allowed.
* _minLength()_ — makes sure the string is at least a certain length.
* _contains()_ — makes sure the string includes a specific substring.


For **numbers**, you have methods like:

* _required()_ — makes sure the number is not null.
* _positive()_ — makes sure the number is positive.
* _range()_ — makes sure the number falls within a certain range, including the edges.


For **maps**, you have methods like:

* _required()_ — makes sure the map isn’t null.
* _sizeof()_ — checks that the map has exactly a certain number of key-value pairs.
* _shape()_ — lets you define what each key in the map should look like by giving it its own validation rules. This way you can be really specific about what the map contains.

# Watch Demo
[![asciicast](https://asciinema.org/a/2Ean49RMhexDM3Ta03oqAbPtz.svg)](https://asciinema.org/a/2Ean49RMhexDM3Ta03oqAbPtz)