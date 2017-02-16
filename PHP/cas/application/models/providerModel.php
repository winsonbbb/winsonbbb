<?php
if (!defined('BASEPATH')) exit('No direct script access allowed');
class providermodel extends CI_Model
{
    function __construct() {
        parent::__construct();
    }
    
    public function getProviderHeart() {
        $this->db->select("*");
        $query = $this->db->query("SELECT distinct type  FROM `vendor`");
        
        if ($query->num_rows() > 0) {
            $temp = array();
            $resultarray = array();
            foreach ($query->result() as $row) {
			if($row->type!="decoration"&&$row->type!="null")
                array_push($resultarray, $row->type);
            }
			array_push($resultarray,"makeupartist");
            array_push($resultarray,"hotel");
            for ($count = 0; $count < sizeof($resultarray); $count++) {
               $number = $count+1;
               $link=site_url("/provider/productList");
			   $img = base_url("img/heart.png");
                if ($number == 1) {
                    $tableRow = <<<EOT
  		 	 <div class="hcfl">
            <div class="hccolw"></div>
            <a href="$link?type=$resultarray[$count]"><div class="hccol" id="$number">
            <br/><br/>
            $resultarray[$count]</div></a>
EOT;
                    
                } 
                else if ($number == 2) {
                    $tableRow = <<<EOT
  		   <div class="hccolw"></div>
            <a href="$link?type=$resultarray[$count]"><div class="hccol" id="$number">
            <br/><br/>
            $resultarray[$count]</div></a>
            <div class="hccolw"></div>
        </div>
        <br/>
        <div class="hcsl">
EOT;
                    
                } 
                else if ($number <= 7 || ($number != 8 && $number <= 10)) {
                    $tableRow = <<<EOT
          <a href="$link?type=$resultarray[$count]"><div class="hccol" id="$number">
<br/><br/>
          $resultarray[$count]</div></a>
EOT;
                    
                } 
                else if ($number == 8) {
                    $tableRow = <<<EOT
  		  </div>
  		  <div class="hctl">
            <div class="hccolw"></div>
          <a href="$link?type=$resultarray[$count]"><div class="hccol" id="$number">
          $resultarray[$count]</div></a>
EOT;
                    
                } 
                else if ($number == 11) {
                    $tableRow = <<<EOT
         <div class="hccolw"></div>
        </div>
        <div class="hcfol">
            <div class="hccolw"></div>
            <div class="hccolw"></div>
            <a href="$link?type=$resultarray[$count]"><div class="hccol" id="$number">
            $resultarray[$count]</div></a>
            <div class="hccolw"></div>
            <div class="hccolw"></div>
        </div>
EOT;
                    
                }
                array_push($temp, $tableRow);
            }
            for ($count = sizeof($resultarray)+1; $count <= 11; $count++) {
                if ($count == 1) {
                    $tableRow = <<<EOT
  		 	 <div class="hcfl">
            <div class="hccolw"></div>
           <div class="hccol" id="$count"><img class="imgHeart" src="$img"/>
            </div>
EOT;
                    
                } 
                else if ($count == 2) {
                    $tableRow = <<<EOT
  		   <div class="hccolw"></div>
            <div class="hccol" id="$count"><img class="imgHeart" src="$img"/></div>
            <div class="hccolw"></div>
        </div>
        <br/>
        <div class="hcsl">
EOT;
                    
                } 
                else if ($count <= 7 || ($count != 8 && $count <= 10)) {
                    $tableRow = <<<EOT
          <div class="hccol" id="$count">
		  <img class="imgHeart" src="$img"/></div>
EOT;
                    
                } 
                else if ($count == 8) {
                    $tableRow = <<<EOT
  		  </div>
  		  <div class="hctl">
            <div class="hccolw"></div>
          <div class="hccol" id="$count">
		  <img class="imgHeart" src="$img"/></div>
EOT;
                    
                } 
                else if ($count == 11) {
                    $tableRow = <<<EOT
         <div class="hccolw"></div>
        </div>
        <div class="hcfol">
            <div class="hccolw"></div>
            <div class="hccolw"></div>
         <div class="hccol" id="$count">
			<img class="imgHeart" src="$img"/>
			</div>
            <div class="hccolw"></div>
            <div class="hccolw"></div>
        </div>
EOT;
                    
                }
                array_push($temp, $tableRow);
            }
            
            $p = array('result' => $temp);
            return $p;
        } 
        else {
            return null;
        }
    }

	
	public function getProduct($type){
		$this->db->select("*");
        $query = $this->db->query("SELECT * from ".$type);
		$var = array(); 
        if ($query->num_rows() > 0) {
		$fields = $this->db->list_fields($type);
		foreach ($fields as $field)
		{
		   array_push($var,$field);
		}
		
            $allresult = array();
            for($i=0;$i<$query->num_rows();$i++) {
			$row = $query->row_array($i);
                array_push($allresult,$row);
			}
		$p = array(
		'field' => $var,
		'product' => $allresult
		);
		
		
            return $p;
        } 
        else {
            return null;
        }
	}
    public function getProductDetail($type,$id){
        $var = array(); 
        $fields = $this->db->list_fields($type);
        foreach ($fields as $field)
        {
           array_push($var,$field);
        }
		$this->db->select("*");
		$this->db->from($type);
		$this->db->where($var[0],$id);  
		$query = $this->db->get();
		if ($query->num_rows() > 0){
				$rowdetail = $query->row_array(0);
			   return $rowdetail;         
		}else{  
			return null;  
		}  
    }
	
	public function orderProduct($id,$column){
	$client = $_SESSION["client"];
	$cid  = $client->clientID;
	$data = array( 
				'clientID' => $cid,
				$column => $id
		);
	$result = $this->db->insert('orders',$data);
	return $result;
	}
	public function checkOrder($id,$column){
	$client = $_SESSION["client"];
	$cid  = $client->clientID;
	$this->db->select("*");  
    $query = $this->db->get_where("orders",Array("clientID" => $cid, $column => $id));  
	if ($query->num_rows() > 0){ //如果數量大於0  
        return true;  //回傳第一筆  
    }else{  
        return false;  
    }  
	return $result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}