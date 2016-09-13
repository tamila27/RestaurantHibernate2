ALTER TABLE EMPLOYEE ADD COLUMN dtype varchar(20);

alter table EMPLOYEE drop foreign key POSITION_FK;

alter table EMPLOYEE modify POSITION varchar(20) not null;

drop table `positions`;

alter table Dish drop foreign key category_fk;

drop table category;

alter table Dish modify Category varchar(20) not null;

alter table DISHES_INGREDIENTS add column QUANTITY int not null;