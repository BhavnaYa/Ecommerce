## Ecommerce Application

###### Java Version: java 11
###### Authentication: JWT token
###### Database: MongoDB

## Services :
###### 1. Account service: 
    # port: 8081
    Provide signUp, login and logout functinality. Also maintains the Authentication using JWT token.
    # end-points
    POST: /account/signUp
    POST: /account/authenticate
    GET: /account/validity
    
###### 2. Inventory service:
    # port: 8083
    Maintains the information regarding products.
    # end-points
     GET: /inventory/getProductInfo/{productId}
     GET: /inventory/searchProduct
     POST: /inventory/addProduct
     PUT: /inventory/updateProductDetails/{productId}
     PUT: /inventory/updateProductInventory/{productId}/{flag}
   
###### 3. Order service
    # port: 8080
    Allow user to have operations related to orders/products.
    # end-points
    POST: /order/addOrder
    POST: /order/cancelOrder/{orderId}
    GET: /order/orderHistory

###### 4. API gateway
    # port: 3000
    All the APIs are exposed to this service for maintaining authentication accross services using Global filter.
    
###### 5. Eureka service
    # port: 8761
    Discovery server.
    
###### 6. Utility Service
    This is a common service containing the common functionality utilised accross services. This is having Global Exceptions and Interceptor logic.
    
    
 ## Contributers
   ***- [Bhavna Yadav](https://github.com/BhavnaYa)***
   
   ***- [Gondewar Naresh Reddy](https://github.com/nareshreddyGNR)***
   
   ***- [Niketan Kudtarkar](https://github.com/niketank9)***
   
   ***- [Sumit Bharadwaj](https://github.com/b-sumit)***
   
   ***- Vinay Singh***



