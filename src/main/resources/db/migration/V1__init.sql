create table PACIENTZ(
id MEDIUMINT auto_increment primary key,
ds_nome VARCHAR(255) not null,
dt_nascimento DATE not null,
tipo_sangue varchar(3) not null,
cpf varchar(11) not null,
ds_status boolean default false
);

insert into PACIENTZ(ds_nome, dt_nascimento, tipo_sangue, cpf, ds_status) values ('Fabio', '2000-10-15', 'AB+', '12345678910', true);