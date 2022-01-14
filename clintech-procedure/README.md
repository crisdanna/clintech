# clintech-procedure

This project communicates with a PostgreSQL database. Install PostgreSQL, using all default settings, don't change the default port. 

Use the following password: pg_adm123. If you change any of those setting, change them on the application.yml file as well before running the application.


SQL scripts execution order:

* procedure_create.sql
* procedure_insert.sql

RESTful URLs:

* GET - /clintech/procedure/list - Get all procedures
