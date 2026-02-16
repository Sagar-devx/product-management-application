# Product Management Application

A simple **Product Management Application** built using **Spring MVC**, **Hibernate**, and **JSP**. This app allows users to **view**, **add**, **update**, and **delete** products in a dynamic list.  

## Features

- **CRUD Operations** on products:
  
 - **Create**: Add a new product with name, description, and price.
 - **Read**: View all products in a landing page list.
 - **Update**: Edit existing product details.
 - **Delete**: Remove products from the list.
 - **Dynamic Data Display**: Data is fetched from the database using HibernateTemplate and displayed on JSP pages.
 - **Bootstrap 4 UI** for user-friendly forms.
 - Fully functional **landing page** showing all products.

## Tech Stack

- **Backend**: Java, Spring MVC
- **Database Access**: Hibernate (HibernateTemplate)
- **Frontend**: JSP, Bootstrap 4
- **Server**: Tomcat 9.0.100
- **Build Tool**: Maven
- **IDE**: Eclipse

## Project Structure

ProductCRUD/<br>
├── src/main/java/<br>
│ ├── controller/ # Spring MVC Controllers<br>
│ ├── dao/ # DAO classes using HibernateTemplate<br>
│ ├── model/ # Product model<br>
├── src/main/webapp/<br>
│ ├── WEB-INF/views/ # JSP pages (landing, add, update)<br>
├── pom.xml # Maven dependencies


## Installation & Setup

 1. **Clone the repository**  -git clone https://github.com/Sagar-devx/Product-Management-Application.git

 2. **Open in Eclipse**  - Import the project as a Maven project.

 3. **Add Server** -      Add Tomcat 9.0.100 as your runtime server.

 4. **Build Project** -    Ensure all Maven dependencies are downloaded.
                         Right-click project → Run As → Maven build.

 5. **Run Application** -  Right-click project → Run on Server → Tomcat 9
                         Open in browser: http://localhost:8080/ProductCRUD/
                         

# Usage

1.**Landing Page**-    Lists all products in the database.
                       Options to Edit or Delete each product.
                       Button to Add New Product.

2.**Add Product Page** -  Fill in Product Name, Description, and Price.
                          click Add to save product.

3.**Update Product Page** - Pre-filled form with existing product details.
                            Edit and click Update to save changes.



# Author -  Sagar Sharma 

GitHub:https://github.com/Sagar-devx/Product-Management-Application.git
            

