<?php
$monthNames = Array("January", "February", "March", "April", "May", "June", "July", 
"August", "September", "October", "November", "December");
$monthshortNames = Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", 
"Aug", "Sep", "Oct", "Nov", "Dec");
?>
<?php
date_default_timezone_set('Asia/Taipei');

$cMonth = $_REQUEST["month"];
$cYear = $_REQUEST["year"];
 
$prev_year = $cYear;
$next_year = $cYear;
$prev_month = $cMonth-1;
$next_month = $cMonth+1;
 
if ($prev_month == 0 ) {
    $prev_month = 12;
    $prev_year = $cYear - 1;
}
if ($next_month == 13 ) {
    $next_month = 1;
    $next_year = $cYear + 1;
}
?>
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
	tr.week{
	text-align:center;
	background-color:#999999;
	color:#FFFFFF;
	}
	tr.day{
	text-align:center;
	background-color:#FFFFFF;
	color:#000000;
	}
	.thingtodo{
	background-color:#ffe89a;
	}
	.thumbnail{
	 width: 700px;
		  margin: 0 auto;
		  text-align: center;
		font-size: 150%;
		 font-family: 'Droid Serif', sans-serif;
		 margin-top: 30px;
	}
	#thingtodo{
	background-color:#ffe89a;
	}
	#daytoday{
	background-color:#9addff;
	}
	#bigday{
	background-color:#FF9a9a;
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
		<table width=100%>
		<tr align="center">
		<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr><td colspan='4'>Please Press Button to go to:</td></tr>
		<tr  style="background-color:#EEC591">
		<td width="25%" align="left">  <a href="<?php echo $_SERVER["PHP_SELF"] . "?month=". $prev_month . "&year=" . $prev_year; ?>" ><button>Previous</button></a></td>
		<td width="25%" align="center"><a href="<?php echo $_SERVER["PHP_SELF"] . "?month=".date("n") . "&year=" .date("y");?>"><button>Today</button></a>  </td>
		<td width="25%" align="center"><a href="<?php echo $_SERVER["PHP_SELF"] . "?day=bigday"?>"><button>BigDay</button></a>  </td>
		<td width="25%" align="right"><a href="<?php echo $_SERVER["PHP_SELF"] . "?month=". $next_month . "&year=" . $next_year; ?>" ><button>Next</button></a>  </td>
		</tr>
		</table>
		</td>
		</tr>
		<tr>
		<tr><td>&nbsp;</td></tr>
		<td align="center">
		<table width="100%" border="0" cellpadding="2" cellspacing="2">
		<tr align="center">
		<td colspan="7" bgcolor="#999999" style="color:#FFFFFF"><strong><?php echo $monthNames[$cMonth-1].' '.$cYear; ?></strong></td>
		</tr>

		<tr class="week">
		<td ><strong>Sunday</strong></td>
		<td ><strong>Monday</strong></td>
		<td ><strong>Tuesday</strong></td>
		<td ><strong>Wednesday</strong></td>
		<td ><strong>Thursday</strong></td>
		<td ><strong>Friday</strong></td>
		<td ><strong>Saturday</strong></td>
		</tr>
		</tr>
		<?php 
                foreach ($div as $key) {
                    echo $key;
                }
		?>
		<tr><td>&nbsp;</td></tr>
		<tr class='day'><td id ='thingtodo'></td><td align='left' colspan='3'>Important Thing You need to do</td></tr>
		<tr class='day'><td id ='daytoday'></td><td align='left' colspan='3'>Today</td></tr>
		<tr class='day'><td id ='bigday'></td><td align='left' colspan='3'>Your Big Day!!!</td></tr>
		
			</table>
		</td>
		</table>
           <div class="thumbnail">
		<div class="showyou">
		</div>
		</div>
		
		
     </div>
    </div>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="<?=base_url("js/jquery.min.js")?>"></script>
	<script>
	$(document).ready(function(){
		$('.thumbnail').hide();
	});
	$( ".thingtodo" ).hover(
	  function() {
	  		$('.showyou').empty();
			 $( '.showyou').append( $( "<span><h1>You need to do these before "+$(this).html()+"</h1></span><br>" ) );
	  $(this).find( "input" ).each(function() {
	  info = $(this).val();
	   $( '.showyou').append( $( "<span>"+info+"</span><br>" ) );
	  });
	   $('.thumbnail').show();
	  });

	
	</script>
</body>

</html>
