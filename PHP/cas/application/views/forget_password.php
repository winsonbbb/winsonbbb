<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
        <link rel="shortcut icon" type="image/png" href="<?=base_url("img/favicon.png")?>"/>
		<title>Marrcasa Admin System</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="<?=base_url("/css/bootstrap.min.css")?>" rel="stylesheet">
		<link href="<?=base_url("/css/welcomeStyle.css")?>" rel="stylesheet">
		 <link rel="shortcut icon" href="<?=base_url("img/favicon.png")?>">
  </script>
    
	</head>
	<body>
<div class="container">
	<div class="row">
    	<div class="container" id="formContainer">
    		

          <form class="form-signin" id="login" method="post"> 
            <h3 class="form-signin-heading" style="text-align:center;">
            <img src="<?=base_url("img/logo.png")?>" />
            <br/>
            Client Access System<br/>
            Please sign in
            
            <br/>
            </h3>

            <a id="flipToRecover" class="flipLink">
              <div id="triangle-topright"></div>
            </a>
  
  
			
            <input type="text" class="form-control" name="email" id="email" placeholder="E-mail" required/> 
			<br/>
            <input type="text" class="form-control" name="account" id="account" placeholder="Account" required/>
            <br/>
            <button class="btn btn-lg btn-primary btn-block" id="apply" name="apply" type="submit">Apply</button>
         <br/> <a class="btn btn-primary pull-right" href="<?=site_url("/")?>">Back</a>
          </form>


          

    	</div>

    	</div>

    	</div>




	</body>
</html>
<script type="text/javascript" src="<?=base_url("js/jquery.min.js")?>"></script>
<script>
$('#apply').click(function(){
	alert("Your Password is sended to your email.");
	   location.reload();
});
</script>

