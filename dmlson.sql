drop table if exists outpatient;
drop table if exists operation;
drop table if exists bill;
drop table if exists inpatient;
drop table if exists test;
drop table if exists appointments;
drop table if exists user;
drop table if exists nurses; 
drop table if exists doctor;
drop table if exists department;
drop table if exists patient;
drop table if exists manager;
drop table if exists room;

create table department (
   dept_id varchar(6),
   dept_name varchar(50),
   primary key(dept_id));

create table user (
    id char(5),
    name varchar(50) not null,
    surname varchar(50) not null,
    address varchar(100),
    phone_number varchar(11) not null,
    email varchar(100),
    user_type varchar(10) not null,
    primary key(id));

create table nurses (
    id char references user(id) on delete cascade ,
    dept_id varchar(5)  ,
    patient_count varchar(1),
    degree varchar(30),
    primary key(id),
    foreign key(dept_id) references department(dept_id)  );
   
create table doctor (
    id char references user(id) on delete cascade,
    dept_id varchar(5),
    available_hours time,
    available_dates date,
    ranking varchar(30),
    primary key(id),
	foreign key(dept_id) references department(dept_id));

create table patient (
    id char  references user(id) on delete cascade,
    age varchar(2),
    gender varchar(6),
    primary key(id));
    
create table manager (
    id char  references user(id) on delete cascade,
    authority varchar(50),
    primary key(id));

create table appointments (
     appointment_id varchar(8),
     doctor_id char(5),
     patient_id char (5),
     appointment_date date,
     appointment_time time,
     primary key(appointment_id),
     foreign key(doctor_id) references doctor(id) ,
     foreign key(patient_id) references patient(id) );

create table test (
      test_no varchar(5),
      disease varchar (100),
	  appointment_id varchar(8),
	  isInpatient boolean,
      primary key (test_no),
	  foreign key(appointment_id) references appointments(appointment_id) on delete restrict);

create table room (
    room_id varchar(4),
    status varchar(20),
    room_type varchar(20),
    patient_count varchar(2),
    primary key(room_id));

create table inpatient (
    id char references patient(id),
	discharge_date date,
    arrival_date date,
    room_id varchar(4),
    test_no varchar(5),
    primary key(id,test_no),
    foreign key(test_no) references test(test_no) ,
	foreign key(room_id) references room(room_id) on delete set null);

create table outpatient (
	id char references patient(id),
    test_no varchar(5),
    primary key(id,test_no),
    foreign key(test_no) references test(test_no) on delete cascade);

create table operation (
      operation_id int(7),
      name varchar(100),
      doctor_id char (5) references doctor(id) ,
	  patient_id char (5) references patient(id), 
      nurses_id char (5) references nurses(id) ,
      operation_room_id varchar(4),
      operation_date Date,
      operation_time time,
      primary key(operation_id),
      foreign key(doctor_id) references doctor(id) on delete restrict,
	  foreign key(nurses_id) references nurses(id) ,
      foreign key(patient_id) references patient(id) on delete restrict,
	  foreign key(operation_room_id) references room(room_id) on delete set null);
      
create table bill (
      bill_no varchar(10),
      insurance varchar(50),
      patient_id char (5) references patient(id), 
      primary key(bill_no),
	  foreign key(patient_id) references patient(id) on delete restrict);