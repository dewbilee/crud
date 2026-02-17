INSERT INTO `afsaridb`.`permission`(`id`,`name`,`path`,`actions`)
VALUES(1,'PERMISSION_READ','/portal/api/permissions/**','["GET"]');

INSERT INTO `afsaridb`.`permission`(`id`,`name`,`path`,`actions`)
VALUES(2,'PERMISSION_WRITE','/portal/api/permissions','["POST","PUT","DELETE"]');

INSERT INTO `afsaridb`.`permission`(`id`,`name`,`path`,`actions`)
VALUES(3,'ROLE_READ','/portal/api/roles/**','["GET"]');

INSERT INTO `afsaridb`.`permission`(`id`,`name`,`path`,`actions`)
VALUES(4,'ROLE_WRITE','/portal/api/roles','["POST","PUT","DELETE"]');