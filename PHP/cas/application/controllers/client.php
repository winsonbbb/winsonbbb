<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');
 
class client extends MY_Controller {
	function __construct () {
        parent::__construct ();
    }
	public function login(){
		if(isset($_SESSION["client"]) && $_SESSION["client"] != null){ //已經登入的話直接回首頁
			redirect(site_url("/main/index")); //轉回首頁
			return true;
		}
 
		$this->load->view(
			"login",
			Array( "pageTitle" => "Marrcasa Client System"	)
		);
	}
	public function rundown(){
		if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$this->load->view("rundown");
	}
	public function scheudle(){
		if(!isset($_SESSION["client"])){
			redirect(site_url("/"));
			}
			date_default_timezone_set('Asia/Taipei');
			$client = $_SESSION["client"];
			$bigday = $client->bigDay;
			$this->load->model('clientmodel'); 
			$data = $this->clientmodel->getTimeTable();
			$thingDay = array(); 
			$thingInfo =array();
			for($i=0;$i<sizeof($data);$i++){
			$thingInfo[$i] = $data[$i]['name'];
			$thingDay[$i] = $data[$i]['countdown'];
			}
	$bigday =  strtotime($bigday);
	$thingDayafter = array();
	for($i=0;$i<sizeof($thingDay);$i++){
	$thingDoDay =  strtotime ( '-'.$thingDay[$i].'day' ,  $bigday ) ;
	array_push($thingDayafter,$thingDoDay);
	}
			$monthNames = Array("January", "February", "March", "April", "May", "June", "July", 
			"August", "September", "October", "November", "December");
			$monthshortNames = Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", 
			"Aug", "Sep", "Oct", "Nov", "Dec");
			if(isset($_REQUEST["day"])&&$_REQUEST["day"]=="bigday") {
			$_REQUEST["month"] = date( 'm' ,  $bigday );
			$_REQUEST["year"] = date( 'y' ,  $bigday );
			}
			if (!isset($_REQUEST["month"])) $_REQUEST["month"] = date("m");
			if (!isset($_REQUEST["year"])) $_REQUEST["year"] = date("y");
			$cMonth = $_REQUEST["month"];
			$cYear = $_REQUEST["year"];
			$timestamp = mktime(0,0,0,$cMonth,1,$cYear);
			$maxday = date("t",$timestamp);
			$thismonth = getdate ($timestamp);
			$shortthismonth = $monthshortNames[$cMonth-1];
			$startday = $thismonth['wday'];
			$td ="";
			$div = array();
			for ($i=0; $i<($maxday+$startday); $i++) {
				if(($i % 7) == 0 ) 
				$td =  "<tr class='day'>";
				if($i < $startday)
				$td = $td."<td></td>";
				else {
				
				if((($cMonth)== date('m',$bigday))&&(($i - $startday + 1)==date('d',$bigday))&&$cYear==date('y',$bigday)){
				$td = $td."<td height='50px' id='bigday'> ".($i - $startday + 1);
					$td = $td."</td>";
				}else if($shortthismonth==date("M")&&($i - $startday + 1)==date("d")&&$cYear==date("y")){
				$td = $td."<td height='50px' id='daytoday' ";
				$todaycount = 1;
					for($j=0;$j<sizeof($thingDayafter);$j++){
						if((($cMonth)== date('m',$thingDayafter[$j]))&&(($i - $startday + 1)==date('d',$thingDayafter[$j]))){
							if($todaycount==1){
							$td = $td." class='thingtodo'>";
							}
							$td = $td."<input class='thing' type='hidden' name='thing' value='".$thingInfo[$j]."'/>";	
							$todaycount = $count +1;
						}
					}
					if($todaycount ==1)
						$td = $td.">";
					$td = $td.($i - $startday + 1);
					if($todaycount >1)
						$td = $td."** ";
					$td = $td."</td>";
				}else{
				$count = 1;
				$td = $td."<td height='50px' ";
				for($j=0;$j<sizeof($thingDayafter);$j++){
						if((($cMonth)== date('m',$thingDayafter[$j]))&&(($i - $startday + 1)==date('d',$thingDayafter[$j]))&&$cYear==date('y',$thingDayafter[$j])){
							if($count==1){
							$td = $td." class='thingtodo'>";
							}
							$td = $td."<input class='thing' type='hidden' name='thing' value='".$thingInfo[$j]."'/>";
							$count = $count+1;
						}
				}
				if($count ==1)
					$td = $td.">". ($i - $startday + 1) . "</td>";
				else if($count >1)
					$td = $td. ($i - $startday + 1) . "</td>";
				
				}
				if(($i % 7) == 6 || $i==($maxday+$startday-1)){
				$td = $td."</tr>";
				array_push($div,$td);
				}
			}
			}			
			$p = array( 
			'div' =>$div);
			$this->load->view("timetable",$p);
		}
	
	public function giftanddecoration(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$this->load->view("giftanddecr");
	}
	public function OrderHistory(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$clientid = $_SESSION["client"]->clientID;
		$div = array();
	$this->load->model('clientmodel');
	$div = $this->clientmodel->getOrderDetail($clientid);
	
		$p = array('div' =>$div);
	$this->load->view('order',$p);
	}
	
	
	public function getGuestTableContact(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$tableID = $_GET['tableID'];
		$this->load->model('clientmodel'); 
		$data = $this->clientmodel->getGuestTableContact($tableID);
		$div = array();
		if (is_array($data))
		{
			foreach ($data as $row){
				$ID = $row['ID'];
				$name = $row['name'];
				$number = $row['number'];
				$phone = $row['phone'];
				$divdetail = <<<EOT
							 <tr class="editTable" id="$ID">
							<td class="name">$name</td>
							<td class="numpeople">$number</td>
							<td class="number">$phone</td>
						</tr>
EOT;
			array_push($div,$divdetail);
			}
		}
		$p = array(
		'div' =>$div,
		'tableID' =>$tableID
		);
		$this->load->view("table",$p);
	}
	
	public function newGustTableList(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
	$fn = $_POST['fn'];
	$nop = $_POST['nop'];
	$cn = $_POST['cn'];
	if(!($fn==""||$nop==""||$cn=="")){
	$tableID = $_POST['tableID'];
	$this->load->model('clientmodel');
	$this->clientmodel->newGustTableList($fn,$nop,$cn,$tableID);
	$newURL = site_url("client/getGuestTableContact")."?tableID=".$tableID;
	header('Location: '.$newURL);
	}else{
	$newURL = site_url("client/getGuestTable");
	header('Location: '.$newURL);
	}
	}
	public function updateGustTableList(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$fn = $_POST['newfamilyname'];
		$nop = $_POST['newnumofpeople'];
		$cn = $_POST['newcontactnum'];
		$tableID = $_POST['tableID'];
		$tablelistID = $_POST['newtableID'];
		if(!($fn==""||$nop==""||$cn=="")){
			$this->load->model('clientmodel');
			$result = $this->clientmodel->updateGustTableList($fn,$nop,$cn,$tablelistID);	
			if($result!=""){
				$newURL = site_url("client/getGuestTableContact")."?tableID=".$tableID;
				header('Location: '.$newURL);
			}else{
				$newURL = site_url("client/getGuestTable");
				header('Location: '.$newURL);
			}
		}else{
			$newURL = site_url("client/getGuestTable");
			header('Location: '.$newURL);
		}
	}
	
	
	public function getGuestTable(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$this->load->model('clientmodel');
		$set = $this->clientmodel->getClientSetList();
		if($set=="yes"){
		$data = $this->clientmodel->getGuestTable();
		$tob = ceil($data[0] / 12);
		$tog = ceil($data[1] / 12);
		$div = array();
		$btable = base_url("img/brideTable.png");
		$gtable = base_url("img/groomTable.png");
		$num=0;
		if($tob>$tog){
			$num =$tob; 
		}else{
		$num = $tog;
		}
	$open =<<<EOT
 <div class="guestTable" >
                       <table border="0" width=70%>
					     <tr><th><H1>Tables of Bride</H1></th><th> <H1>Tables of Groom</H1></th></tr>
EOT;
array_push($div,$open);
		for($i=1;$i<=$num;$i++){
		$link = site_url("/client/getGuestTableContact");
		if($tob<$i){
			$divdetail = <<<EOT
					   <tr>
					   <th></th> <th>Groom Table$i</th>
						</tr>
						<tr>
						<td></td>
						<td><a href="$link?tableID=G$i"><img class="tableImg" id="gt$i" src="$gtable"></a></td>
						</tr>
				
EOT;
}else if($tog<$i){
$divdetail = <<<EOT
					   <tr>
					   <th>Bride Table$i</th> <th></th>
						</tr>
						<tr>
						<td><a href="$link?tableID=B$i"><img class="tableImg" id="bt$i" src="$btable"></a></td>
						<td></td>
						</tr>
EOT;
}else{
$divdetail = <<<EOT
					   <tr>
					   <th>Bride Table$i</th> <th>Groom Table$i</th>
						</tr>
						<tr>
						<td><a href="$link?tableID=B$i"><img class="tableImg" id="bt$i" src="$btable"></a></td>
						<td><a href="$link?tableID=G$i"><img class="tableImg" id="gt$i" src="$gtable"></a></td>
						</tr>
EOT;
}
		array_push($div,$divdetail);
		}
		$close =<<<EOT
  </table>
                    </div>
EOT;
array_push($div,$close);
		$p = array(
		'div' => $div
		);
		
			$this->load->view('guestlist',$p);
		}else{
			$this->load->view('guestlistconfirm');
		}
	}
	
	public function setGusetTable(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
	$gbg = $_POST['qbg'];
	$qgg = $_POST['qgg'];
	$this->load->model('clientmodel');
	$this->clientmodel->setGusetTable($gbg,$qgg);
	redirect(site_url("/client/getGuestTable"));
	}
	
	
	
	public function logining(){
		if(isset($_SESSION["client"]) && $_SESSION["client"] != null){ //已經登入的話直接回首頁
			redirect(site_url("/main/index")); //轉回首頁
			return true;
		}
 		
		$account = trim($this->input->post("loginusername"));
		$password = trim($this->input->post("loginPass"));

		$this->load->model("clientmodel");
		$client = $this->clientmodel->getUser($account,$password);
 
		if($client == null){
			$this->load->view(
				"welcome_message",
				Array( "pageTitle" => "system login"	,
					"account" => $account,
					"errorMessage" => "Incorrect username or password."
				)
			);		
			return true;
		}
 
		$_SESSION["client"] = $client;
		redirect(site_url("/main/index")); //轉回首頁
	}
	
 
	public function logout(){
		session_destroy();
		redirect(site_url("/")); //轉回登入頁
	}
 
}