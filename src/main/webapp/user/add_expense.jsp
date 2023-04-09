<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Expense</title>
<style type="text/css">

.card-sh{

	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
}
</style>

<%@include file="../components/all_css.jsp"%>
</head>
<body class="bg-light">
	<%@include file="../components/navbar.jsp"%>

	<div class="container mt-3">

		<div class="row">
			<div class="col-md-4 offset-md-4">

				<div class="card card-sh">
					<div class="card-header text-center">
						<p class="fs-3">Add Expense</p>
					</div>
					<div class="card-body">
						<form action="addExpense" method="POST">
							<div class="mb-3">
								
								<label>Title</label>
								<input type="text" name="title" class="form-control"/>
				
							</div>
							
							<div class="mb-3">
								
								<label>Date</label>
								<input type="date" name="date" class="form-control"/>
				
							</div>
							
							<div class="mb-3">
								
								<label>Time</label>
								<input type="date" name="time" class="form-control"/>
				
							</div>
							
							<div class="mb-3">
								
								<label>Description</label>
								<input type="text" name="description" class="form-control"/>
				
							</div>
							
							<div class="mb-3">
								
								<label>Price</label>
								<input type="text" name="price" class="form-control"/>
				
							</div>
							
							<button class="btn btn-success col-md-12">Add transaction</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>