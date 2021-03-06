<%@ include file= "patronHeader.jsp" %>

	<div class="container">
		
		<br>

				<h1 class="display-3">Update Profile</h1>

		<br>

				<form action="updatePatron" method="post">

				<input type="hidden" name="patronId" value="<c:out value='${ patron.patronId }'/>">
			
			<div class="form-group">
				<label for="firstName">First Name</label>
				<input type="text" name="firstName" id="firstName" class="form-control" required
					value="<c:out value='${ patron.firstName }'/>">
			</div>
			
			<div class="form-group">
				<label for="lastName">Last Name</label>
				<input type="text" name="lastName" id="lastName" class="form-control" required 
					value="<c:out value='${ patron.lastName }'/>">
			</div>
			
			<div class="form-group">
				<label for="userName">User Name</label>
				<input type="text" name="userName" id="userName" class="form-control" required 
					value="<c:out value='${ patron.userName }'/>">
			</div>
			
			<div class="form-group">
				<label for="password">Password</label>
				<input type="password" name="password" id="password" class="form-control" required/>
			</div>
			
			
			<input type="submit" value="Save" class="btn btn-primary">
		
		</form>
	
	</div>


<%@ include file= "footer.jsp" %>
