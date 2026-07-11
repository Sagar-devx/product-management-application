<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./base.jsp" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product App</title>
</head>

<body>
<div class="container mt-3">
    <div class="row">
        <div class="col-md-12">
            <h1 class="text-center mb-3">Welcome to Product App</h1>

            <table class="table table-hover align-middle">
                <thead class="table-dark">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Price</th>
                        <th scope="col" class="text-center">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${products}" var="p">
                        <tr>
                            <th scope="row">2PSE00${p.id}</th>
                            <td>${p.name}</td>
                            <td>${p.description}</td>
                            <td class="fw-bold text-success">&#8377; ${p.price}</td>
                           <td class="text-center">
							    <a href="update/${p.id}" class="text-primary me-2" title="Update">
							        <i class="fas fa-edit fs-5"></i>
							    </a>
							    <a href="delete/${p.id}" class="text-danger" title="Delete">
							        <i class="fas fa-trash fs-5"></i>
							    </a>
						  </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-center mt-4">
                <a href="add-product" class="btn btn-success px-4 py-2 fs-5 shadow">
                    <i class="fa-solid fa-plus me-2"></i> Add New Product
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

