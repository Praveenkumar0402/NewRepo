use pubs
create table categories
(
 CatCode varchar(10) constraint categories_catcode_pk primary key,
 CatDesc varchar(50) constraint categories_catdesc_nn not null 
)

create table products
(
ProdId int identity (100,1) constraint products_prodid_pk primary key,

ProdName varchar(30) constraint products_prodname_nn not null,
Price money constraint products_price_chk check (price>=0),
Qoh int default 0,
Remarks varchar(100),
CatCode varchar(10) constraint products_catcode_fk references categories(catcode ) on delete cascade
)

create table sales
(
  Invno int identity constraint sales_invno_pk primary key,
  Prodid int constraint sales_prodid_fk references products(prodid),
  Transdate datetime,
  Qty int constraint sales_qty_chk check(qty > 0),
  Amount money
)

SELECT * from categories



INSERT into categories values('Tp','Think Pad')
INSERT into categories values('Hp','Mouse')
INSERT into categories values('Rr','Range Rover')
INSERT into categories values('Mp','Mobile Phone')
INSERT into categories values('1+','One Plus')
UPDATE categories set CatCode='Buds',CatDesc='Apple' WHERE CatCode='jfg'

insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('Think Pad',57000,5,'New Model','Tp')
insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('Range Rover',9500000,2,'Defender','Rr')
insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('One Plus',30000,10,'G855 Processor','1+')
insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('Mouse',600,7,'Bluetooth','Tp')
insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('Mobile Phone',25000,20,'Amoled Display','Mp')
insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('Laptop',70000,8,'Update Model','Tp')
insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('Audi',3000000,4,'New Model','Rr')
insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('Boat',5000,10,'Bluetooth','Buds')
insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('HeadPhones',2000,25,'Wireless','1+')
insert into products(ProdName,Price,Qoh,Remarks,CatCode) values('Benz',4000000,2,'Updated Model','Rr')

delete from products where ProdId=105

select * from products

select * from sales


insert into sales(ProdId,Transdate,qty,Amount) values(106,'10-09-2022',2,200000)
insert into sales(ProdId,Transdate,qty,Amount) values(104,'02-05-2016',5,2500)
insert into sales(ProdId,Transdate,qty,Amount) values(108,'05-07-2020',7,30000)
insert into sales(ProdId,Transdate,qty,Amount) values(111,'11-27-2012',3,5000)
insert into sales(ProdId,Transdate,qty,Amount) values(115,'09-15-2019',1,25000)
insert into sales(ProdId,Transdate,qty,Amount) values(101,SYSDATETIME(),2,110000)
insert into sales(ProdId,Transdate,qty,Amount) values(114,'07-25-2010',1,9500000)
insert into sales(ProdId,Transdate,qty,Amount) values(107,SYSDATETIME(),1,3000000)
insert into sales(ProdId,Transdate,qty,Amount) values(113,'04-20-2017',5,150000)
insert into sales(ProdId,Transdate,qty,Amount) values(112,SYSDATETIME(),2,8000000)

delete from sales where ProdId=114

select *from sales

use msdb

update products set Price=(price+(Price*0.1)) where Qoh<10

select prodname, left(prodname, charindex(' ',prodname+' ')) from products

select prodname, right(len(prodname), charindex(' ',prodname)) from products

select * from sales where DATEPART(mm,Transdate)=DATEPART(mm,GETDATE())

select Invno,Prodid,Transdate, DATEDIFF(DD,Transdate,GETDATE()) as daysgone,DATEADD(MM,+1,Transdate) as nextDue from sales

select * from sales where DATEDIFF (mm,Transdate,GETDATE())=12

select * from products where ProdName like '%e%e%' 

select sum(Amount) as totalsales,YEAR(transdate) as year from sales group by year(Transdate)



sELECT ProdName, right(len(ProdName),charindex(' ',ProdName)) FROM products

select *from products

SELECT s.Invno,p.Prodname,s.Qty,s.Amount,s.Transdate from sales s JOIN products p on (s.Prodid=p.prodid) group by catcode

alter login[sa] with PASSWORD='Im@ginn0vate'


create table customers
(
Cust_Name varchar(30) constraint customers_Cust_Name_pk primary key,
Email varchar(30),
Mobile_Num varchar(100)
)
select * from customers


insert into customers(Cust_Name,Email,Mobile_Num) values('Jack','jack@gmail.com',9966075612)
select *from projects

create table employees
(
Emp_Id int constraint employees_Emp_Id_pk primary key,
Emp_Name varchar(30)
)

insert into employees(Emp_id,Emp_Name) values(1,'Jenny')
insert into employees(Emp_id,Emp_Name) values(2,'Kane')

select * from employees

select * from otostudent
select * from payments

create table salaries(id int,month varchar(30),salary Bigint primary key(id,month))

insert into salaries values(1,'05/2023',30000)
select * from salaries

select * from employees

select * from salaries

create TABLE otm_department(dep_code varchar(45) primary key , dep_name varchar(50))
create TABLE otm_employees (emp_id int primary key, emp_name varchar(50), salary Bigint, 
dep_code  varchar(45) FOREIGN key references otm_department(dep_code))

select * from otm_department
select * from otm_employees

insert into otm_department values(103,'ECE')
insert into otm_employees values(209,'Praveen',27000,103)


create TABLE mtm_students(stu_id int primary key , stu_name varchar(50))
create TABLE mtm_courses (course_id int primary key, course_name varchar(50))
create TABLE student_course(stu_id int FOREIGN key references mtm_students, course_id int foreign key references mtm_courses)

select * from mtm_courses
select * from mtm_students
select * from student_course

insert into mtm_courses values(104,'Java')
insert into mtm_courses values(102,'Python')
insert into mtm_courses values(103,'JavaScript')
insert into mtm_courses values(101,'C#')

insert into mtm_students values(101,'Ajay')
insert into mtm_students values(102,'Vishnu')
insert into mtm_students values(103,'Rajesh')
insert into mtm_students values(104,'Praveen')

insert into student_course values(101,101)
insert into student_course values(101,102)
insert into student_course values(104,104)
insert into student_course values(104,102)
insert into student_course values(102,103)
insert into student_course values(103,104)

select * from storing
drop table storing

select * from crstable
select * from i3_circle
select * from i3_square
select * from i3_rectangle

select * from categories
select * from products
select * from sales
UPDATE products set Remarks='IronBlades' where ProdId=120

select prodname from products p join sales s on p.ProdId=s.Prodid GROUP by ProdName having sum(s.Amount)>10000

select * from concurencies
drop table concurencies

update products set price=500 where ProdId=104

delete sales where Invno=27

select p.ProdName,s.ProdId,sum(s.Qty) as No_Of_Qty from sales s join products p on p.ProdId=s.Prodid group by s.ProdId,p.ProdName having s.Prodid=108

select c.CatDesc,avg(p.Price) as Average from categories c join products p on c.CatCode=p.CatCode group by CatDesc 

select*from payments

insert into categories values('rp','yftdv')

delete categories where catcode='Mr'

select * from persondetails

create table sb_persons(id int,name varchar(30))
create table sb_employees(empid int,salary money)
create table sb_customers(cusid int,product varchar(30),price money,loyaltypoints int)

select * from ecm_person
select * from ecm_employee
select * from ecm_customer

drop table ecm_person
drop table ecm_employee
drop table ecm_customer

select * from sb_persons
select * from sb_employees
select * from sb_customers

drop table sb_persons
drop table sb_employees
drop table sb_customers
