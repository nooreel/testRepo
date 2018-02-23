SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS TB_equipsw;
DROP TABLE IF EXISTS TB_equipment;
DROP TABLE IF EXISTS TB_Employee;
DROP TABLE IF EXISTS TB_department;
DROP TABLE IF EXISTS TB_office;
DROP TABLE IF EXISTS TB_area;
DROP TABLE IF EXISTS TB_sw;




/* Create Tables */

CREATE TABLE TB_area
(
	area_seq int NOT NULL AUTO_INCREMENT,
	areaname varchar(50) NOT NULL,
	created datetime DEFAULT NOW(),
	createdby varchar(50),
	modified datetime DEFAULT NOW(),
	modifiedby varchar(50),
	active int DEFAULT 0,
	PRIMARY KEY (area_seq),
	UNIQUE (area_seq)
);


CREATE TABLE TB_department
(
	office_seq int NOT NULL,
	department_seq int NOT NULL AUTO_INCREMENT,
	departmentname varchar(50) NOT NULL,
	created datetime DEFAULT NOW(),
	createdby varchar(50),
	modified datetime DEFAULT NOW(),
	modifiedby varchar(50),
	active int DEFAULT 0,
	PRIMARY KEY (department_seq),
	UNIQUE (department_seq)
);


CREATE TABLE TB_Employee
(
	area_seq int NOT NULL,
	office_seq int NOT NULL,
	department_seq int NOT NULL,
	employeenumber varchar(50) NOT NULL,
	password varchar(50) NOT NULL,
	birth date,
	employeename varchar(50) NOT NULL,
	employeeposition varchar(50) NOT NULL,
	created datetime DEFAULT NOW(),
	createdby varchar(50),
	modified datetime DEFAULT NOW(),
	modifiedby varchar(50),
	privilege int NOT NULL,
	email varchar(50),
	active int DEFAULT 0,
	PRIMARY KEY (employeenumber),
	UNIQUE (employeenumber)
);


CREATE TABLE TB_equipment
(
	equipmentid varchar(50) NOT NULL,
	equipmenttype varchar(50) NOT NULL,
	equipmentip varchar(50) NOT NULL,
	assetYN int NOT NULL,
	nclientsetup int NOT NULL,
	employeenumber varchar(50) NOT NULL,
	created datetime DEFAULT NOW(),
	createdby varchar(50),
	modified datetime DEFAULT NOW(),
	modifiedby varchar(50),
	active int DEFAULT 0,
	PRIMARY KEY (equipmentid),
	UNIQUE (employeenumber)
);


CREATE TABLE TB_equipsw
(
	equipsw int NOT NULL AUTO_INCREMENT,
	equipmentid varchar(50) NOT NULL,
	swnumber int NOT NULL,
	created datetime DEFAULT NOW(),
	createdby varchar(50),
	modified datetime DEFAULT NOW(),
	modifiedby varchar(50),
	active int DEFAULT 0,
	patch_percent int,
	PRIMARY KEY (equipsw)
);


CREATE TABLE TB_office
(
	area_seq int NOT NULL,
	office_seq int NOT NULL AUTO_INCREMENT,
	officename varchar(50) NOT NULL,
	created datetime DEFAULT NOW(),
	createdby varchar(50),
	modified datetime DEFAULT NOW(),
	modifiedby varchar(50),
	active int DEFAULT 0,
	PRIMARY KEY (office_seq)
);


CREATE TABLE TB_sw
(
	swnumber int NOT NULL AUTO_INCREMENT,
	swname varchar(50) NOT NULL,
	swversion varchar(50) NOT NULL,
	created datetime DEFAULT NOW(),
	createdby varchar(50),
	modified datetime DEFAULT NOW(),
	modifiedby varchar(50),
	swtype varchar(50),
	Bit varchar(10),
	active int DEFAULT 0,
	maker varchar(50),
	used varchar(50),
	quantity int,
	PRIMARY KEY (swnumber),
	UNIQUE (swnumber)
);



/* Create Foreign Keys */

ALTER TABLE TB_Employee
	ADD FOREIGN KEY (area_seq)
	REFERENCES TB_area (area_seq)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE TB_office
	ADD FOREIGN KEY (area_seq)
	REFERENCES TB_area (area_seq)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE TB_Employee
	ADD FOREIGN KEY (department_seq)
	REFERENCES TB_department (department_seq)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE TB_equipment
	ADD FOREIGN KEY (employeenumber)
	REFERENCES TB_Employee (employeenumber)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE TB_equipsw
	ADD FOREIGN KEY (equipmentid)
	REFERENCES TB_equipment (equipmentid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE TB_department
	ADD FOREIGN KEY (office_seq)
	REFERENCES TB_office (office_seq)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE TB_Employee
	ADD FOREIGN KEY (office_seq)
	REFERENCES TB_office (office_seq)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE TB_equipsw
	ADD FOREIGN KEY (swnumber)
	REFERENCES TB_sw (swnumber)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



