jQuery(function($) {

			$('.editTable').click(function(){
            setTimeout(function(){ // then show popup, deley in .5 second
                loadPopup(); // function show popup
            }, 500); // .5 second
			var id = $(this).attr('id');
			var value = $(this).children().first().html();
			var nop = $(this).children().eq(1).html();
			var num = $(this).children().eq(2).html();
			var num = $(this).children().eq(2).html();
			$('#editGuest').show();
			$( "#newfamilyname" ).val(value);
			$( "#newnumofpeople" ).val(nop);
			$( "#newcontactnum" ).val(num);
			$( "#newtableID" ).val(id);
            reutrn false;
			});
     
    /* event for close the popup */
    $("div.close").hover(
                    function() {
                        $('span.ecs_tooltip').show();
                    },
                    function () {
                        $('span.ecs_tooltip').hide();
                      }
                );
     
    $("div.close").click(function() {
        disablePopup();  // function close pop up
    });
     
    $(this).keyup(function(event) {
        if (event.which == 27) { // 27 is 'Ecs' in the keyboard
            disablePopup();  // function close pop up
        }      
    });
     
     /************** start: functions. **************/
    var popupStatus = 0; // set value
     
    function loadPopup() {
        if(popupStatus == 0) { // if value is 0, show popup
            closeloading(); // fadeout loading
            $("#editGuest").fadeIn(0500); // fadein popup div
            $("#editGuest").css("opacity", "0.7"); // css opacity, supports IE7, IE8
            $("#editGuest").fadeIn(0001);
            popupStatus = 1; // and set value to 1
        }    
    }
         
    function disablePopup() {
        if(popupStatus == 1) { // if value is 1, close popup
            $("#editGuest").fadeOut("normal");  
            $("#editGuest").fadeOut("normal");  
            popupStatus = 0;  // and set value to 0
        }
    }
    /************** end: functions. **************/
}); // jQuery End