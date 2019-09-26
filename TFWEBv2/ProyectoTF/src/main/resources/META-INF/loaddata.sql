insert into tipoasesorias values(DEFAULT,'PDF', 5.00);
insert into tipoasesorias values(DEFAULT,'WORD', 5.00);
insert into tipoasesorias values(DEFAULT,'PPT', 5.00);
insert into tipoasesorias values(DEFAULT,'EXCEL', 5.00);
insert into tipoasesorias values(DEFAULT,'MP4', 8.50);

insert into tipomateriales values(default,'PRACTICA CALIFICADA 1', 0.00);
insert into tipomateriales values(default,'PRACTICA CALIFICADA 2', 5.00);
insert into tipomateriales values(default,'PRACTICA CALIFICADA 3', 5.00);
insert into tipomateriales values(default,'CONTROL DE LECTURA 1', 0.00);
insert into tipomateriales values(default,'CONTROL DE LECTURA 2', 5.00);
insert into tipomateriales values(default,'CONTROL DE LECTURA 3', 5.00);
insert into tipomateriales values(default,'PRACTICA DE LABORATORIO 1', 0.00);
insert into tipomateriales values(default,'PRACTICA DE LABORATORIO 2', 5.00);
insert into tipomateriales values(default,'PRACTICA DE LABORATORIO 3', 5.00);
insert into tipomateriales values(default,'EXAMEN PARCIAL', 8.00);
insert into tipomateriales values(default,'EXAMEN FINAL', 10.00);

insert into alumnos (codigoAlumno,nombreAlumno,apellidoAlumno,emailAlumno,passwordAlumno) values('U201711943','ALVARO ARTURO','MANRIQUE LUA','upc201711943@gmail.com','123456');
insert into alumnos (codigoAlumno,nombreAlumno,apellidoAlumno,emailAlumno,passwordAlumno) values('U201710223','BRAYANM REYNALDO','REYES HUERTA','reyeshuerta.br@gmail.com','123456');
insert into alumnos (codigoAlumno,nombreAlumno,apellidoAlumno,emailAlumno,passwordAlumno) values('U201714074', 'MIGUEL ALFONSO','CASAS PINILLOS','trabajosmiguelcasas@gmail.com','123456');
insert into alumnos (codigoAlumno,nombreAlumno,apellidoAlumno,emailAlumno,passwordAlumno) values('U201714151', 'GERALDINE VALENTINA','PUNTILLO RAMIREZ','geraldinepr10.gpr@gmail.com','123456');
insert into alumnos (codigoAlumno,nombreAlumno,apellidoAlumno,emailAlumno,passwordAlumno) values('U201619636', 'ALONSO','SALAZAR GARCIA','alonso511@gmail.com','123456');
insert into alumnos (codigoAlumno,nombreAlumno,apellidoAlumno,emailAlumno,passwordAlumno) values('U201714981', 'GIANELLA BERENIZ','CELIS RAMOS','gianebere@gmail.com','123456');

insert into cursos (codigoCurso,nombreCurso) values ('MABSI00001','MATEMÁTICA BÁSICA');
insert into cursos (codigoCurso,nombreCurso) values ('MACSI00001','MATEMÁTICA COMPUTACIONAL');
insert into cursos (codigoCurso,nombreCurso) values ('MADSI00001','MATEMÁTICA DISCRETA');
insert into cursos (codigoCurso,nombreCurso) values ('MAESI00001','MATEMÁTICA ESTADÍSTICA');
insert into cursos (codigoCurso,nombreCurso) values ('MAFSI00001','MATEMÁTICA FINANCIERA');

insert into profesors (codigoProfesor,nombreProfesor,apellidoProfesor,emailProfesor,passwordProfesor,telefonoProfesor,notaProfesor,gradoProfesor,calificacionProfesor) values ('P201711943', 'ALVARO ARTURO', 'MANRIQUE LUA', 'upc201711943@gmail.com', '123456', '944986147', 20,'Master',0);
insert into profesors (codigoProfesor,nombreProfesor,apellidoProfesor,emailProfesor,passwordProfesor,telefonoProfesor,notaProfesor,gradoProfesor,calificacionProfesor) values ('P201710223','BRAYANM REYNALDO','REYES HUERTA','reyeshuerta.br@gmail.com','123456', '996840212', 20,'Master',0);
