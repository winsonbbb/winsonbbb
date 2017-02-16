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
    <link rel="stylesheet" href="<?=base_url("css/timeline_style.css")?>">
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
	.key{
	color:red;
	}
	Button.rundowbtn{
		 width: 80px;
		 background-color:red;
		  height: 80px;
		  border-radius: 80px;
		  font-size: 16px;
		  color: #fff;
		  line-height: 80px;
		  margin-right:20px;
		  margin-bottom:20px;
		}
	Button.rundowbtn:hover{
		 width: 80px;
		 background-color:black;
		}
    </style>
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
    <br/>
<ul class="timeline">
<a href="<?=site_url("/main/index")?>"><button type="button">Back To Main Menu</button></a>
<table width=100%>
	<tr> <td class="pull-left"><H4>Groom's Team</H4></td>
	<td align="center">
<a href="<?=base_url("file/rundown.pdf")?>" download ><button type="submit" class="rundowbtn">Download</button></a>
</td>
	<td class="pull-right"><H4>Bride's Team</H4></td>
	</tr>
    <!-- Item 1 -->
	<tr><td colspan="3">
    <li>
	 <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Wake up and take breakfast</span>
                <span class="time-wrapper"><span class="time">7:00 am</span></span>
            </div>
            <div class="desc">Dressing up</div>
        </div>
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Wake up and take Breakfast</span>
                <span class="time-wrapper"><span class="time">7:00 am</span></span>
            </div>
            <div class="desc">Make-up Artist Arrived Female Family</div>
        </div>
	
		
    </li>

    <!-- Item 2 -->
    <li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Congregation</span>
                <span class="time-wrapper"><span class="time">7:30 am</span></span>
            </div>
			
            <div class="desc">Brothers group assembly and<br>
			Groom Ready money to grooms 
			<br>men for Red package and
			Daily fee
			</div>
        </div>
		 <div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Congregation</span>
                <span class="time-wrapper"><span class="time">7:30 am</span></span>
            </div>
            <div class="desc">Girls group assembly</div>
        </div>
    </li>

    <!-- Item 3 -->
    <li>
		<div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Preparation(1)</span>
                <span class="time-wrapper"><span class="time">7:30 am - 8:30 am</span></span>
            </div>
            <div class="desc">Take flower, corsages <br>and floral  From florist<br>
					Bring Red package and start go to bride home
			</div>
        </div>
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Preparation(1)</span>
                <span class="time-wrapper"><span class="time">7:30 am - 8:30 am</span></span>
            </div>
            <div class="desc">
			Prepare The door game <br>
			Bride wear dress coat <br>
			Photographer Arrived Female Family
			</div>
        </div>
       
    </li>

    <!-- Item 4 -->

    <li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Preparation(2)</span>
                <span class="time-wrapper"><span class="time">8:30 am - 9:00am</span></span>
            </div>
            <div class="desc">Decorate floats</div>
        </div>
		
        <div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Preparation(2)</span>
                <span class="time-wrapper"><span class="time">8:30 am - 9:00am</span></span>
            </div>
            <div class="desc">Prepare offer tea and ceremony supplies<br>
			<b class="key">**Prepare Blue tape and tape**</b></div>
        </div>
    </li>

    <!-- Item 4 -->

    <li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Arrived Bride home</span>
                <span class="time-wrapper"><span class="time">9:00am - 9:30am</span></span>
            </div>
            <div class="desc">Groom arrived Bride home</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Door Game</span>
                <span class="time-wrapper"><span class="time">9:00am - 9:30am</span></span>
            </div>
            <div class="desc">Start Door game and Red package</div>
        </div>
    </li>
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Offer tea and Ceremony</span>
                <span class="time-wrapper"><span class="time">9:00am - 9:30am</span></span>
            </div>
            <div class="desc">Prepare Groom's Clothes and Belongings</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Offer tea and Ceremony</span>
                <span class="time-wrapper"><span class="time">9:00am - 9:30am</span></span>
            </div>
            <div class="desc">Prepare Bride's Clothes and Belongings</div>
        </div>
    </li>
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Go to Groom's Home</span>
                <span class="time-wrapper"><span class="time">10:00am - 11:00am</span></span>
            </div>
            <div class="desc"></div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Go to Groom's Home</span>
                <span class="time-wrapper"><span class="time">10:00am - 11:00am</span></span>
            </div>
            <div class="desc"></div>
        </div>
    </li>
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Offer tea and Ceremony<br> for Groom's family</span>
                <span class="time-wrapper"><span class="time">11:00am - 11:30am</span></span>
            </div>
            <div class="desc"></div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Offer tea and Ceremony<br> for Groom's family</span>
                <span class="time-wrapper"><span class="time">11:00am - 11:30am</span></span>
            </div>
            <div class="desc"></div>
        </div>
    </li>
		
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Lunch</span>
                <span class="time-wrapper"><span class="time">11:30am - 01:30pm</span></span>
            </div>
            <div class="desc">Groom stay ,Brother group<br>and  Photographer arrive 
			restaurant<br> have lunch</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Lunch</span>
                <span class="time-wrapper"><span class="time">11:30am - 01:30pm</span></span>
            </div>
            <div class="desc">Bride stay ,Sister group<br>and  Photographer arrive
			restaurant<br> have lunch</div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Arrived Salute venue</span>
                <span class="time-wrapper"><span class="time">01:30pm - 02:30pm</span></span>
            </div>
            <div class="desc"></div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Arrived Salute venue</span>
                <span class="time-wrapper"><span class="time">01:30pm - 02:30pm</span></span>
            </div>
            <div class="desc"></div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Salute</span>
                <span class="time-wrapper"><span class="time">03:00pm - 04:00pm</span></span>
            </div>
            <div class="desc"></div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Salute</span>
                <span class="time-wrapper"><span class="time">03:00pm - 04:00pm</span></span>
            </div>
            <div class="desc"></div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Take Photo</span>
                <span class="time-wrapper"><span class="time">04:00pm - 05:00pm</span></span>
            </div>
            <div class="desc">Staff Clean up</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Take Photo</span>
                <span class="time-wrapper"><span class="time">04:00pm - 05:00pm</span></span>
            </div>
            <div class="desc">Counting the needs of <br>
			wedding venue<br>
			Such as:kneeling pad</div>
        </div>
    </li>
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Arrived Wedding venue</span>
                <span class="time-wrapper"><span class="time">05:00pm - 05:30pm</span></span>
            </div>
            <div class="desc">Connection and testing the sound</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Arrived Wedding venue</span>
                <span class="time-wrapper"><span class="time">05:00pm - 05:30pm</span></span>
            </div>
            <div class="desc">Decorate Venue</div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Entertain family and friends</span>
                <span class="time-wrapper"><span class="time">05:30pm - 06:30pm</span></span>
            </div>
            <div class="desc">Arrangement Seating plan</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Change Evening dress</span>
                <span class="time-wrapper"><span class="time">05:30pm - 06:30pm</span></span>
            </div>
            <div class="desc">Sisters group Entertain<br>
			family and friends  </div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Offer tea and Take Photo</span>
                <span class="time-wrapper"><span class="time">06:30pm - 08:00pm</span></span>
            </div>
            <div class="desc"></div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Offer tea and Take Photo</span>
                <span class="time-wrapper"><span class="time">06:30pm - 08:00pm</span></span>
            </div>
            <div class="desc"></div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Everyone take seat</span>
                <span class="time-wrapper"><span class="time">08:00pm</span></span>
            </div>
            <div class="desc"></div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Everyone take seat</span>
                <span class="time-wrapper"><span class="time">08:00pm - 08:00pm</span></span>
            </div>
            <div class="desc"></div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">MC have Speech</span>
                <span class="time-wrapper"><span class="time">08:00pm -08:10pm</span></span>
            </div>
            <div class="desc">
			</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">MC have Speech</span>
                <span class="time-wrapper"><span class="time">08:00pm - 08:10pm</span></span>
            </div>
            <div class="desc"></div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Approach</span>
                <span class="time-wrapper"><span class="time">08:10pm -09:00pm</span></span>
            </div>
            <div class="desc">
			Play Growing video<br>
			Approach<br>
			Cut the cake, toasting
			</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Approach</span>
                <span class="time-wrapper"><span class="time">08:10pm - 09:00pm</span></span>
            </div>
            <div class="desc">
			Play Growing video<br>
			Approach<br>
			Cut the cake, toasting
			</div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Dinner</span>
                <span class="time-wrapper"><span class="time">09:00pm -11:00pm</span></span>
            </div>
            <div class="desc">
			Having dinner<br>
			Toasting
			</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Dinner</span>
                <span class="time-wrapper"><span class="time">09:00pm - 11:00pm</span></span>
            </div>
            <div class="desc">
			Change Evening dress<br>
			Toasting
			</div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Dinner</span>
                <span class="time-wrapper"><span class="time">09:00pm -11:00pm</span></span>
            </div>
            <div class="desc">
			Having dinner<br>
			Toasting
			</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Dinner</span>
                <span class="time-wrapper"><span class="time">09:00pm - 11:00pm</span></span>
            </div>
            <div class="desc">
			Change Evening dress<br>
			Toasting
			</div>
        </div>
    </li>
	
	<li>
        <div class="direction-l">
            <div class="flag-wrapper">
                <span class="flag">Enging(farewell guest)</span>
                <span class="time-wrapper"><span class="time">09:00pm -11:00pm</span></span>
            </div>
            <div class="desc">
			Clean up venue<br>
			Forward Gift to Groom and Bride
			</div>
        </div>
		
		<div class="direction-r">
            <div class="flag-wrapper">
                <span class="flag">Enging(farewell guest)</span>
                <span class="time-wrapper"><span class="time">09:00pm - 11:00pm</span></span>
            </div>
            <div class="desc">
				Clean up venue<br>
			Forward Gift to Groom and Bride
			</div>
        </div>
    </li>
	
	
	</td>
	</tr>
	

</ul>
</table>
   



    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/vendor/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/metro-docs.js"></script>
    <script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-36060270-1']);
    _gaq.push(['_trackPageview']);

    (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
    })();
    </script>

</body>

</html>
