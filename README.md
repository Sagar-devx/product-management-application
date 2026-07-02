# 📦 Product CRUD (Spring MVC & Hibernate)

[![Java Version](https://img.shields.io/badge/Java-8%2B-orange.svg)](https://www.oracle.com/java/)
[![Spring MVC Version](https://img.shields.io/badge/Spring%20MVC-5.3.33-brightgreen.svg)](https://spring.io/)
[![Hibernate ORM](https://img.shields.io/badge/Hibernate-5.4.10.Final-blue.svg)](https://hibernate.org/)
[![Database](https://img.shields.io/badge/Database-MS%20SQL%20Server-red.svg)](https://www.microsoft.com/sql-server)
[![UI Framework](https://img.shields.io/badge/UI-Bootstrap%204-purple.svg)](https://getbootstrap.com/)
[![Application Server](https://img.shields.io/badge/Server-Tomcat%209.0-yellow.svg)](https://tomcat.apache.org/)

A robust, enterprise-style Java web application for managing catalog products. This project showcases **Spring MVC** architecture, object-relational mapping (ORM) via **Hibernate** (`HibernateTemplate`), declarative transaction managers (`@Transactional`), and interactive user views constructed with **JSP/JSTL** and **Bootstrap 4**.

---

## 🌟 Key Features

*   🔄 **Full Product CRUD Lifecycle:**
    *   **Create:** Register new products (Name, Description, Price) through clean, validated forms.
    *   **Read:** Retrieve dynamic product lists rendered directly on the landing page catalog.
    *   **Update:** Edit specific details with pre-populated form fields.
    *   **Delete:** Remove products instantly from the catalog with automatic database updates.
*   💾 **Declarative Transactions:** Utilizes Spring’s `@Transactional` annotation to guarantee data integrity during CRUD write/delete operations.
*   🗃️ **HibernateTemplate Database Access:** Decouples direct SQL querying by using Hibernate sessions managed via Spring beans.
*   🎨 **Modern JSP Views:** Incorporates a common base header layout (`base.jsp`) styled with Bootstrap 4 and custom Font Awesome icons.
*   ⚙️ **Automatic DDL Schema Updates:** Configured with Hibernate's `update` strategy to dynamically generate tables upon startup.

---

## 📂 Architecture & Directory Layout

```text
ProductCRUD/
├── src/main/java/product/
│   ├── Controller/          # Handles Spring MVC request mapping and routing logic
│   ├── Dao/                 # Data Access Object executing database operations
│   ├── Model/               # Product database mapped entity class
├── src/main/webapp/
│   ├── WEB-INF/             # Secure application descriptor area
│   │   ├── views/           # JSP UI template pages
│   │   │   ├── base.jsp     # Shared template structure (Bootstrap and FontAwesome includes)
│   │   │   ├── index.jsp    # Home landing page showing the product catalog table
│   │   │   ├── add_product_form.jsp   # Insert form for adding a product
│   │   │   └── update_form.jsp        # Edit form for updating product parameters
│   │   ├── spring-servlet.xml   # Spring MVC dispatcher configurations (Beans, SessionFactories, Resolvers)
│   │   └── web.xml          # Web application deployment configurations
├── pom.xml                  # Maven Dependency definitions
└── .gitignore               # Excludes IDE and local build outputs
```

### 🔗 Quick File Access Links
*   **Java Controllers:** [MainController.java](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/java/product/Controller/MainController.java)
*   **Database Interfaces:** [Product_Dao.java](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/java/product/Dao/Product_Dao.java) | [Product.java](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/java/product/Model/Product.java)
*   **JSP View Interfaces:** [index.jsp](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/views/index.jsp) | [add_product_form.jsp](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/views/add_product_form.jsp) | [update_form.jsp](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/views/update_form.jsp) | [base.jsp](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/views/base.jsp)
*   **Configuration Files:** [spring-servlet.xml](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/spring-servlet.xml) | [web.xml](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/web.xml) | [pom.xml](file:///C:/Users/Sagar/Downloads/product-management-application/pom.xml) | [.gitignore](file:///C:/Users/Sagar/Downloads/product-management-application/.gitignore)

---

## 🛠️ Package Breakdown & Class Design

| Package / Directory | File Name | Purpose |
| :--- | :--- | :--- |
| **`product.Controller`** | [MainController.java](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/java/product/Controller/MainController.java) | Maps RESTful routing paths (like `/`, `/add-product`, `/delete/{productId}`, `/update/{productId}`) and forwards variables to the JSP view resolver. |
| **`product.Dao`** | [Product_Dao.java](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/java/product/Dao/Product_Dao.java) | Implements Hibernate CRUD wrapper functions (e.g., `createProduct`, `getProducts`, `deleteProduct`, `getProduct`) using `@Transactional`. |
| **`product.Model`** | [Product.java](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/java/product/Model/Product.java) | Declares the `@Entity` model mapping columns like `id`, `name`, `description`, and `price`. |
| **`WEB-INF/views`** | [index.jsp](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/views/index.jsp) | The catalog dashboard containing action buttons for modifying individual products. |
| | [add_product_form.jsp](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/views/add_product_form.jsp) | Form UI configured to POST new data inputs. |
| | [update_form.jsp](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/views/update_form.jsp) | Form UI preloaded with previous attributes for updates. |

---

## ⚙️ Database & Spring Configurations

The application relies on Microsoft SQL Server as its persistent backend. Database settings are declared in [spring-servlet.xml](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/spring-servlet.xml):

```xml
<!-- DataSource Definition for Microsoft SQL Server -->
<bean name="ds" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
    <property name="url" value="jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Product;encrypt=false;trustServerCertificate=true"/>
    <property name="username" value="sa"/>
    <property name="password" value="password"/>
</bean>

<!-- Hibernate Dialect & Auto-DDL Configuration -->
<property name="hibernateProperties">
    <props>
        <prop key="hibernate.dialect">org.hibernate.dialect.SQLServerDialect</prop>
        <prop key="hibernate.hbm2ddl.auto">update</prop>   
        <prop key="hibernate.show_sql">true</prop> 
    </props>
</property>
```

---

## 🚀 Installation & Local Run

### Prerequisites
*   **Java Development Kit (JDK)**: Version 8 or above.
*   **Apache Tomcat Server**: Version 9.0.x.
*   **Microsoft SQL Server**: Local instance configured with a database named `Product`.

### Step-by-Step Setup

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Sagar-devx/Product-Management-Application.git
    cd Product-Management-Application
    ```

2.  **Verify Database Configuration:**
    Ensure SQL Server is running on port 1433 and login credentials (username: `sa`, password: `password`) in [spring-servlet.xml](file:///C:/Users/Sagar/Downloads/product-management-application/src/main/webapp/WEB-INF/spring-servlet.xml) match your local instance setup.

3.  **Compile & Package Application:**
    Using Maven from terminal:
    ```bash
    mvn clean package
    ```
    This builds the deployable `Product_CRUD_App.war` file in the `target/` directory.

4.  **Deploy on Apache Tomcat:**
    *   **Manual Deployment:** Copy the compiled `Product_CRUD_App.war` file into Tomcat's `webapps/` folder and start the server.
    *   **IDE Deployment (Eclipse / IntelliJ):**
        1. Import the project as a Maven project.
        2. Configure Tomcat 9.0 in your IDE Run Configuration.
        3. Add the project to the server runtime.
        4. Select **Run on Server** to start.

5.  **Access Application in Web Browser:**
    Open the following URL:
    ```text
    http://localhost:8080/Product_CRUD_App/
    ```
