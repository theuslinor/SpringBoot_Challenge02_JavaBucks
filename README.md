
 <h1 align="center">  
    	<img src = "https://github.com/theuslinor/SpringBoot_Challenge02_JavaBucks/assets/128644651/38212ca4-1ad3-4240-84ad-975ac706bd64" style="margin-top: 10px; height: 300px; width: 300px; border-radius: 10px" ">
	<p>Java Bucks</p>
</h1> 
 <h1>About the challenge ☕🎮</h1>

Status: finished ✅
>
+ Description :
+ This project is made with 4 endponts, a post, put, get Id, get All, delete.
+ The post does not accept repeated product names, nor descriptions under 10 characters.
+ nulls are not saved in the database !
>

The fields used in the Entity class are:
+ Id
+ name
+ value
+ description
>
To add a product you need to fill in the following fields:
+ name
+ value
+ description
>
Example of how to add products to the database using POST:
curl --location 'http://localhost:8080/products' \
--data
```bash
      {
        "name": "name",
        "value": 30.00,
        "description": "Embarque em uma épica jornada de caça a monstros. Escolhas impactam o destino neste RPG imersivo."
      }
   ```
>
Example of how to update products in the database using PUT:
curl --location 'http://localhost:8080/products/5' \
>
--data '
```bash
      {
         "name": "Game",
         "value": 30.00,
         "description": "Embarque em uma épica jornada de caça a monstros. Escolhas impactam o destino neste RPG imersivo."
      }
```  

>
Example of how to get all products registered:
>
#### curl --location --request GET '(http://localhost:8080/products)' 

Example of how to get product from the database by id using GET:
#### curl --location --request GET '(http://localhost:8080/products/5)'
>
Example of how to delete a product from the database by id using DELETE:
#### curl --location --request DELETE '(http://localhost:8080/products/5)'

After the "Products/" ID is used to capture, the product with that specific ID and perform the desired operation.


Example of how to post a product from the database by id using POST:
  ```bash
{
	"name": "name",
  "value": 30.00,
  "description": "Embarque em uma épica jornada de caça a monstros. Escolhas impactam o destino neste RPG imersivo."
}
  ```

Example of how to put a product from the database by id using PUT:
#### curl --location --request PUT '(http://localhost:8080/products/5)'
  ```bash
{
	"name": "name",
  "value": 30.00,
  "description": "Embarque em uma épica jornada de caça a monstros. Escolhas impactam o destino neste RPG imersivo."
}
  ```


 ## Tools 🔨
 - [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
 - [Spring Boot](https://start.spring.io/)
 - [MySQL](https://www.mysql.com/downloads/)
