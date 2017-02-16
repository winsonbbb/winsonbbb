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
       <link rel="stylesheet" type="text/css" href="<?=base_url("/css/bootstrap.min.css")?>">
    <link rel="stylesheet" href="<?=base_url("/css/font-awesome.min.css")?>">
  <link rel="shortcut icon" href="<?=base_url("img/favicon.png")?>">

       <script type="text/javascript" src="<?=base_url("js/jquery-1.10.2.min.js")?>"></script>
    <script type="text/javascript" src="<?=base_url("js/bootstrap.min.js")?>"></script>
    <script type="text/javascript" src="<?=base_url("js/metro-docs.js")?>"></script>
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
	.jewpic,.jewbtn{
		height:350px;
		max-width:350px;
	}
	.ringpic,.ringbtn{
		height:350px;
		max-width:400px;
	}
	.selecttable{
		border-collapse: separate;
			border-spacing: 2px;
			border-color: gray;
		 	padding: 7px;
			font-size: 130%;
	}
	.ringdesc{
	font-size:150%;
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
	<div class="jew" class="selecttable">
		<H1><b>Select The Jewellery You Like<B></H1>
		<table width=70% align="center" class="selecttable">
		<tr>
		<td><button id="j1" class="jewbtn"><img class="jewpic" src="<?=base_url("img/ring/jew1.jpg")?>"/></button></td>
		<td><button id="j2" class="jewbtn"><img class="jewpic" src="<?=base_url("img/ring/jew2.jpg")?>"/></button></td>
		<td><button id="j3" class="jewbtn"><img class="jewpic" src="<?=base_url("img/ring/jew3.jpg")?>"/></button></td>
		</tr>
		</table>
		</div>
		
		<div class="ring">
		<H1><b>Select The Ring You Like<B></H1>
		<table width=70% align="center" class="selecttable">
		<tr>
		<td><button id="r1" class="ringbtn"><img class="ringpic" src="<?=base_url("img/ring/ring1.jpg")?>"/></button></td>
		<td><button id="r2" class="ringbtn"><img class="ringpic" src="<?=base_url("img/ring/ring2.jpg")?>"/></button></td>
		<td><button id="r3" class="ringbtn"><img class="ringpic" src="<?=base_url("img/ring/ring3.jpg")?>"/></button></td>
		<input id="path" type="hidden" name="path" value="<?=site_url("/main/Ring")?>" />
		</tr>
		</table>
		</div> 
		<table>
		<tr>
		<td>
		<div id="ringhtml">
		Loading........................
	
		</div>
		</td>
		</tr>
		<tr>
		<td>
		<div class="ringdesc" >
		This is the Ring of your selection. <br>
		<button onclick="location.reload();">Back</button>
		</div>
		</td>
		</tr>
		
     </div>
    </div>
	



    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
   <script type="text/javascript">
var jid="";
var rid="";
    $(document).ready(function (){
			$('.ring').hide();
			$('#ringhtml').hide();
			$('.ringdesc').hide();
		});
	$('.jewbtn').click(function(){
		jid = $(this).attr('id');
		$('.jew').hide();
		$('.ring').show();
	});
	$('.ringbtn').click(function(){
	rid = $(this).attr('id');
	$path = $('#path').val();
	$('.ring').hide();
	$('#ringhtml').show();
	$('#ringhtml').load($path+"?jid="+jid+"&rid="+rid , {limit: 25}, function() {
  	 	$('.ringdesc').delay(5000).fadeIn(500);
});;		
	 });
    </script>

</body>

</html>
