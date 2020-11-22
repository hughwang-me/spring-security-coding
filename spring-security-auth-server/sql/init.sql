#用户表
create table if not exists `spring-security-demo`.system_user
(
    user_id int auto_increment
        primary key,
    user_name varchar(255) not null,
    user_password varchar(255) not null,
    user_nickname varchar(255) null,
    user_mail varchar(255) null,
    user_phone varchar(255) null
);

#角色表
create table if not exists `spring-security-demo`.system_role
(
    role_id int auto_increment
        primary key,
    role_name varchar(255) default null,
    role_mark varchar(255) default null
);

#权限表
create table if not exists `spring-security-demo`.system_permission
(
    permission_id int auto_increment
        primary key,
    permission_name varchar(255) default null,
    permission_mark varchar(255) default null
);

#用户角色关联表
create table if not exists `spring-security-demo`.system_user_role_ref
(
    id int auto_increment
        primary key,
    user_id int not null,
    role_id int not null
);

#用户权限关联表
create table if not exists `spring-security-demo`.system_user_permission_ref
(
    id int auto_increment
        primary key,
    user_id int not null,
    permission_id int not null
);
