# Spring Cloud Stream with Solace demo
This demo publish a message to the topic "spring/cloud/stream" each 5000 milliseconds, and two consumers will consume them from a non-exclusive queue.

## Reference
The demo has been developed following these two trainings:
- [Spring Cloud Stream Basics](https://codelabs.solace.dev/codelabs/spring-cloud-stream-basics)
- [Spring Cloud Stream - Beyond the Basics](https://codelabs.solace.dev/codelabs/spring-cloud-stream-beyond)

## Pre-requisites
### Trustore
This example is using SMF with TLS, which means you need a truststore with the broker certificate:<br/>
Truststore holds onto certificates that identify others =&gt; To generate a Solace broker’s server certificate you can use the command:
```
keytool -importcert -file <BROKER_NAME>.pem -alias <BROKER_NAME> -keystore <BROKER_NAME>-truststore.jks
```
### Broker connection
Update the "xxx" fields in src/main/resources/application.yml
## Run
```
mvn clean spring-boot:run
```
