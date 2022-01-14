# clintech-professional


This project communicates with a PostgreSQL database. Install PostgreSQL, using all default settings, don't change the default port. 

Use the following password: pg_adm123. If you change any of those setting, change them on the application.yml file as well before running the application.


SQL scripts execution order:

* address_create.sql
* person_create.sql
* person_addresses_create.sql
* person_specialties_create.sql
* professional_insert.sql
* person_specialties_insert.sql
* address_insert.sql
* person_address_insert.sql

RESTful URLs:

* GET - /clintech/professional/list - Get all professionals
