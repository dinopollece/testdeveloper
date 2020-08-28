# testdeveloper
Test Developer para empresa SysOne

Para probar el Web Service podemos ir a ----> [testdeveloper](http://18.229.231.234:8080/testdeveloper/swagger-ui.html)

El enlace te llevará a una GUI de Swagger en donde se encuentra toda la documentación de la API y ahí mismo se puede realizar las pruebas de los request.

## Despliegue

El proyecto está desplegado en Amazon, en una instancia EC2 con una IP elástica.

IP: **18.229.231.234**

## Ejecución
El proyecto se encuentra en **/home/ubuntu/testdeveloper/**

La app esta corriendo como servicio con el nombre de "testdeveloper" 

Para correr el servicio podemos hacer ---> "sudo systemctl start testdeveloper".

Para verificar el estado del servicicio ---> "sudo systemctl status testdeveloper".

Para detener el servicio ---> "sudo systemctl stop testdeveloper".

Para reiniciar el servicio ---> "sudo systemctl restart testdeveloper".
