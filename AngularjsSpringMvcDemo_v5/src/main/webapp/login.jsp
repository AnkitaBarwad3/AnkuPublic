<!-- <div>
<form ng-submit="verifyUser()">
<input type="text" ng-model="user.userName" >
<input type="text" ng-model="user.password" >
<button type="submit" value="login" >Login</button>
</form>
{{msg}}

</div> -->

<div class="container">
		<section id="content">
		
			<form ng-submit="verifyUser()">
				<h1>Login Form</h1>
				<div>
					<input type="text" placeholder="EmployeeId" required="" ng-model="user.userName"/>
				</div>
				<div>
					<input type="password" placeholder="Password" required=""
						ng-model="user.password"/>
				</div>
				<div>
					<input type="submit" value="Log in" /> 
					
				</div>
			</form>
			<!-- form -->

		</section>
		<!-- content -->
	</div>