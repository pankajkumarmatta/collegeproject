CREATE SCHEMA `vgc` ;

-- superadmin
CREATE TABLE `superadmin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Basic SuperAdmin User
INSERT INTO `vgc`.`superadmin` (`id`, `firstname`, `lastname`, `username`, `password`) 
VALUES ('1', 'super', 'admin', 'superadmin', 'password');


-- faculty
CREATE TABLE `faculty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- student
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- branch
CREATE TABLE `branch` (
  `idbranch` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `details` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idbranch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- course
CREATE TABLE `course` (
  `idcourse` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `details` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idcourse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- fee
CREATE TABLE `fee` (
  `idfee` int(11) NOT NULL AUTO_INCREMENT,
  `feename` varchar(45) NOT NULL,
  `studentid` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `paiddate` varchar(45) NOT NULL,
  PRIMARY KEY (`idfee`),
  KEY `feestudentid_idx` (`studentid`),
  CONSTRAINT `feestudentid` FOREIGN KEY (`studentid`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- lesson
CREATE TABLE `lesson` (
  `idlesson` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `lessonname` varchar(45) NOT NULL,
  `plan` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idlesson`),
  KEY `lessoncoursefk_idx` (`courseId`),
  CONSTRAINT `lessoncoursefk` FOREIGN KEY (`courseId`) REFERENCES `course` (`idcourse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- studentbranch
CREATE TABLE `studentbranch` (
  `idstudentbranch` int(11) NOT NULL AUTO_INCREMENT,
  `branchid` int(11) NOT NULL,
  `studentid` int(11) NOT NULL,
  PRIMARY KEY (`idstudentbranch`),
  KEY `sbbranchfk_idx` (`branchid`),
  KEY `sbstudentfk_idx` (`studentid`),
  CONSTRAINT `sbbranchfk` FOREIGN KEY (`branchid`) REFERENCES `branch` (`idbranch`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sbstudentfk` FOREIGN KEY (`studentid`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- studentdetails
CREATE TABLE `studentdetails` (
  `studentdetailsid` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) NOT NULL,
  `address` varchar(150) NOT NULL,
  `gaurdiancontactnumber` varchar(45) NOT NULL,
  `gaurdianname` varchar(45) NOT NULL,
  `gaurdianemail` varchar(45) NOT NULL,
  PRIMARY KEY (`studentdetailsid`),
  KEY `sdstudentfk_idx` (`studentid`),
  CONSTRAINT `sdstudentfk` FOREIGN KEY (`studentid`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- test (examination or assignment)
CREATE TABLE `test` (
  `testid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `isAssignment` int(11) DEFAULT NULL,
  `isExam` int(11) DEFAULT NULL,
  `testdetails` varchar(150) DEFAULT NULL,
  `maxmarkalloted` int(11) DEFAULT NULL,
  PRIMARY KEY (`testid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- studenttest
CREATE TABLE `studenttest` (
  `idstudenttest` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) NOT NULL,
  `testid` int(11) NOT NULL,
  `marksgained` int(11) NOT NULL,
  PRIMARY KEY (`idstudenttest`),
  KEY `ststudentfk_idx` (`studentid`),
  KEY `sttestfk_idx` (`testid`),
  CONSTRAINT `ststudentfk` FOREIGN KEY (`studentid`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sttestfk` FOREIGN KEY (`testid`) REFERENCES `test` (`testid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;