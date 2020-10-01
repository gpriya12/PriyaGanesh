<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Todo</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

</head>
<body style="background-color:linear-gradient(blue,white); font-family: cursive;font-size:large; ;
  			background-image: url('https://envato-shoebox-0.imgix.net/14d0/9dcd-c09e-493f-af2e-94398aa17bef/IMG_7518.jpg?auto=compress%2Cformat&fit=max&mark=https%3A%2F%2Felements-assets.envato.com%2Fstatic%2Fwatermark2.png&markalign=center%2Cmiddle&markalpha=18&w=800&s=35c5f60b5baed7cb23d17d1107f4865e');
		height:700px; background-position: center; background-repeat: no-repeat;background-size: cover;">
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="font-family: cursive;">
   <div>
    <a class="navbar-brand" style="font-size:xx-large;color:crimson"> Task List</a>
   </div>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link" style="color:crimson">Logout</a></li>
   </ul>
  </nav>
 </header>

 <div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
   <h3 class="text-center" style="font-size:xx-large;color:crimson">List of Tasks</h3>
   <hr>
   
   <div class="container text-left">
    <a href="<%=request.getContextPath()%>/list"
     class="btn btn-success" style="background-color: crimson;border-color: crimson">Todos List</a>
   </div>
 <br>
   <div class="container text-left">
   <a href="<%=request.getContextPath()%>/new"
     class="btn btn-success" style="background-color: crimson;border-color: crimson">Add Todo</a>
   </div>
   
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Title</th>
      <th>Target Date</th>
      <th>Todo Status</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <!--   for (Todo todo: todos) {  -->
     <c:forEach var="todo" items="${listTodo}">

      <tr>
       <td><c:out value="${todo.title}" /></td>
       <td><c:out value="${todo.targetDate}" /></td>
       <td><c:out value="${todo.status}" /></td>

       <td><a href="edit?id=<c:out value='${todo.id}' />" style="color: crimson;">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="delete?id=<c:out value='${todo.id}' />" style="color: crimson;" >Delete</a></td>

       <!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
                 <button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
      </tr>
     </c:forEach>
     <!-- } -->
    </tbody>

   </table>
  </div>
 </div>

</body>
</html>