<?php
 
class DbOperation
{
    //Link de conexão com banco de dados
    private $con;
 
    //Construtor da classe
    function __construct()
    {
        // Obtendo o arquivo DbConnect.php
        require_once dirname(__FILE__) . '/DbConnect.php';
 
        // Criando um objeto DbConnect para se conectar ao banco de dados
        $db = new DbConnect();
 
        
		// Inicializando o link de conexão
        // chamando o método connect da classe DbConnect
        $this->con = $db->connect();
    }
	
	/*
	* Operação de criação
	* Quando esse método é chamado, um novo registro é criado no banco de dados
	*/
	function createclientes($nome, $email, $telefone, $cpf){
		$stmt = $this->con->prepare("INSERT INTO clientes (nome, email, telefone, cpf) VALUES (?, ?, ?, ?)");
		$stmt->bind_param("ssis", $nome, $email, $telefone, $cpf);
		if($stmt->execute())
			return true; 
		return false; 
	}	
	
	//A operação de leitura
	//Quando este método é chamado, ele está retornando todo o registro existente do banco de dados
	function getclientes(){
		$stmt = $this->con->prepare("SELECT codclientes, nome, email, telefone, cpf FROM clientes");
		$stmt->execute();
		$stmt->bind_result($codclientes, $nome, $email, $telefone, $cpf);
		
		$clientes = array(); 
		
		while($stmt->fetch()){
			$cliente  = array();
			$cliente['codclientes'] = $codclientes; 
			$cliente['nome'] = $nome; 
			$cliente['email'] = $email; 
			$cliente['telefone'] = $telefone;
			$cliente['cpf'] = $cpf;
			
			array_push($clientes, $cliente); 
		}
		
		return $clientes; 
	}

	//*****************
	// U S U A R I O S
	//Inserindo dados na tabela de usuarios
	 function createusuario($CODTIPO, $EMAIL, $SENHA){
	 	$stmt = $this->con->prepare("INSERT INTO usuarios (codtipo, email, senha) VALUES (1, ?, ?)");
	 	$stmt->bind_param("cns", $CODTIPO, $NOME, $SENHA);
	 	if($stmt->execute())
	 		return true; 
	 	return false; 
	 }
	function getusuario(){
			$stmt = $this->con->prepare("SELECT codtipo, email, senha FROM usuarios");
			$stmt->execute();
			$stmt->bind_result($codtipo, $email, $senha);
			
			$usuarios = array(); 
			
			while($stmt->fetch()){
				$usuario  = array();
				$usuario['codtipo'] = $codtipo; 
				$usuario['email'] = $email; 
				$usuario['senha'] = $senha; 
				
				array_push($usuarios, $usuario); 
			}
			
			return $usuarios; 
		}

	
	//A operação de atualização
	//Quando esse método é chamado, o registro com o ID fornecido é atualizado com os novos valores fornecidos
	function updateclientes($codclientes, $nome, $email, $telefone, $cpf){
		$stmt = $this->con->prepare("UPDATE clientes SET nome = ?, email = ? telefone = ?, cpf = ?  WHERE codclientes = ?");
		$stmt->bind_param("ssisi", $codclientes, $nome, $email, $telefone, $cpf);
		if($stmt->execute())
			return true; 
		return false; 
	}		
	
	//A operação de exclusão
	//Quando este método é chamado, o registro é excluído para o ID fornecido
	function deleteclientes($codclientes){
		$stmt = $this->con->prepare("DELETE FROM clientes WHERE codclientes = ? ");
		$stmt->bind_param("i", $codclientes);
		if($stmt->execute())
			return true; 
		
		return false; 
	}



	/*******************************/
	// L O G I N
	/*******************************/
	function loginUsuario($email, $senha, $codUsu){
		$stmt = $this->con->prepare("SELECT EMAIL, SENHA FROM USUARIOS WHERE CODUSU = ? ");
		$stmt->bind_param("es", $nome, $senha, $codUsu);
		if($stmt->execute())
			return true; 
		return false; 
	}
	
	function getUsu(){
		$stmt = $this->con->prepare("SELECT CODUSU, EMAIL, SENHA FROM USUARIOS");
		$stmt->execute();
		$stmt->bind_result($email, $senha, $codUsu);
		
		$usuarios = array(); 
		
		while($stmt->fetch()){
			$usuario  = array(); 
			$usuario['email'] = $email;
			$usuario['senha'] = $senha;
			$usuario['codUsu'] = $codUsu;

			array_push($usuarios, $usuario); 
		}
		
		return $usuarios; 
	}
}