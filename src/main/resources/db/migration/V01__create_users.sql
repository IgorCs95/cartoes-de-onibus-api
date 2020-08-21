CREATE TABLE users(	
	id SERIAL PRIMARY KEY,
   	nome VARCHAR(50) NOT NULL,
   	email VARCHAR(100) UNIQUE,
   	senha VARCHAR(100) NOT NULL
);

INSERT INTO users (nome,email,senha) values ('Igor','igor@gmail.com','123');
INSERT INTO users (nome,email,senha) values ('Pessoa1','pessoa1@gmail.com','123');
INSERT INTO users (nome,email,senha) values ('Pessoa2','pessoa2r@gmail.com','123');
INSERT INTO users (nome,email,senha) values ('Pessoa3','pessoa3@gmail.com','123');
INSERT INTO users (nome,email,senha) values ('Pessoa4','pessoa4@gmail.com','123');