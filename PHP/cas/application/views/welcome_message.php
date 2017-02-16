<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
        <link rel="shortcut icon" type="image/png" href="<?=base_url("img/favicon.png")?>"/>
		<title>Marrcasa Client Access System</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="<?=base_url("/css/bootstrap.min.css")?>" rel="stylesheet">
		<link href="<?=base_url("/css/welcomeStyle.css")?>" rel="stylesheet">
    </script>
    
	</head>
	<body>
<div class="container">
	<div class="row">
    	<div class="container" id="formContainer">
    		

          <form  class="form-signin" id="login" role="form" action="<?=site_url("client/logining")?>" method="post"> 
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
            		   <?php if(isset($errorMessage)){ ?>  
  
            <div class="alert alert-error"><?=$errorMessage?></div>  
  
            <?php } ?> 
			
            <?php if(isset($account)){ ?>
            <input type="text" class="form-control" name="loginusername" id="loginusername" placeholder="Username" value="<?=htmlspecialchars($account)?>" required autofocus>
            <?php }else{ ?> 
            <input type="text" class="form-control" name="loginusername" id="loginusername" placeholder="Username" required autofocus>
            <?php } ?>  
            <br/>
            <input type="password" class="form-control" name="loginPass" id="loginPass" placeholder="Password" required>
            <br/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
              <span><a href="<?=site_url("/")?>"  style="color:#fff;">cancel</a>
          </form>


          

    	</div>

    	</div>

    	</div>




	</body>
</html>

