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
    <link rel="shortcut icon" href="favicon.png">

    <style>
     body{
    background-image:url("<?=base_url("img/bg.jpg")?>");
    background-repeat: repeat;
	 font-family: 'Droid Sans', sans-serif;
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
	
		Button.packbtn{
		 width: 80px;
		  height: 80px;
		  border-radius: 80px;
		  font-size: 20px;
		  color: #fff;
		  line-height: 80px;
		  text-align: center;
		}
		.packwrap {
		  width: 700px;
		  margin: 0 auto;
		  text-align: center;
		}

		.packtable {
		  height: 250px;
		  width: 100%;
		}
		.packbottom {
		 font-size: 13px;
		 font-family: 'Droid Serif', sans-serif;
		 padding: 5px;
		}
		.price{
		font-size: 150%;	
		}
		
		.copperPack,#copperPack {
		 background: #C87533;
		}
		.silverPack,#silverPack {
		 background: #C0C0C0;
		}
		.goldPack,#goldPack {
		 background: #FFD700;
		}
		ul.pack{
		  list-style: none;
		}
		ul.pack li{
		  float: left;
		  width: 199px;
		  text-align: center;
		  border-left: 1px solid #DDDCD8;
		}
		.packageinfo {
			border-collapse: separate;
			border-spacing: 2px;
			border-color: gray;
		 	padding: 7px;
			font-size: 130%;
		}
		.packageinfo tr td:nth-child(1){
		 background: #BFDFFF;
		}
		.packageinfo tr td:nth-child(2){
		 background: #D9ECFF;
		}
		
		
		.key{
		color: red;
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

        <div class="packwrap">
		<div class="packtable">
         <ul class="pack">
		 <li>
		  <div class="top">
			<Button class ="packbtn"id="copperPack">
			<b>Copper Package</b></Button>
            </div>
			 <div class="packbottom">
			1 Photographer<br>
			1 Make-up Artist<br>
			1 set of Wedding dress(both bride and Groom)<br>
			2 wedding car<br>
			Restaurant or Hotel for 10 table<br>
			<p class="price">Total:$50000</p>
			</div>
			</li>
			<li>
			<div class="top">
			<Button class ="packbtn" id="silverPack">
			<b>Silver Package</b></Button>
			</div>
				<div class="packbottom">
			 1 Photographer<br>
			2 Make-up Artist<br>
			2 set of Wedding dress(both bride and Groom)<br>
			3 wedding car<br>
			Restaurant or Hotel for 18 table<br>
			<p class="price">Total:$75000</p>
			</div>
			</li>
			<li>
			<div class="top">
			<Button class ="packbtn" id="goldPack">
			<b>Gold Package</b></Button>
			</div>
				<div class="packbottom">
			2 Photographer<br>
			2 Make-up Artist<br>
			2 set of Wedding dress(both bride and Groom)<br>
			4 wedding car<br>
			Restaurant or Hotel for 28 table<br>
			<p class="price">Total:$100000</p>
			</div>
			</li>
			</ul>

		</div>
		</div>

		<div class="copperPack">
		<table width=100% class="packageinfo">
		<tr>
            <h1 align="center"><b>Copper Package</b></h1>
		</tr>
		<tr>
		<td>Staffing arrangements : </td>
		<td>1 Professional Photographer and
			1 Professional Make-up Artist</td>
		<td>
		</tr>
		<tr>
		<td>Dress : </td>
		<td>1 Wedding Dress for bride<br>
			1 Wedding Dress for groom<br>
			(Headgear is also include)<br>
			<b class="key">**You can choose in the Dress list price low than 1000**</b></td>
		<td>
		</tr>
		<tr>
		<td>
		Wedding Car :
		</td>
		<td>
		Two car for 4 seat<br>
		<b class="key">**You can choose in the Vehicle list price low than 2000**</b>
		</td>
		</tr>
		<tr>
		<td>
		Restaurant or Hotel:
		</td>
		<td>
		Include 10 table of Food menu<br>
		<b class="key">(With 4** hotel or Restaurant)</b>
		</td>
		</tr>
		<tr>
		<td>
		Total:
		</td>
		<td>
		$50000<br>
		<b class="key">(Additional requirements will cost extra charge)</b>
		</b>
		</td>
		</tr>
		</table>
		</div>
		
		
		<div class="silverPack">
		<table width=100% class="packageinfo">
		<tr>
            <h1 align="center"><b>Silver Package</b></h1>
		</tr>
		<tr>
		<td>Staffing arrangements : </td>
		<td>1 Professional Photographer and
			2 Professional Make-up Artist</td>
		<td>
		</tr>
		<tr>
		<td>Dress : </td>
		<td>2 Wedding Dress for bride<br>
			2 Wedding Dress for groom<br>
			(Headgear is also include)<br>
			<b class="key">**You can choose in the Dress list price low than 2000**</b></td>
		<td>
		</tr>
		<tr>
		<td>
		Wedding Car :
		</td>
		<td>
		Two car for 4 or 6 seat<br>
		<b class="key">**You can choose in the Vehicle list price low than 4000**</b>
		</td>
		</tr>
		<tr>
		<td>
		Restaurant or Hotel:
		</td>
		<td>
		Include 18 table of Food menu<br>
		<b class="key">(With 4**-5** hotel or Restaurant)</b>
		</td>
		</tr>
		<tr>
		<td>
		Total:
		</td>
		<td>
		$75000<br>
		<b class="key">(Additional requirements will cost extra charge)</b>
		</b>
		</td>
		</tr>
		</table>
		</div>
		<div class="goldPack">
		<table width=100% class="packageinfo">
		<tr>
            <h1 align="center"><b>Gold Package</b></h1>
		</tr>
		<tr>
		<td>Staffing arrangements : </td>
		<td>2 Professional Photographer and
			2 Professional Make-up Artist</td>
		<td>
		</tr>
		<tr>
		<td>Dress : </td>
		<td>2 Wedding Dress for bride<br>
			2 Wedding Dress for groom<br>
			(Headgear and Necklace are also include)<br>
			<b class="key">**You can choose all Dress in the list</b></td>
		<td>
		</tr>
		<tr>
		<td>
		Wedding Car :
		</td>
		<td>
		Four car for 4 or 6 seat<br>
		<b class="key">**You can choose all Vehicle in the list</b>
		</td>
		</tr>
		<tr>
		<td>
		Restaurant or Hotel:
		</td>
		<td>
		Include 28 table of Food menu<br>
		<b class="key">(With 5**-6** hotel or Restaurant)</b>
		</td>
		</tr>
		<tr>
		<td>
		Total:
		</td>
		<td>
		$100000<br>
		<b class="key">(Additional requirements will cost extra charge)</b>
		</b>
		</td>
		</tr>
		</table>
		</div>


    </div>



    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="<?=base_url("js/jquery.min.js")?>"></script>
      <script type="text/javascript" src="<?=base_url("js/bootstrap.min.js")?>"></script>
    <script type="text/javascript" src="<?=base_url("js/metro-docs.js")?>"></script>
	<script>
		$(document).ready(function (){
			$('.copperPack').show();
			$('.silverPack').hide();
			$('.goldPack').hide();
		
		});
		$('#copperPack').click(function(){
			$('.copperPack').show();
			$('.silverPack').hide();
			$('.goldPack').hide();
		});
		$('#silverPack').click(function(){
			$('.copperPack').hide();
			$('.silverPack').show();
			$('.goldPack').hide();
		});
		$('#goldPack').click(function(){
			$('.copperPack').hide();
			$('.silverPack').hide();
			$('.goldPack').show();
		});
		
	</script>

</body>

</html>
