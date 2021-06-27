# spring-demo-student

Criado aplicacao como API com as request GET POST DEL e PUT

Api testada com Insomnia

Com as request e content body Application JSON abaixo:

GET http://localhost:8080/api/v1/student

POST http://localhost:8080/api/v1/student
{
	"name": "Diana Rial da Nobrega",
	"email": "diana@gmail.com",
	"dob": "2020-05-04"
}

PUT http://localhost:8080/api/v1/student/1?name=Maria&email=maria@gmail.com

DELETE http://localhost:8080/api/v1/student/1

