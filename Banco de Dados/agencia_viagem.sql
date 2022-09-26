create database agencia_viajar;
use agencia_viajar;

create table usuario(
id_usuario int primary key auto_increment,
nome varchar(50),
email varchar(50),
senha varchar(30),
endereco varchar(50)
);

select * from usuario;

create table pedido(
id int primary key auto_increment,
nome varchar(50),
email varchar(50),
telefone int,
destino varchar(40),
aerea varchar(40),
preco double
);

DROP table pedido;

create table destino(
id int primary key auto_increment,
nome varchar(50),
email varchar(50),
telefone int,
destino varchar(40),
aerea varchar(40),
preco int
);

DROP table destino;

select * from destino;