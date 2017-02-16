<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Marrcaça Client Access System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <link rel="stylesheet" type="text/css" href="<?=base_url("/css/metro-bootstrap.min.css")?>">
    <link rel="stylesheet" href="<?=base_url("/css/font-awesome.min.css")?>">
     <link rel="shortcut icon" href="<?=base_url("img/favicon.png")?>">
	<link rel="stylesheet"  type="text/css" href="<?=base_url("/css/style.css")?>">

    <style>
     body{
    background-image:url("<?=base_url("img/bg.jpg")?>");
    background-repeat: repeat;
    }
    .grid .row {
        background-color: transparent;
        border: 0;
        height: 50px;
        padding-right: 0;
        margin-left: 85px;
    }
    .grid .row .col-md-3 {
        min-height: 150px;
    }
    .grid .row .col-md-6 {
        min-height: 300px;
    }

    .hccol{
        color: #fff;
        font-size: 22px;
        text-align: center;
    }
	.imgHeart{
	
	 width:140px;
	}
    </style>

    <script type="text/javascript" src="<?=base_url("js/jquery-1.10.2.min.js")?>"></script>

    <script type="text/javascript">
        $(window).load(function() {
            $('.heartcat').fadeIn(3000);

    });
    </script>
</head>

<body>

    <div class="navbar navbar-side navbar-inverse navbar-fixed-top navbar-side-closed" role="navigation">

        <div class="navbar-header">
             <a class="navbar-brand" href="<?=site_url("/main/index")?>"><img src="<?=base_url("img/icon.jpg")?>" >
            </a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<?=site_url("/main/index")?>"><i class="fa fa-1x fa-home"></i> <span>Home</span></a>
                </li>
                <li><a href="<?=site_url("/main/aboutUS")?>"><i class="fa fa-1x fa-user"></i> <span>About</span></a>
                </li>
                <li><a href="<?=site_url("/main/contact")?>"><i class="fa fa-1x fa-envelope"></i> <span>Contact</span></a></a>
                </li>
                <li><a href="<?=site_url("client/logout")?>"><i class="fa fa-sign-out"></i> <span>Logout</span></a></a>
                </li>
            </ul>
        </div>


    </div>

    <div class="grid">
    <div class="row">
	<a href="<?=site_url("/main/index")?>"><button type="button">Back To Main Menu</button></a>
    <h1> <b>&nbsp;&nbsp;Choose provider</b></h1>
    <div class="fade-in">
    <div class="heartcat">
        <?php 
                foreach ($result as $key) {
                    echo $key;
                }
            ?>
        
        
    </div>
    </div>
    </div>
    </div>



    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

    <script type="text/javascript" src="<?=base_url("js/bootstrap.min.js")?>"></script>
    <script type="text/javascript" src="<?=base_url("js/metro-docs.js")?>"></script>



</body>

</html>
