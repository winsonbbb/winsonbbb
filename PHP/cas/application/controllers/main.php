<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class main extends MY_Controller {

	public function index()
	{
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$client = $_SESSION["client"];
		$bigday = $client->bigDay;
		date_default_timezone_set('Asia/Taipei');
		$currentdate = date('Y-m-d');
$startTimeStamp = strtotime($bigday);
$endTimeStamp = strtotime($currentdate);

$timeDiff = abs($startTimeStamp - $endTimeStamp);

echo $timeDiff;
$numberDays = $timeDiff/86400;  // 86400 seconds in one day

// and you might want to convert to integer
$numberDays = intval($numberDays);
$gfirstname = explode(" ", $client->groomName)[0];
$bfirstname = explode(" ", $client->brideName)[0];

		$p = array(
			'bigday' => $bigday,
			'leftday' =>$numberDays,
			'gname' => $gfirstname,
			'bname' => $bfirstname
			);
	$this->load->view('logedin_index',$p);
	}
	public function Provider()
	{
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$this->load->view('provider');
	}
	public function GuestList()
	{
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$this->load->view('guestlist');
	}
	public function ThreeDRing()
	{
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$this->load->view('3Dmodel');
	}
	public function PackageList()
	{
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$this->load->view('packageList');
	}
	public function Aboutus()
	{
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$this->load->view('aboutUS');
	}
		public function Contact()
	{
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
		$this->load->view('contact');
	}
	public function Ring(){
	if(!isset($_SESSION["client"])){
		redirect(site_url("/"));
		}
	$jid = $_GET['jid'];
	$rid = $_GET['rid'];
	if($jid=="j1"&&$rid=="r1"){
			$this->load->view('/ring/ring1');
	}else if($jid=="j1"&&$rid=="r2"){
			$this->load->view('/ring/ring5');
	}else if($jid=="j1"&&$rid=="r3"){
			$this->load->view('/ring/ring7');
	}else if($jid=="j2"&&$rid=="r1"){
			$this->load->view('/ring/ring2');
	}else if($jid=="j2"&&$rid=="r2"){
			$this->load->view('/ring/ring4');
	}else if($jid=="j2"&&$rid=="r3"){
			$this->load->view('/ring/ring8');
	}else if($jid=="j3"&&$rid=="r1"){
			$this->load->view('/ring/ring3');
	}else if($jid=="j3"&&$rid=="r2"){
			$this->load->view('/ring/ring6');
	}else if($jid=="j3"&&$rid=="r3"){
			$this->load->view('/ring/ring9');
	}
	}




}