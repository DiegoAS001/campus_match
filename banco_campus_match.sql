-- drop database campusmatch;

-- select * from estudante;

create database if not exists campusmatch;
use campusmatch;

create table if not exists estudante(
	id bigint not null auto_increment,
    nome varchar(100) not null,
    senha varchar(100) not null,
    cep varchar(8) not null,
    email varchar(100) not null,
    data_nascimento date not null,
    constraint pk_usuario primary key (id),
    constraint uc_estudante UNIQUE (email)
);

create table if not exists instituicao(
	id bigint not null auto_increment,
    nome varchar(100) not null,
    cep varchar(8) not null,
    email varchar(100) not null,
    senha varchar(100) not null,
    numero_mec int not null,
    campus varchar(100) not null,
    publica boolean,
    constraint pk_instituicao primary key (id),
    constraint uc_instituicao UNIQUE (nome, campus)
);

create table if not exists curso(
	id bigint not null auto_increment,
    nome varchar(100) not null,
    periodo enum(
		'MATUTINO',
		'VESPERTINO',
		'NOTURNO',
		'MATUTINO_VESPERTINO',
		'VESPERTINO_NOTURNO',
		'ASSINCRONO'
	),
    duracao int not null,
    modalidade enum(
		'PRESENCIAL',
        'ENSINO_A_DISTANCIA',
        'MISTO'
    ),
    area_conhecimento enum (
		'CIENCIAS_EXATAS_E_DA_TERRA',
		'CIENCIAS_BIOLOGICAS',
		'ENGENHARIAS',
		'CIENCIAS_DA_SAUDE',
		'CIENCIAS_AGRARIAS',
		'CIENCIAS_SOCIAIS_APLICADAS',
		'CIENCIAS_HUMANAS',
		'LINGUISTICA_LETRAS_E_ARTES'),
    constraint pk_curso primary key (id)
);


create table if not exists infraestrutura(
	id bigint not null auto_increment,
    descricao varchar(100) not null,
    constraint pk_infraestrutura primary key (id)
);

create table if not exists publicacao(
	id bigint not null auto_increment,
    descricao varchar(100) not null,
    data_publicacao timestamp not null,
    constraint pk_publicacao primary key (id)
);

create table if not exists favorito(
	id_estudante bigint,
    id_instituicao bigint,
    constraint pk_id_usu_uni primary key (id_estudante, id_instituicao)
);
alter table favorito add foreign key (id_estudante) references estudante(id);
alter table favorito add foreign key (id_instituicao) references instituicao(id);

create table if not exists instituicao_infraestrutura(
	id_instituicao bigint,
    id_infraestrutura bigint,
    constraint pk_id_inst_infra primary key (id_instituicao, id_infraestrutura)
);
alter table instituicao_infraestrutura add foreign key (id_instituicao) references instituicao(id);
alter table instituicao_infraestrutura add foreign key (id_infraestrutura) references infraestrutura(id);

create table if not exists instituicao_curso(
	id_instituicao bigint,
    id_curso bigint,
    constraint pk_id_inst_curso primary key (id_instituicao, id_curso)
);
alter table instituicao_curso add foreign key (id_instituicao) references instituicao(id);
alter table instituicao_curso add foreign key (id_curso) references curso(id);

create table if not exists instituicao_publicacao(
	id_instituicao bigint,
    id_publicacao bigint,
    constraint pk_id_inst_publ_dtp primary key (id_instituicao, id_publicacao)
);
alter table instituicao_publicacao add foreign key (id_instituicao) references instituicao(id);
alter table instituicao_publicacao add foreign key (id_publicacao) references publicacao(id);