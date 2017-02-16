
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Marrcaça Client Access System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

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
    </style>


</head>
<body>
<div class="navbar navbar-side navbar-inverse navbar-fixed-top navbar-side-closed" role="navigation">

        <div class="navbar-header">
                  <a class="navbar-brand" href="<?=site_url("/main/index")?>"><img src="<?=base_url("img/icon.jpg")?>">
            </a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<?=site_url("/main/index")?>"><i class="fa fa-1x fa-home"></i> <span>Home</span></a>
                </li>
                <li><a href="<?=site_url("/main/aboutUS")?>"><i class="fa fa-1x fa-user"></i> <span>About</span></a>
                </li>
                <li><a href="<?=site_url("/main/contact")?>"><i class="fa fa-1x fa-envelope"></i> <span>Contact</span></a>
                </li>
                <li><a href="<?=site_url("client/logout")?>"><i class="fa fa-sign-out"></i> <span>Logout</span></a>
                </li>
            </ul>
        </div>
    </div>
    <br/>
    <br/>
    <br/>
                <div class="grid">
            <div class="row col-md-11">
			<a href="<?=site_url("/main/index")?>"><button type="button">Back To Main Menu</button></a>
<form class="form-horizontal" action="setGusetTable" method="post">
<div class="inputdata">
            <h1>Please input some details of guest:</h1>
                <div class="form-group">
                    <label for="qbg" class="col-sm-4 control-label">
                        <h4>The quantity of bride's guests :</h4>
                    </label>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" id="qbg" name="qbg" placeholder="input number" style="margin-top:10px;">
                    </div>
                </div>
                <div class="form-group">
                    <label for="qgg" class="col-sm-4 control-label">
                        <h4>The quantity of groom's guests :</h4>
                    </label>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" id="qgg" name="qgg" placeholder="input number" style="margin-top:10px;">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-10">
                        <input type="submit" id="gen"  value ="Submit"class="btn btn-default">
                    </div>
                </div>
                </div>
            </form>
</div>
        </div>
		</body>