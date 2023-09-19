create database Registration

create table users(id int primary key identity(100,1),
                first_name varchar(30) not null,
                last_name varchar(30) not null,
                gender int not null,
                email varchar(50) not null unique,
                userstatus int not null,
                mobile varchar(20) not null unique check (mobile LIKE '[6-9]%' AND LEN(mobile) = 10 and mobile NOT LIKE '%[^0-9]%')                          
)

create table booking(id int primary key identity(200,1),
                    from_adr varchar(50) not null,
                    to_adr varchar(50) not null,
                    bookingdate datetime,
                    status varchar(30) not null,
                    state_of_travel int,
                    uid int foreign key references users(id) on delete cascade
)

create table bus(id int primary key identity(500,1),
                uid int foreign key references users(id) on delete cascade,
                bnumber int,
                booking_seatno int,
                seats_availability int,
                totalseats int,
                bid int foreign key references booking(id)
)

create table train(id int primary key identity(600,1),
                uid int foreign key references users(id),
                tnumber int,
                booking_seatno int,
                seats_availability int,
                totalseats int,
                bid int foreign key references booking(id) on delete cascade
)

create table flight(id int primary key identity(700,1),
                uid int foreign key references users(id),
                fnumber int,
                booking_seatno int,
                seats_availability int,
                totalseats int,
                bid int foreign key references booking(id) on delete cascade
)


select * from users;
select * from booking;
select * from bus;
select * from train;
select * from flight;

-- drop table users;
-- drop table booking;
-- drop table bus;
-- drop table train;
-- drop TABLE flight;

insert into users values('Praveen','Kumar','0','praveen@gmail.com','1','9966074841');
insert into users values('Dinesh','Kumar','0','dinesh@gmail.com','0','9056074123');
insert into users values('Shyam','Kumar','0','shyam@gmail.com','0','9967074568');
insert into users values('Ajay','Kumar','0','ajay@gmail.com','1','7786074842');
insert into users values('Santhoshi','Y','1','santhoshi@gmail.com','1','8088045623');


insert into booking values('Hyderabad','Pulivendula',CURRENT_TIMESTAMP,'Confirmed','0',100);
insert into booking values('Vishakhapatnam','Ananthapur',CURRENT_TIMESTAMP,'Confirmed','1',101);
insert into booking values('Hyderabad','Vijayawada',CURRENT_TIMESTAMP,'Cancelled','2',102);
insert into booking values('Vijayawada','Pulivendula',CURRENT_TIMESTAMP,'Cancelled','0',100);
insert into booking values('Vishakhapatnam','Vijayawada',CURRENT_TIMESTAMP,'Confirmed','1',101);
insert into booking values('Hyderabad','Bangalore',CURRENT_TIMESTAMP,'Confirmed','2',102);
insert into booking values('Vishakhapatnam','Vijayawada',CURRENT_TIMESTAMP,'Confirmed','1',103);


insert into bus values(100,6201,2,19,20,200);
insert into bus values(100,6201,1,18,20,203);

insert into train values(103,12718,6,49,50,207);
insert into train values(102,12718,10,48,50,206);

insert into flight values(102,1602,3,29,30,205);
insert into flight values(102,1602,7,28,30,205);


SELECT t.uid from users u join booking b on b.uid=u.id join train t on t.uid=u.id 
where b.uid=102 and t.uid=102 and u.id=102;

select * from flight;
select f.totalseats-count(f.booking_seatno) as bookingcount from flight f where f.fnumber=1602 group by totalseats;

SELECT * FROM STRING_SPLIT('Lorem ipsum dolor sit amet.', ' ', 1);
select * from string_split('H.no-75,s.Palli,vemula,kadapa,india',',');



insert into roles values('praveen','praveen13@gmail.com','jvcbcuwvqceuyvc@7v%*@$cbewucu','ROLE_ADMIN');
insert into roles values('Dinesh','dinesh13@gmail.com','password','ROLE_ADMIN');
 
create table user_roles(id int primary key identity(100,1),
                        name varchar(30),
                        email varchar(30),
                        password varchar(255),
                        roles varchar(30)
)

--  drop table user_roles
select * from user_roles
delete user_roles where id=100

update user_roles set roles='ROLE_USER' where id=102