-- pacientz.pacientz definition
CREATE TABLE pacientz (
  id mediumint(9) NOT NULL AUTO_INCREMENT,
  ds_nome varchar(255) NOT NULL,
  dt_nascimento date NOT NULL,
  tipo_sangue varchar(3) NOT NULL,
  cpf varchar(11) NOT NULL,
  status tinyint(1) DEFAULT 0,
  PRIMARY KEY (id)
);

-- pacientz.usuarios definition
CREATE TABLE usuarios (
  id mediumint(9) NOT NULL AUTO_INCREMENT,
  ds_nome varchar(255) NOT NULL,
  ds_email varchar(255) NOT NULL,
  ds_senha varchar(255) NOT NULL,
  PRIMARY KEY (id)
);
