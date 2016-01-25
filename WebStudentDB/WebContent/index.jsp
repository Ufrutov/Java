<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="student.Student, java.util.List, java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@include file='templates/head.html'%>
<body>

	<nav class="navbar navbar-default">
		<div class="container">
    		<div class="navbar-header">
    			<a class="navbar-brand" href="#">Web Student</a>
    		</div>
    	</div>
    </nav>
    
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-4 col-md-3 col-lg-3">
				<div>
					<h4>Form</h4>
					<div>
						<form action="AddStudent" method="GET">
							<div class="form-group">
								<label for="s-name">Name</label>
								<input type="text" name="name" class="form-control" id="s-name" placeholder="First name" required="required">
							</div>
							<div class="form-group">
								<label for="s-lastname">Last name</label>
								<input type="text" name="lastname" class="form-control" id="s-lastnam" placeholder="Last name" required="required">
							</div>
							<div class="form-group">
								<label for="s-year">Year</label>
								<input type="number" name="year" class="form-control" id="s-year" placeholder="Faculty" required="required">
							</div>
							<div class="form-group">
								<label for="s-faculty">Faculty</label>
								<input type="text" name="faculty" class="form-control" id="s-faculty" placeholder="Faculty name" required="required">
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-8 col-md-9 col-lg-9">
				<div>
					<h4>Students</h4>
					<div>
						<table class="table">
							<thead>
								<tr>
									<th>id</th>
									<th>First name</th>
									<th>Last name</th>
									<th>Year</th>
									<th>Faculty</th>
								</tr>
							</thead>
<%
	
	List<Student> s = Student.liststudents();
	if( !s.isEmpty()) {
		Iterator<Student> i = s.iterator();
		
		while(i.hasNext()) {
			out.println("<tr>");
			Student si = i.next();
			
			out.println("<td>"+si.id+"</td>");
			out.println("<td>"+si.name+"</td>");
			out.println("<td>"+si.lastname+"</td>");
			out.println("<td>"+si.year+"</td>");
			out.println("<td>"+si.faculty+"</td>");
			
			out.println("</tr>");
		}
	} else {
		out.println("There is not students yet..");
		System.out.println("There is not students yet..");
	}
%>				
					
						</table>
					</div>
				</div>
			</div>
		
		</div>
	</div>

</body>
</html>