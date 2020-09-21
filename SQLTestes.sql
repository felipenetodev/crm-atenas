use crm_uniatenas;

select * from usuario;
select * from role;
select * from usuario_roles;
select * from cliente;


insert into usuario values ('theabner', '11783586664', true, 'Abner Matheus Gomes Silva', '$2a$10$YPQxUnjl8TG75pQOsH73.eTCzWxFKzqR/mlt8WwDxbLvTUa3H.RKy');
insert into role values ('ROLE_ADMIN', 'Administrador');
insert into role values ('ROLE_ATENDENTE', 'Atendente');
insert into role values ('ROLE_VENDEDOR', 'Vendedor');

insert into usuario_roles values ('biscoito', 'ROLE_ADMIN');

select * from usuario;

-- $2a$10$YPQxUnjl8TG75pQOsH73.eTCzWxFKzqR/mlt8WwDxbLvTUa3H.RKy

drop database crm_uniatenas;

insert into usuario values ('biscoito', '041.487.164-27', true, 'Marcos Gay', '$2a$10$dUu7seHnuF2IhnpiOZ6ZZucok5p2lulL/c/3iBKEEWf.6ZrS.gEem$2a$10$CSsAcKniVmpvJCsToYsXMuHza65iew.x91Srp6pSpWVIgSk/1D8ri');
update usuario set senha = '$2a$10$gW3nS1ct8WM4e6bPqQuBr.mZKWdZZw.APWFgMMWt0U6q3ZxHtS95G' where login = 'biscoito';
update usuario set is_ativo = true where login = 'felipe123';

truncate role;
update usuario_roles set roles_nome_role = 'ROLE_ATENDENTE' where usuarios_login = 'biscoito';

ALTER TABLE usuario DROP COLUMN check_box_marcado;
