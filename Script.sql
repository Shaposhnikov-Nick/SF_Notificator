create database sfnotificator

use sfnotificator

create table homework(
id int not null auto_increment primary key,
student_name varchar(255),
teacher_name varchar(255),
submission_time date,
check_time date,
checked boolean default false
)

insert into homework(student_name, teacher_name, submission_time, check_time, checked)
values('Ivan Ivanov', 'Petr Petrov', '2022-07-01', null, false)

