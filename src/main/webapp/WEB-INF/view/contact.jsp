<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jsp"%>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <a class="navbar-brand" href="#">Text Mail</a>
	  <ul class="navbar-nav ml-auto">
	    <!-- <li class="nav-item active">
	      <a class="nav-link" href="showLocation">Text Mail</a>
	    </li> -->
	    <li class="nav-item">
	      <a class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">Attach Mail</a>
	      <div class="dropdown-menu">
        	<a class="dropdown-item" href="contactDAF">Default PDF File</a>
        	<a class="dropdown-item" href="contactUAF">Upload PDF File</a>
        	<a class="dropdown-item" href="#">Generate PDF File</a>
      	  </div>
	    </li>
	  </ul>
	</nav>
	<div class="container mt-5">
		<div class="row justify-content-center align-items-center" style="height:auto;">
			<div class="col-4">
				<div class="card bg-light">
					<div class="card bg-info">
			      		<div class="card-header text-center">
			        		<h3 class="card-text">CONTACT</h3>
			      		</div>
			      	</div>
					<div class="card-body">
						<form action="emailSend" method="post">
		 					<div class="form-group">
                        		<span class="form-group-text">To</span>
                        		<input id="e-mail" type="text" placeholder="Enter your email" name="email" class="form-control input-box rm-border">
                        	</div>
	                        <div class="form-group">
	                        	<span class="form-group-text">Subject</span>
	                        	<input type="text" placeholder="Enter your subject" name="subject" class="form-control input-box rm-border">
	                        </div>
	                        <div class="form-group">
	                        	<span class="form-group-text">Message</span>
	                        	<textarea id="message" type="text" placeholder="Enter your message" name="message" class="form-control input-box rm-border"></textarea>
	                        </div>
	                        
                        	<br>
                     		<button type="submit" class="btn btn-primary btn-block">Sent</button>
                     		
                     		${msg}
						</form>
			 		</div>
		        </div>
		    </div>
		 </div>
	</div>	