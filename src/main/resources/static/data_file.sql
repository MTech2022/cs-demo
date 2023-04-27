create table Accounts (
	id BIGINT,
	customer_id varchar(16) not null,
	acc_number varchar(16) not null,
	branch_id decimal(8,0),
	balance decimal(16,4)
);

insert into Accounts(id,customer_id,acc_number,branch_id,balance) values (1,'C1','0001',1,1000.00);
insert into Accounts(id,customer_id,acc_number,branch_id,balance) values (2,'C2','0002',1,500.00);
insert into Accounts(id,customer_id,acc_number,branch_id,balance) values (3,'C3','0003',1,501.00);