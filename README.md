## MySQL Steup
* check if mysql is running using: `service mysql status`
* start mysql if stopped using: `service mysql start`
* into the mysql shell with: `mysql`
* create a new database: `create database blog_database`
* create a user: `create user 'blog_admin'@'localhost' identified by '1numeric1lower1UPPER1$pecial'`
* grant access to the `blog_database` database to the `blog_admin` user: `grant all on blog_database.* to 'blog_admin'@'localhost'`

## run
* into the grails command line: `grails`
* run the app: `run-app`
* open the link: `http://localhost:8080/post/index`
* to access the database, goto: `localhost:8080/dbconsole` and add the above mentioned `url`, `username` and `password`