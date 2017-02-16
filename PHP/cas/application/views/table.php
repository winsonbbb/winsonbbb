 



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
    <link rel="stylesheet" type="text/css" href="<?=base_url("css/metro-bootstrap.min.css")?>">
    <link rel="stylesheet" type="text/css" href="<?=base_url("css/bootstrap.min.css")?>">
 
    <link rel="stylesheet" href="<?=base_url("css/font-awesome.min.css")?>">
    <link rel="shortcut icon" href="<?=base_url("img/favicon.png")?>">
	<link rel="stylesheet"  type="text/css" href="<?=base_url("/css/style.css")?>">

       <script type="text/javascript" src="<?=base_url("js/jquery-1.10.2.min.js")?>"></script>

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
	<script type="text/javascript">
       $(document).ready(function() {
			$('#editGuest').hide();
		});
	</script>
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
    <div class="row">
<a href="<?=site_url("/main/index")?>"><button type="button">Back To Main Menu</button></a>
 
 <div class="glisttable">
                <h2 style="text-align:center;">Contact List</h2>
                <table class="table table-hover" id="blist" style="background-color:#ffdcd1">
                    <tr>
                        <th>Family Name</th>
                        <th>Number of People</th>
                        <th>Contact Number</th>
                    </tr>
					<?php 
					foreach($div as $key){
						echo $key;
					}
					?>


                </table>
                <button type="button" class="btn btn-default btn-circle btn-lg" id="addbtn">+
                </button>
                <button type="button" class="btn btn-default btn-circle btn-lg" id="canceladd" style="display:none;">-
                </button>
                <div class="addList">
				<form action="<?php echo site_url("/client/newGustTableList");?>" method="post">
                    <input type="name" id="addfamilyname" class="familyname" name="fn" placeholder="Family Name" />
                    <input type="number"  id="addnumofpeople" class="numofpeople" name="nop" placeholder="Number of People" />
                    <input type="text"  id="addcontactnum" class="contactnum" name="cn" placeholder="Contact Number"/>
                    <input type="hidden" name="tableID" value="<?=$tableID?>"/>
					<input type="submit" class="btn btn-default btn-circle" id="boktoadd" value="ok" onClick="return checking()"/>
				</form>
				</div>
				
				<div id="editGuest">
				<form action="<?php echo site_url("/client/updateGustTableList");?>" method="post">
				<table>
				<tr>
                        <th>Family Name</th>
                        <th>Number of People</th>
                        <th>Contact Number</th>
                    </tr>
				<tr>
				 <td><input type="name" id="newfamilyname" name="newfamilyname"  /></td>
                 <td><input type="number" id="newnumofpeople" name="newnumofpeople" /></td>
                 <td><input type="text" id="newcontactnum" name="newcontactnum" /></td>
				<input type="hidden" id="newtableID" name="newtableID"/>
				 <input type="hidden" name="tableID" value="<?=$tableID?>"/>
				 <td><input type="submit" value="save" onClick="return editchecking()"/></td>
				</tr>
				</table>
			   </form>
			   
				</div>
				<br>
				 <h1><a href="<?php echo site_url("/client/updateGustTableList");?>">Back</a></h1>
				</div>
				</div>
				
</body>
 <script type="text/javascript">
			function checking(){
			var count=0;
			for(var i = 0;i<$('.editTable').length;i++){
				count += parseInt($('.editTable').eq(i).children().eq(1).html());
			}
			var edit = [];
			edit[0] =document.getElementById('addfamilyname');
			edit[1] =document.getElementById('addnumofpeople');
			edit[2] =document.getElementById('addcontactnum');
			for (i = 0; i < edit.length; i++) { 
			if(edit[i].value.trim() ==""){
				if(i==0)
					window.alert("Family Name Must be input");
				else if(i==1)
					window.alert("Number of People Must be input");
				else if(i==2)
					window.alert("Contact Number Must be input");
				edit[i].focus();
				return false;
				}
			}
			if(parseInt(edit[1].value) <=0){
				window.alert("Number of People must be integer");
				edit[1].focus();
				return false;
			}
			
				if(parseInt(edit[1].value) >12){
				window.alert("Maximum Number of People is 12");
				edit[1].focus();
				return false;
				}
							if(parseInt(edit[1].value) >12){
				window.alert("Maximum Number of People is 12");
				edit[1].focus();
				return false;
			}
						var countadd = count + parseInt(edit[1].value);
			if(countadd >12){
			window.alert("Maximum People of Table is 12");
				edit[1].focus();
				return false;
			}
			if(edit[2].value==""||(edit[2].value !="" && (edit[2].value.length!=8||!numString(array[2].value)))){
			window.alert("Contact Number must have 8 number");
			return false;
			}
			
				
			
		}
		
			function editchecking(){
			var array = [];
			array[0] =document.getElementById('newfamilyname');
			array[1] =document.getElementById('newnumofpeople');
			array[2] =document.getElementById('newcontactnum');
			for (i = 0; i < array.length; i++) { 
			if(array[i].value.trim() ==""){
				if(i==0)
					window.alert("Family Name Must be input");
				else if(i==1)
					window.alert("Number of People Must be input");
				else if(i==2)
					window.alert("Contact Number Must be input");
				array[i].focus();
				return false;
				}
			}
			if(parseInt(array[1].value) <=0){
				window.alert("Number of People must be integer");
				array[1].focus();
				return false;
			}
				if(parseInt(array[1].value) >12){
				window.alert("Maximum Number of People is 12");
				array[1].focus();
				return false;
			}
						var count=0;
			for(var i = 0;i<$('.editTable').length;i++){
				count += parseInt($('.editTable').eq(i).children().eq(1).html());
			}
			
			var id = $('#newtableID').val();
			count  = count - parseInt($("#"+id).children().eq(1).html());
			countadd = count+parseInt(array[1].value);
			if(countadd >12){
			window.alert("Maximum People of Table is 12");
				array[1].focus();
				return false;
			}
				if(array[2].value==""||(array[2].value !="" && (array[2].value.length!=8||!numString(array[2].value)))){
			window.alert("Contact Number must have 8 number");
			return false;
			}
			}
			
			$('.editTable').click(function(){
				$('.addList').css("display", "none");
             $('#addbtn').css("display", "inline");
             $('#canceladd').css("display", "none");
			var id = $(this).attr('id');
			var value = $(this).children().first().html();
			var nop = $(this).children().eq(1).html();
			var num = $(this).children().eq(2).html();
			$('#editGuest').show();
			$( "#newfamilyname" ).val(value);
			$( "#newnumofpeople" ).val(nop);
			$( "#newcontactnum" ).val(num);
			$( "#newtableID" ).val(id);
            });


            $('#addbtn').click(function() {
				$('#editGuest').hide();
			var count=0;
				for(var i = 0;i<$('.editTable').length;i++){
					count += parseInt($('.editTable').eq(i).children().eq(1).html());
				}
				if(count>=12){
				window.alert("Maximum People of Table is 12 You cannot add more people");
				return false;
				}
                $('.addList').css("display", "inline");
                $('#addbtn').css("display", "none");
                $('#canceladd').css("display", "inline");
				
            });

            $('#canceladd').click(function() {
                $('.addList').css("display", "none");
                $('#addbtn').css("display", "inline");
                $('#canceladd').css("display", "none");
            });

            $('#blistclose').click(function() {
                $('.bcontactTable').css("display", "none");
            });

        </script>
