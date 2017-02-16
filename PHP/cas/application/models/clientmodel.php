	<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');
class clientmodel extends CI_Model {
    function __construct()
    {
        parent::__construct();
    }

 
    function checkUserExist($account){
        $this->db->select("COUNT(*) AS users");
        $this->db->from("client");
        $this->db->where("userName", $account);
        $query = $this->db->get(); 
 
        return $query->row()->users > 0 ;
    }

	public function getUser($account,$password){  
    $this->db->select("*");  
    $query = $this->db->get_where("client",Array("userName" => $account, "password" => $password ));  
  
    if ($query->num_rows() > 0){ //如果數量大於0  
        return $query->row();  //回傳第一筆  
    }else{  
        return null;  
    }  
}
	public function getGuestTable(){
	$client = $_SESSION["client"];
	$id  = $client->clientID;
	$this->db->select("*");  
	$data = array();
    $query = $this->db->get_where("guestlistinfo",Array("clientID" => $id));  
	if ($query->num_rows() > 0){
        $data[0] = $query->row()->bride;
	   	 $data[1] = $query->row()->groom;
		 return $data;
	}else{  
        return null;
		} 
	}
	
	public function getGuestTableContact($tableID){
	$client = $_SESSION["client"];
	$id  = $client->clientID; 
	$this->db->select('*');
	$this->db->from('guesttablelist');
	$this->db->join('guestlist', 'guestlist.guestListID = guesttablelist.guestListID');
	$this->db->where("guesttablelist.clientID",$id);
	$this->db->where("guesttablelist.tableID",$tableID);
	$query = $this->db->get();
	if ($query->num_rows() > 0){
	 $data = array();
	 foreach ($query->result() as $row) {
		$name = $row->guestName;
		$number = $row->numOfPeople;
		$phone = $row->phone;
		$tablelistID = $row->tablelistID;
		$guest = array(
			'tableID' => $tableID,
			'ID' =>$tablelistID,
			'name' => $name,
			'number' => $number,
			'phone' => $phone
		);
		array_push($data,$guest);
	 } 
	 return $data;
       
	}else{  
        return null;  
		}
	}
	
	
	
	public function newGustTableList($fn,$nop,$cn,$tableID){
	$client = $_SESSION["client"];
	$id  = $client->clientID;
	$data = array( 
				'guestName' => $fn, 
				'numOfPeople' => $nop,
				'phone' => $cn,
				'clientID' => $id
		);
	$result = $this->db->insert('guestlist',$data);   
	$this->db->select("*");  
    $query = $this->db->get("guestlist");
	if($query->num_rows()>0){
	$num = $query->last_row()->guestListID;
	}else{
	$num =0;
	}
	$data = array( 
				'tableID' => $tableID, 
				'guestListID' => $num,
				'clientID' => $id
		);
	$result = $this->db->insert('guesttablelist',$data);   
}	
public function updateGustTableList($fn,$nop,$cn,$tablelistID){
	$this->db->select("*");  
    $query = $this->db->get_where("guesttablelist",Array("tablelistID" => $tablelistID));
	if($query->num_rows()>0){
	$guestListID = $query->row()->guestListID;
	
	$data = array(
               'guestName' => $fn,
               'numOfPeople' => $nop,
               'phone' => $cn
            );

	$this->db->where('guestListID', $guestListID);
	$this->db->update('guestlist', $data); 
	return "ok";
	}else{
	return "";
	}
}	
	

	public function getClientSetList(){
	$client = $_SESSION["client"];
	$id  = $client->clientID;
	$this->db->select("*");  
    $query = $this->db->get_where("guestlistinfo",Array("clientID" => $id));  
	 if ($query->num_rows() > 0){
       $set = $query->row()->setGustList;
	   return $set;
	}else{  
        return "no";  
		} 
	}
	
	public function setGusetTable($gbg,$ggg){
	$client = $_SESSION["client"];
	$id  = $client->clientID;
		$data = array( 
				'clientID' => $id, 
				'setGustList' => 'yes',
				'bride' => $gbg,
				'groom' => $ggg
		);
	$this->db->insert('guestlistinfo', $data); 
	}
	
	public function getTimeTable(){
	$data = array();
		$this->db->select("*");
        $this->db->from("schedule");
        $query = $this->db->get();
		foreach ($query->result() as $row) {
		$name = $row->scheduleName;
		$countdown = $row->scheduleTillDate;

		$schedule = array(
			'name' => $name,
			'countdown' =>$countdown,
		);
		array_push($data,$schedule);
	 } 
        return $data;
	}
	
