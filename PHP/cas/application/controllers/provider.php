<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class provider extends MY_Controller {

	public function index()
	{
	$this->load->model('providermodel');
	$p = $this->providermodel->getProviderHeart();
		$this->load->view('provider',$p);
	}

	public function productDetail(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$id = $_GET['id'];
		$type = $_GET['type'];
		$msg ="";
		if(isset($_SESSION['order'])){
			if($_SESSION['order']=="ok"){
			$msg = "<script>window.alert('Success!!!!The order have request to the wedding planner');</script>";
			}else if($_SESSION['order']=="had"){
			$msg = "<script>window.alert('You have order it already!!!!');</script>";
			}
			unset($_SESSION['order']);
		}
		$this->load->model('providermodel');
		$row =$this->providermodel->getProductDetail($type,$id);
		$link = site_url("provider/order");
		$table = array();
		$size =sizeof($row)-1;
		$photo = base_url($row['photo']);
		$count=0;
		$column = "";
		foreach($row as $key => $value){
		$str = ucfirst($key);
        if($count==0){	
		$column = $key;
			$divdetail = <<<EOT
			   <tr>
					 <td rowspan="$size">    
					 <img src="$photo" height="560" style="max-width:720px">
					 </td>
					 </tr>
EOT;
		array_push($table,$divdetail);
		}else if($key=="photo"){
		}else if($count==sizeof($row)-1){
		
		}else{
		$divdetail = <<<EOT
					<tr>
					<td><b>
					$str:
					 </b></td>
					 <td>
					 $value
					 </td>
					 </tr>
			
EOT;

		array_push($table,$divdetail);
		}
		$count = $count+1;
		}
		$formstop = <<<EOT
						<tr><td></td><td><button onclick="location.href='$link?type=$type&id=$id&column=$column'">Order one</button></a>
</td></tr>
						
EOT;
		$p = array(
		'link' =>$link,
		'table' =>$table,
		'formstop' =>$formstop,
		'msg' =>$msg
			);
		$this->load->view('productDetail',$p);
	}
	public function order(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
	$id  = $_GET['id'];
	   $type = $_GET['type'];
	   $column = $_GET['column'];
	   $this->load->model('providermodel');
	   $isorder = $this->providermodel->checkOrder($id,$column);
		$order = site_url("provider/order");
		$back = site_url("/provider/productDetail");
		
		if($isorder){
			$_SESSION['order'] = "had";
			$newURL = site_url("/provider/productDetail");
			header('Location: '.$newURL."?type=".$type."&id=".$id);
		
		}else{
		if (empty ($_GET['confirm']))
	{
	   echo "<table align='center'>";
	   echo "<tr><td>";
	   echo "Are you sure you want to order ?<br />";
	   echo "</td></tr>";
	   echo "<tr><td>";
	   echo "<a href='".$order."?type=".$type."&id=".$id."&column=".$column."&confirm=1'>YES</a>";
	   echo "</td><td>";
	  echo "<a href='".$back."?type=".$type."&id=".$id."&column=".$column."'>NO</a>";
		echo "</td></tr></table>";
	   }
	else if (! empty ($_GET['confirm']))
	{
		$result = $this->providermodel->orderProduct($id,$column);
		if($result==1){
		$_SESSION['order'] = "ok";
		$newURL = site_url("/provider/productDetail");
		header('Location: '.$newURL."?type=".$type."&id=".$id);
		}else{
		$newURL = site_url("/provider/productDetail");
		header('Location: '.$newURL."?type=".$type."&id=".$id);
		}
	}
	}
	}


	public function giftlist()
	{
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
	$div = array();
	$type = "gift";
	$this->load->model('providermodel');
	$productinfo = $this->providermodel->getProduct($type);
	$field = $productinfo['field'];
	$product = $productinfo['product'];
	for($i=1;$i<sizeof($product);$i++){
					$descNum = array();
					foreach ($product[$i] as $key => $value) {
					if($key==$field[sizeof($field)-1]||$key=='photo'){
					}else{
					array_push($descNum,$key);
					}
					}
              	$link=site_url("/provider/productDetail");
				$photo = $product[$i]['photo'];
				$id = $product[$i][$field[0]];
				$photoLink = base_url($photo);
				$price = $product[$i][$field[sizeof($field)-2]];
				$name = $product[$i][$field[1]];
				$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="" width"480" height="360">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4><a href="$link?type=$type&id=$id">$name</a></h4>
                            </div>
                        </div>
                    </div>
EOT;
	
	
		array_push($div,$divdetail);
		}
	$p = array('div' =>$div);
	$this->load->view('productlist',$p);
	}	

	public function decorationlist()
	{
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}

	$div = array();
		$type = "decoration";
	$this->load->model('providermodel');
	$productinfo = $this->providermodel->getProduct($type);
	$field = $productinfo['field'];
	$product = $productinfo['product'];
	for($i=1;$i<sizeof($product);$i++){
					$descNum = array();
					foreach ($product[$i] as $key => $value) {
					if($key==$field[sizeof($field)-1]||$key=='photo'){
					}else{
					array_push($descNum,$key);
					}
					}
				$desc = ""; 
				for($j=2;$j<sizeof($descNum);$j++){
				if($j!=(sizeof($descNum)-1)){
				$desc = $desc.$descNum[$j]." : ".$product[$i][$descNum[$j]]." ";
				}
				}
				$id = $product[$i][$field[0]];
				$photo = $product[$i]['photo'];
				$photoLink = base_url($photo);
				$link=site_url("/provider/productDetail");
				$price = $product[$i][$field[sizeof($field)-2]];
				$name = $product[$i][$field[1]];
			$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4><a href="$link?type=$type&id=$id">$name</a>
                                </h4>
                                <p>$desc</p>
                            </div>
                        </div>
                    </div>
EOT;
	
	
	array_push($div,$divdetail);
		}
		$p = array('div' =>$div);
	$this->load->view('productlist',$p);
	}
	
	public function productlist(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
			$type = $_GET['type'];
	$this->load->model('providermodel');
	$productinfo = $this->providermodel->getProduct($type);
	$field = $productinfo['field'];
	$product = $productinfo['product'];
	$div = array();
	if($type=="photography"){
	for($i=1;$i<sizeof($product);$i++){
		$id = $product[$i][$field[0]];
				$photo = $product[$i]['photo'];
				$photoLink = base_url($photo);
				$link=site_url("/provider/productDetail");
				$email = $product[$i]['email'];
				$name = $product[$i][$field[1]];
				$price = $product[$i][$field[sizeof($field)-2]];
			$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink"  width="480px" height="360px"/>
                            <div class="caption">
                                <h4 class="pull-right">$email</h4>
                                <h4><a href="$link?type=$type&id=$id">$name</a>
                                </h4>
                            </div>
                        </div>
                    </div>
EOT;
	
	
	array_push($div,$divdetail);
	}
	}else{
		for($i=1;$i<sizeof($product);$i++){
				$descNum = array();
					foreach ($product[$i] as $key => $value) {
					if($key==$field[sizeof($field)-1]||$key=='photo'){
					}else{
					array_push($descNum,$key);
					}
					}
				$desc = ""; 
				for($j=2;$j<sizeof($descNum);$j++){
				if($j!=(sizeof($descNum)-1)){
				$desc = $desc.$descNum[$j]." : ".$product[$i][$descNum[$j]]." ";
				}
				}
				$id = $product[$i][$field[0]];
				$photo = $product[$i]['photo'];
				$photoLink = base_url($photo);
				$link=site_url("/provider/productDetail");
				$price = $product[$i][$field[sizeof($field)-2]];
				$name = $product[$i][$field[1]];
			$divdetail = <<<EOT
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="$photoLink" alt="" width"480" height="360">
                            <div class="caption">
                                <h4 class="pull-right">$$price</h4>
                                <h4><a href="$link?type=$type&id=$id">$name</a>
                                </h4>
                                <p>$desc</p>
                            </div>
                        </div>
                    </div>
EOT;
	
	
	array_push($div,$divdetail);
	}
	
	}

	$p = array('div' =>$div);
	
	$this->load->view('productlist',$p);
		
	}
}

?>