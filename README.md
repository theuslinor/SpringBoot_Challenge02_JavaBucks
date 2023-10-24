
 <h1 align="center">  
    <img src = "https://github.com/theuslinor/SpringBoot_Challenge02_JavaBucks/assets/128644651/38212ca4-1ad3-4240-84ad-975ac706bd64" style="margin-top: 10px; height: 300px; width: 300px ">
		<p>Java Bucks</p>
	</h1> 
 <h1> Product ☕🎮</h1>

Status: finished ✅
>
+ Description :
+ This project is made with 5 endponts, a post, put, get Id, get All, delete.
+ The post does not accept repeated product names, nor descriptions under 10 characters.
+ nulls are not saved in the database !
>

### The fields used in the Entity class are:
+ Id
+ name
+ value
+ description
>
### To add a product you need to fill in the following fields:
+ name
+ value
+ description
>
### Example of how to add products to the database using POST:
curl --location 'http://localhost:8080/products' \
--data
```bash
	{
		"name": "name",
		"value": 30.00,
		"description": "Embark on an epic monster hunting journey. Choices impact destiny in this immersive RPG."
	}
```
>
### Example of how to update products in the database using PUT:
curl --location 'http://localhost:8080/products/5' \
>
--data '
```bash
	{
		"name": "Game",
		"value": 30.00,
		"description": "Embark on an epic monster hunting journey. Choices impact destiny in this immersive RPG."
	}
```  

>
### Example of how to get all products registered:
>
#### curl --location --request GET '(http://localhost:8080/products)' 

### Example of how to get product from the database by id using GET:
#### curl --location --request GET '(http://localhost:8080/products/5)'
>
### Example of how to delete a product from the database by id using DELETE:
#### curl --location --request DELETE '(http://localhost:8080/products/5)'

After the "Products/" ID is used to capture, the product with that specific ID and perform the desired operation.


### Example of how to post a product from the database by id using POST:
```bash
	{
		"name": "name",
		"value": 30.00,
		"description": "Embark on an epic monster hunting journey. Choices impact destiny in this immersive RPG."
	}
```

### Example of how to put a product from the database by id using PUT:
#### curl --location --request PUT '(http://localhost:8080/products/5)'
```bash
	{
		"name": "name",
		"value": 30.00,
		"description": "Embark on an epic monster hunting journey. Choices impact destiny in this immersive RPG."
	}
```

<h1> Orders ☕🎮</h1>

The Order functionality allows users to order products from a catalog. An order consists of a **list of products**, a **delivery address** and a **payment method**.

**Operations:**

| Methods | URL | Description |
|--------:|-------------------|-------------|
|GET      |/orders            |Order list: returns the list of orders ordenered by creation date, from most recent to oldest. Additionally, it is possible to filter by order status.|
|GET      |/orders/:id        |Search order: Returns information for a specific order.|
|POST     |/orders            |Register order: Create a new order.|
|PUT      |/orders/:id        |Update order: Updates information about an existing order, such as status or delivery date.|
|POST     |/orders/:id/cancel |Cancel order: Cancels an existing order.|



### Example: Order list.
#### curl --location --request GET '(http://localhost:8081/orders)'

>  Get All, returns all items in the order list, from newest to oldest.
>  You can also filter by status, setting the status as a parameter and in UPPERCASE, for example:
> + NOTE: The available statuses are: SENT, CONFIRMED, CANCELED, DELIVERED.

 ![image](https://github.com/theuslinor/SpringBoot_Challenge02_JavaBucks/assets/131717895/5d7fdc85-23a8-4da8-bc58-243e39d857ea)



### Example: Search order.
#### curl --location --request GET '(http://localhost:8081/orders/{id})'
> To select by Id, simply pass the Id in the URL.


### Example: Register order
#### curl --location --request POST '(http://localhost:8081/orders)'
```bash

--data
'{
  "productService": {
    "id": 2,
    "quantity": 2
  },
  "addressClientRequest": {
    "street": "Rua da Amostra2",
    "number": 101,
    "zipCode": "44090480"
  },
  "payment_method": "PIX"
}'
```

### Example: Update order.
#### curl --location --request PUT '(http://localhost:8081/orders/5)'
```bash
{
    "status": "CANCELED"
}
```

### Example: Cancel order.
#### curl --location --request POST '(http://localhost:8081/orders/{id}/cancel)'
> + An order can only be canceled if the status is other than SENT.
> + An order cannot be cancelled if it is more than 90 days old.
> 
```bash
{
  "cancelReason": "reason for cancellation"
}
```
<h1> Feedback ☕🎮</h1>

Feedback functionality allows users to leave feedback on services and products, a feedback is composed of a satisfaction scale, a comment, and the order id informed.

**Operations:**

| Methods | URL | Description |
|--------:|-------------------|-------------|
|GET      |/feedbacks         |Returns the list of feedbacks.
|GET      |/feedbacks/:id     |Returns information from a specific feedback by ID.|
|POST     |/feedbacks         |Create a new feedback.|
|PUT      |/feedbacks:id      |Updates information about an existing feedback.|
|DELETE   |/feedbacks/:id     |Cancel order: Cancels an existing feedback.|


### Example: Feedback list.
#### curl --location --request GET '(http://localhost:8083/feedbacks)'

>  Get All, returns all items in the feedback list.

### Example: Search order.
#### curl --location --request GET '(http://localhost:8083/feedbacks/{id})'
> To select by Id, simply pass the Id in the URL.

### Example: Register feedback 
#### curl --location --request POST '(http://localhost:8083/feedbacks)'
```bash

--data
'{
   "scale": "SATISFIED"
    "comment": "Comment here",
    "orderId": 1
}'
```

### Example: Update order.
#### curl --location --request PUT '(http://localhost:8083/feedbacks/{id})'
```bash

--data
'{
   "scale": "SATISFIED",
    "comment": "Comment here"
}'
```

### Example: Delete Feedback.
#### curl --location --request DELETE '(http://localhost:8083/feedbacks/{id})'

 ## Tools 🔨
 - [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
 - [Spring Boot 3.0](https://start.spring.io/)
 - [MySQL](https://www.mysql.com/downloads/)
