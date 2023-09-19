create database Hotel

create table customers
(
    cid int constraint customers_id_pk primary key IDENTITY(100,1),
    cname varchar(30) constraint customers_name_nn not null,
    email varchar(30) not null unique,
    mobile varchar(30) not null check (NOT [mobile] like '%[^0-9]%'),
    gender varchar(20) not null, constraint customers_gender_chk check(gender='male' or gender ='female' or gender ='others')
)

create table rooms 
(
    roomnumber int constraint rooms_roomnumber_pk primary key,
    floor int constraint rooms_floor_nn not null,
    roomtype varchar(30) constraint rooms_roomtype_chk check(roomtype='Deluxe' or roomtype='Executive' or roomtype='Suite'),
    bedtype varchar(30) constraint rooms_bedtype_chk check(bedtype='Twin' or bedtype='Queen' or bedtype='King'),
    tariff money not null,
    roomstatus varchar(30) constraint rooms_status_chk check(roomstatus='Available' or roomstatus='Occupied')
)


create table bookinghistories
(
    bookingid int constraint bookinghistories_bookingid_pk primary key identity(210,1), 
    cid int not null constraint bookinghistories_custid_fk references customers(cid) on delete cascade,
    roomnumber int not null constraint bookinghistories_roomnumber_fk references rooms(roomnumber) on delete cascade,
    startdate date constraint bookinghistories_startdate_nn not null,
    enddate date constraint bookinghistories_enddate_nn not null
)


create table upcomingbookings
(
    upbid int constraint upcomingbookings_upbid_pk primary key identity(1110,1),
    cid int constraint upcomingbookings_cid_fk references customers(cid) on delete cascade,
    upstartdate date constraint upcomingbookings_upstartdate_nn not null,
    roomtype varchar(30) constraint upcomingbookings_roomtype_chk check(roomtype='Deluxe' or roomtype='Executive' or roomtype='Suite'),
    bedtype varchar(30) constraint upcomingbookings_bedtype_chk check(bedtype='Twin' or bedtype='Queen' or bedtype='King'),
    noofrooms int constraint upcomingbookings_noofrooms_nn not null
)

insert into customers values('Ajay','ajaykumar@gmail.com',7053827745,'male')
insert into customers values('Vishnu','maruthivishnu@gmail.com',9133077234,'male')
insert into customers values('Dakshayani','dakshayani123@gmail.com',9988452817,'female')
insert into customers values('Rajesh','rajesh222@gmail.com',8096036458,'male')
insert into customers values('Teja','teja1998@gmail.com',9133077278,'female')
insert into customers values('Dinesh','dinesh@gmail.com',7789684532,'male')
insert into customers values('Gowtham','gowtham@gmail.com',9867326462,'male')
insert into customers values('Arun','arunkumar99@gmail.com',9100564232,'male')
insert into customers values('Maha','maha1709@gmail.com',9565463245,'female')
insert into customers values('Naveen','naveen@gmail.com',7096882345,'male')

insert into rooms values(201,2,'Deluxe','King',2000,'Occupied')
insert into rooms values(301,3,'Executive','Twin',3000,'Available')
insert into rooms values(401,4,'Suite','Queen',10000,'Available')
insert into rooms values(503,5,'Executive','King',15000,'Available')
insert into rooms values(601,6,'Suite','Twin',8000,'Available')
insert into rooms values(202,2,'Deluxe','King',20000,'Occupied')
insert into rooms values(203,2,'Executive','Twin',13000,'Available')
insert into rooms values(303,3,'Suite','Queen',15000,'Available')
insert into rooms values(304,3,'Executive','King',18000,'Occupied')
insert into rooms values(502,5,'Suite','Twin',8000,'Available')
insert into rooms values(204,2,'Executive','Queen',15000,'Available')
insert into rooms values(402,4,'Suite','Twin',18000,'Occupied')
insert into rooms values(504,5,'Deluxe','Twin',20000,'Occupied')
insert into rooms values(403,4,'Executive','Queen',13000,'Occupied')
insert into rooms values(602,6,'Suite','King',15000,'Available')
insert into rooms values(404,4,'Deluxe','Queen',18000,'Occupied')
insert into rooms values(603,6,'Deluxe','Twin',8000,'Available')
insert into rooms values(205,2,'Suite','King',15000,'Occupied')
insert into rooms values(302,3,'Suite','Queen',18000,'Occupied')
insert into rooms values(604,6,'Deluxe','Queen',20000,'Available')

insert into bookinghistories values(101,201,'10-26-2022','10-29-2022')
insert into bookinghistories values(100,301,'02-13-2023','02-14-2023')
insert into bookinghistories values(102,401,'05-16-2010','05-18-2010')
insert into bookinghistories values(103,501,'07-13-2015','07-15-2015')
insert into bookinghistories values(104,601,'09-22-2018','09-25-2018')
insert into bookinghistories values(108,202,'10-09-2020','10-19-2020')
insert into bookinghistories values(105,304,'02-10-2021','02-14-2021')
insert into bookinghistories values(109,203,'04-12-2011','04-20-2011')
insert into bookinghistories values(107,502,'01-11-2016','01-15-2016')
insert into bookinghistories values(106,303,'11-22-2019','11-27-2019')

insert into upcomingbookings values(101,'07-18-2023','Suite','Queen','1')
insert into upcomingbookings values(100,'08-11-2023','Deluxe','Twin','2')
insert into upcomingbookings values(102,'02-15-2024','Deluxe','Queen','4')
insert into upcomingbookings values(103,'09-20-2023','Executive','Twin','3')
insert into upcomingbookings values(102,'11-27-2019','Suite','King','5')
insert into upcomingbookings values(100,'07-18-2023','Suite','Queen','1')
insert into upcomingbookings values(106,'05-08-2024','Executive','King','2')
insert into upcomingbookings values(105,'09-10-2023','Deluxe','Twin','4')
insert into upcomingbookings values(101,'01-20-2024','Suite','Queen','1')
insert into upcomingbookings values(107,'10-15-2023','Executive','Twin','5')
insert into upcomingbookings values(104,'12-20-2023','Suite','King','2')
insert into upcomingbookings values(100,'11-18-2023','Deluxe','Queen','3')


select * from customers
select * from rooms
select* from bookinghistories
select * from upcomingbookings


select * from rooms
select * from customers
select * from rooms where roomtype='Deluxe'
select roomtype,bedtype from rooms where roomstatus='Available'
select * from upcomingbookings
select * from upcomingbookings where cid=107

update rooms set roomstatus='Available' where roomnumber=201


select count(*)noofrooms from rooms r where r.roomstatus='Available' and r.roomtype='Suite' and 
bedtype='King' and not EXISTS (select * from upcomingbookings b where upstartdate between '2023-10-10' and '2023-10-13')

select * from upcomingbookings


create table users(User_id int CONSTRAINT Userid_pk PRIMARY KEY identity(100,1),
                First_name varchar(30) not null,
                Last_name varchar(30) not null,
                Gender varchar(10) not null check(gender='male' or gender ='female' or gender ='others'),
                Email varchar(50) not null unique,
                Mobile VARCHAR(20) not null unique CHECK (Mobile LIKE '[6-9]%' AND LEN(Mobile) = 10 and Mobile NOT LIKE '%[^0-9]%'),
                --Addrees varchar(50),
                date DATETIME
)


select * from person

insert into person values('Praveen',24)
insert into person values('Dinesh',22)
insert into person values('Prasanna',25)
insert into person values('N Praveen',24)
insert into person values('Maha',25)
insert into person values('Vardhan',23)
insert into person values('Usha',24)

select * from Student