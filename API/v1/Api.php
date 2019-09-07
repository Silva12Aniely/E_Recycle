<?php 

	//Recebendo a classe dboperation
	require_once '../includes/DbOperation.php';
	
	// Método que irá validar todos os parâmetros que estão disponíveis
	// vamos passar os parâmetros necessários para este método

	function isTheseParametersAvailable($params){
		//assumindo que todos os parâmetros estão disponíveis
		$available = true; 
		$missingparams = ""; 
		
		foreach($params as $param){
			if(!isset($_POST[$param]) || strlen($_POST[$param])<=0){
				$available = false; 
				$missingparams = $missingparams . ", " . $param; 
			}
		}
		
		
		//se os parâmetros estiverem faltando
		if(!$available){
			$response = array(); 
			$response['error'] = true; 
			$response['message'] = 'Parameters ' . substr($missingparams, 1, strlen($missingparams)) . ' missing';
			
			//exibindo os erros
			echo json_encode($response);
			
			//parando a execução adicional
			die();
		}
	}
	
	//matriz para exibir a resposta
	$response = array();
	
	
	// se for uma chamada de API
	// isso significa que um parâmetro get chamado api call é definido na URL
	// e com este parâmetro estamos concluindo que é uma chamada de API

	if(isset($_GET['apicall'])){
		
		switch($_GET['apicall']){
			
			//******************
			// a operação CREATE
			case 'createclientes':
				//primeiro verifique os parâmetros necessários para este pedido estão disponíveis ou não
				isTheseParametersAvailable(array('nome', 'email', 'telefone', 'cpf'));
				$db = new DbOperation();
				
				
				//criando um novo registro no banco de dados
				$result = $db->createclientes(
					$_POST['nome'],
					$_POST['email'],
					$_POST['telefone'],
					$_POST['cpf'],
				);
				

				// se o registro for criado com sucesso
				if($result){
					//registro é criado significa que não há erro
					$response['error'] = false; 

					//na mensagem temos uma mensagem de sucesso
					$response['message'] = 'Cadastrado(a) com sucesso! Realize o login';

					//e estamos recebendo todos os heróis do banco de dados
					$response['clientes'] = $db->getclientes();
				}else{

					// se o registro for não, significa que há um erro
					$response['error'] = true; 

					// e nós temos a mensagem de erro
					$response['message'] = 'Ocorreu um erro. Por favor tente novamente';
				}
				
			break; 
			
			// a operação escrita
			// se a chamada for getheroes
			case 'getclientes':
				$db = new DbOperation();
				$response['error'] = false; 
				$response['message'] = 'Pedido concluído com sucesso';
				$response['clientes'] = $db->getclientes();
			break; 

			//****************
			// U S U A R I O
			case 'createusuario':
				//primeiro verifique os parâmetros necessários para este pedido estão disponíveis ou não
				isTheseParametersAvailable(array('codtipo', 'email', 'senha'));
				$db = new DbOperation();
				
				
				//criando um novo registro no banco de dados
				$result = $db->createusuario(
					$_POST['codtipo'],
					$_POST['email'],
					$_POST['senha'],
				);
				

				// se o registro for criado com sucesso
				if($result){
					//registro é criado significa que não há erro
					$response['error'] = false; 

					//na mensagem temos uma mensagem de sucesso
					$response['message'] = 'Cadastrado(a) com sucesso! Realize o login';

					//e estamos recebendo todos os heróis do banco de dados
					$response['usuario'] = $db->getusuario();
				}else{

					// se o registro for não, significa que há um erro
					$response['error'] = true; 

					// e nós temos a mensagem de erro
					$response['message'] = 'Ocorreu um erro. Por favor tente novamente';
				}
				
			break; 
			
			case 'getusuario':
				$db = new DbOperation();
				$response['error'] = false; 
				$response['message'] = 'Pedido de usuario concluído';
				$response['usuario'] = $db->getusuario();
			break; 


			//**********
			//L O G I N 
			//**********
			case 'loginUsuario':
				//primeiro verifique os parâmetros necessários para este pedido estão disponíveis ou não
				isTheseParametersAvailable(array('email', 'senha', 'codusu'));
				
				//criando um novo objeto dboperation
				$db = new DbOperation();
				
				
				//criando um novo registro no banco de dados
				$result = $db->loginusuario(
					$_POST['email'],
					$_POST['senha'],
					$_POST['codusu'],
				);
				
				// se o registro for criado com sucesso
				if($result){
					//registro é criado significa que não há erro
					$response['error'] = false; 

					//na mensagem temos uma mensagem de sucesso
					$response['message'] = 'Bem Vindo(a)!';

					//e estamos recebendo todos os heróis do banco de dados
					$response['usuarios'] = $db->getusu();
				}else{

					// se o registro for não, significa que há um erro
					$response['error'] = true; 

					// e nós temos a mensagem de erro
					$response['message'] = 'Ocorreu um erro. Por favor tente novamente';
				}
				
			break; 
			
			// a operação escrita
			// se a chamada for getUsu
			case 'getUsu':
				$db = new DbOperation();
				$response['error'] = false; 
				$response['message'] = 'Pedido concluído com sucesso';
				$response['usuarios'] = $db->getusu();
			break; 



			
			//*********************
			//operação de alteração
			case 'updateclientes':
				isTheseParametersAvailable(array('codclientes', 'nome', 'email', 'telefone', 'cpf'));
				$db = new DbOperation();
				$result = $db->updatecliente(
					$_POST['codclientes'],
					$_POST['nome'],
					$_POST['email'],
					$_POST['telefone'],
					$_POST['cpf']
				);
				
				if($result){
					$response['error'] = false; 
					$response['message'] = 'Cliente alterado com sucesso';
					$response['clientes'] = $db->getclientes();
				}else{
					$response['error'] = true; 
					$response['message'] = 'Algum erro ocorreu. Por favor tente novamente';
				}
			break; 
			
			//operação de delete
			case 'deleteclientes':

				
			// para a operação delete estamos obtendo um parâmetro GET da url com o id do registro a ser deletado
				if(isset($_GET['codclientes'])){
					$db = new DbOperation();
					if($db->deleteclientes($_GET['codclientes'])){
						$response['error'] = false; 
						$response['message'] = 'Cliente apagado com sucesso';
						$response['Clientes'] = $db->getclientes();
					}else{
						$response['error'] = true; 
						$response['message'] = 'Algum erro ocorreu. Por favor tente novamente';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Nada a excluir. Por favor forneça o id';
				}
			break; 
		}
		
	}else{
		//se não for uma chamada api
		//respondendo com os valores apropriados para array
		$response['error'] = true; 
		$response['message'] = 'Chamada de API inválida.';
	}
	
	//exibindo a resposta na estrutura do JSON
	echo json_encode($response);
