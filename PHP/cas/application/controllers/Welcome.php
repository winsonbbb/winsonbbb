<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class Welcome extends CI_Controller {

	public function index()
	{
		$this->load->view('welcome_message');
	}
	
	public function forget_password()
	{
		$this->load->view('forget_password');
	}
}

/* End of file welcome.php */
/* Location: ./application/controllers/Welcome.php */