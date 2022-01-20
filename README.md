# clintech

This application is composed by 5 microservices and 1 message consumer. It stores its data in a PostgreSQL database and the messaging service is RabbitMQ.

In order to get everything running, from the root of the project execute:
docker-compose up -d

You might need to install Docker Compose. If that's the case, run the following command: docker-compose pull

All images will be created and the containers started.
To access the application, just open http://localhost:8081/clintech

The database is pre-loaded with some test data and the docker compose is responsible for starting the DB and running the queries.

RESTful URLs:

- GET - /clintech/professional/list - Get all professionals
- GET - /clintech/procedure/list - Get all procedures
- POST - /clintech/patient - Insert a new patient. JSON:

```
{
      "name": "Chris",
      "lastname": "Bellamy",
      "email": "chris.bellamy@gmail.com",
      "phone": "(11)98235-3698",
      "address": [{
      		"street": "Rua Independencia",
	          "number": 358,
	          "district": "Perdizes",
	          "city": "Sao Paulo",
			"state": "SP",
	          "zipCode": "02384-157"
      	}]
   }
```

- GET - /clintech/patient/id - Get a patient by ID (replace the word 'id' by the id number)
- POST - /clintech/appointment - Insert/Update an appointment. To update, just add the id property to the JSON string. JSON:

```
{
      "date": "10/30/2021",
	   "time": "09:30",
      "professional": { "id": 2 },
      "treatment": {
          "procedure": { "id": 1 },
          "patient": { "id": 7 }
      }
}
```

- GET - /clintech/appointment/list/id - Get all appointments by patient ID (replace the word 'id' by the id number)
- GET - /clintech/appointment/id - Get appointment by ID (replace the word 'id' by the id number)
- DELETE - /clintech/appointment/id - Delete the appointment by ID (replace the word 'id' by the id number)