	public function getOrderDetail($id){
	$data = array();
		$this->db->select("*");
     $query = $this->db->get_where("orders",Array("clientID" => $id)); 
	if ($query->num_rows() > 0){
       foreach ($query->result() as $row) {
	   if($row->makeUpArtistID!="0"){
		$this->db->select("*");
		$query1 = $this->db->get_where("makeupartist",Array("makeUpArtistID" =>$row->makeUpArtistID));
		if ($query1->num_rows() > 0){
		 $row1 = $query1->row(); 
				$photo = $row1->photo;
				$photoLink = base_url($photo);
				$price = $row1->makeupartistPrice;
				$name = $row1->makeupArtistName;
		$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="" width"480" height="360">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4>$name
                                </h4>
                            </div>
                        </div>
                    </div>
EOT;
	
	
		array_push($data,$divdetail);
		}
	   }
	   if($row->dressID!="0"){
	   $this->db->select("*");
		$query1 = $this->db->get_where("dress",Array("dressID" =>$row->dressID));
		if ($query1->num_rows() > 0){
		 $row1 = $query1->row(); 
				$photo = $row1->photo;
				$photoLink = base_url($photo);
				$price = $row1->dressPrice;
				$name = $row1->dressName;
		$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="" width"480" height="360">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4>$name
                                </h4>
                            </div>
                        </div>
                    </div>
EOT;
	
	
		array_push($data,$divdetail);
	   
	   
	   }
	 }  if($row->giftID!="0"){
	   $this->db->select("*");
		$query1 = $this->db->get_where("gift",Array("giftID" =>$row->giftID));
		if ($query1->num_rows() > 0){
		 $row1 = $query1->row(); 
				$photo = $row1->photo;
				$photoLink = base_url($photo);
				$price = $row1->giftPrice;
				$name = $row1->giftName;
		$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="" width"480" height="360">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4>$name
                                </h4>
                            </div>
                        </div>
                    </div>
EOT;
		array_push($data,$divdetail);
	   }
	 }  
	  if($row->hotelID!="0"){
	   $this->db->select("*");
		$query1 = $this->db->get_where("hotel",Array("hotelID" =>$row->hotelID));
		if ($query1->num_rows() > 0){
		 $row1 = $query1->row(); 
				$photo = $row1->photo;
				$photoLink = base_url($photo);
				$price = $row1->hotelPrice;
				$name = $row1->hotelName;
		$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="" width"480" height="360">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4>$name
                                </h4>
                            </div>
                        </div>
                    </div>
EOT;
		array_push($data,$divdetail);
	   }
	 }  
	 if($row->decorationID!="0"){
	   $this->db->select("*");
		$query1 = $this->db->get_where("decoration",Array("decorationID" =>$row->decorationID));
		if ($query1->num_rows() > 0){
		 $row1 = $query1->row(); 
				$photo = $row1->photo;
				$photoLink = base_url($photo);
				$price = $row1->decorationPrice;
				$name = $row1->decorationName;
		$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="" width"480" height="360">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4>$name
                                </h4>
                            </div>
                        </div>
                    </div>
EOT;
		array_push($data,$divdetail);
	   }
	 }  
	  if($row->vehicleID!="0"){
	   $this->db->select("*");
		$query1 = $this->db->get_where("vehicle",Array("vehicleID" =>$row->vehicleID));
		if ($query1->num_rows() > 0){
		 $row1 = $query1->row(); 
				$photo = $row1->photo;
				$photoLink = base_url($photo);
				$price = $row1->vehiclePrice;
				$name = $row1->brand;
		$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="" width"480" height="360">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4>$name
                                </h4>
                            </div>
                        </div>
                    </div>
EOT;
		array_push($data,$divdetail);
	   }
	 }  
	   if($row->restaurantID!="0"){
	   $this->db->select("*");
		$query1 = $this->db->get_where("restaurant",Array("restaurantID" =>$row->restaurantID));
		if ($query1->num_rows() > 0){
		 $row1 = $query1->row(); 
				$photo = $row1->photo;
				$photoLink = base_url($photo);
				$price = $row1->restaurantPrice;
				$name = $row1->restaurantName;
		$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="" width"480" height="360">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4>$name
                                </h4>
                            </div>
                        </div>
                    </div>
EOT;
		array_push($data,$divdetail);
	   }
	 }  
	 if($row->photographyID!="0"){
	   $this->db->select("*");
		$query1 = $this->db->get_where("photography",Array("photographyID" =>$row->photographyID));
		if ($query1->num_rows() > 0){
		 $row1 = $query1->row(); 
				$photo = $row1->photo;
				$photoLink = base_url($photo);
				$email = $row1->email;
				$name = $row1->photographyName;
				$price = $row1->photographyPrice;
			$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink"  width="480px" height="360px"/>
                            <div class="caption">
                                <h4 class="pull-right">$email</h4>
                                <h4>$name
                                </h4>
                            </div>
                        </div>
                    </div>
EOT;
	
		array_push($data,$divdetail);
	   }
	 }  
	 
	 
	 
	 } 
        return $data;
	
	}else{  
        return "no";  
		} 
	}

}