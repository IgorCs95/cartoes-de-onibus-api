CREATE TABLE cartao(	
	numero_cartao INTEGER PRIMARY KEY,
   	nome VARCHAR(50) NOT NULL,
   	status VARCHAR(100) NOT NULL,
   	tipo_cartao VARCHAR(100) NOT NULL,
   	user_id INT NOT NULL,
   	CONSTRAINT cartao_user_id_fkey 
   	FOREIGN KEY (user_id) REFERENCES users(id)
 	ON DELETE CASCADE
 	ON UPDATE CASCADE
);