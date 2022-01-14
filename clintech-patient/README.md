# clintech-patient

This project communicates with a PostgreSQL database. Install PostgreSQL, using all default settings, don't change the default port. 

Use the following password: pg_adm123. If you change any of those setting, change them on the application.yml file as well before running the application.


SQL scripts execution order:

* address_create.sql
* person_create.sql
* person_addresses_create.sql
* patient_insert.sql
* address_insert.sql
* person_address_insert.sql

RESTful URLs:

* POST - /clintech/patient - Insert a new patient. JSON:

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

* GET - /clintech/patient/id - Get a patient by ID (replace the word 'id' by the id number)
