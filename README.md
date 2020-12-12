# CarProducerSystem

TASK DE FYND ASSIGNMENT

Assumptions
- Event here is 'Car' with three fields id,name,brand
- batch event is list of Car 
- both kind of events will be pushed to a producer queue in json format
- ETL = json will be extracted from producer queue and pushed to differnt queues based on their brand name
- I have taken 3 queues named audi, nisaan, volvo based on their brand names
- consumer will request by giving us the quantity of above mentioned 3 brands in json format

1. start the application by extracting the zip and going to the folder
- mvn clean spring-boot:run

2. to produce single event type in the value in json format in this API using POST request
- http://localhost:8080/produceCar
E.g. {
    "name":"a1",
    "brand":"nisaan"
}

3. to produce batch events type the nested json 
- http://localhost:8080/produceBatchCar
[{
    "name":"a1",
    "brand":"nisaan"
},
{
    "name":"a2",
    "brand":"nisaan"
},
{
    "name":"a3",
    "brand":"nisaan"
}]

3. to consume events type in the quantities of above mentioned brands in json format in the below GET request
- http://localhost:8080/consumer
E.g.
{
    "audi":"2",
    "nisaan":"3",
    "volvo":"0"
}

4. this will store the results in 'consumer.txt' file in the project folder.



