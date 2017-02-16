<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Marrcasa Client Access System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <link rel="stylesheet" type="text/css" href="<?=base_url("css/metro-bootstrap.min.css")?>">
    <link rel="stylesheet" href="<?=base_url("css/font-awesome.min.css")?>">
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
          
            <div>
            <table border="0" width=100%>
            <tr>
                 <td>
                    <H1><b>Your Big Day on <?php echo $bigday;?></b></H1>
                 </td>
                 <td>
                 <H1><b>Left:
                 <?php echo $leftday;?> days</b></H1>
                </td>
            </tr>
            </table>
            </div>
        </div>
                 <div class="row col-md-11">
        </div>
    

        <div class="row col-md-11">
            <div class="tile tile-clouds col-md-3 col-xs-12">
                <a href="#">
                    <h1>Hello<br> <?php echo "Mr ".$gname."&<br>"."Mrs ".$bname;?></h1>
                </a>

            </div>
            <a href="<?=site_url("/provider/index")?>">
                <div class="tile tile-emerald col-md-3 col-xs-12">
                    <div class="tile-content">
                        <div class="tile-icon-large">
                            <img src="<?=base_url("img/provider.png")?>">
                        </div>
                    </div>
                    <span class="tile-label">Choose Provider</span>
                </div>
            </a>
            <a href="<?=site_url("/client/getGuestTable")?>">
                <div class="tile tile-turquoise col-md-3 col-xs-12">
                    <h1>Manage Guest List</h1>
                </div>
            </a>
			<a href="<?=site_url("/main/PackageList")?>">
            <div class="tile tile-amethyst col-md-3 col-xs-12">
                <h1>View Package List</h1>
            </div>
			</a>
        </div>
        <div class="row col-md-11">
        </div>
        <div class="row col-md-11">
        </div>
        <div class="row col-md-11">
            <a href="<?=site_url("/client/scheudle")?>">
                <div class="tile col-md-3 col-xs-12">
                    <div class="tile-content">
                        <div class="tile-icon-large">
                            <img src="<?=base_url("img/scheudle.png")?>">
                        </div>
                    </div>
                    <span class="tile-label">Plan Schedule</span>
                </div>
            </a>
            <a href="<?=site_url("/client/rundown")?>">
                <div class="tile tile-clouds col-md-3 col-xs-12">
                    <h1>Plan Big Day Rundown</h1>
                </div>
            </a>
			<a href="<?=site_url("/main/ThreeDRing")?>">
            <div class="tile tile-carrot col-md-6 col-xs-12">
                <div class="tile-content">
                    <div class="tile-icon-large">
                        <img src="<?=base_url("img/ring.png")?>">
                    </div>
                </div>
                <h1>Act to Design 3D Ring</h1>
            </div>
			</a>
        </div>
        <div class="row col-md-11"></div>
        <div class="row col-md-11"></div>
        <div class="row col-md-11">
            <div class="tile tile-alizarin col-md-3 col-xs-12">
                <a href="<?=site_url("/client/OrderHistory")?>"><h1>Your Order Request</h1></a>
            </div>

            <div class="tile tile-amethyst col-md-3 col-xs-12">
               <a href="<?=site_url("/client/giftanddecoration")?>">
                    <div class="tile-content">
                        <div class="tile-icon-large">
                            <img src="<?=base_url("img/gift.png")?>">
                        </div>
                    </div>
                    <span class="tile-label">Choose Gift & Decoration</span>
                </a>
            </div>

        </div>
    </div>
    </div>



    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="<?=base_url("js/jquery.min.js")?>"></script>
    <script type="text/javascript" src="<?=base_url("js/bootstrap.min.js")?>"></script>
    <script type="text/javascript" src="<?=base_url("js/metro-docs.js")?>"></script>
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
