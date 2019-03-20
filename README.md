# spring-cloud-contract-poc
A sample repository to demonstrate the contract driven consumer tests for REST and Messaging integration

There are 2 modules
producer - produces words randomly per second from a predefined array of words of fixed length 
consumer - computes the number of occurrences of each word and stores them in an in-memory cache which is then queryable using the interactive service. There is 
           a rest API fronting the same exposed at /counts
           
NB: you need zookeeper and kafka running before you start the producer and consumer apps hence the docker-compose file 
