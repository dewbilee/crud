INSERT INTO `afsaridb`.`user`(`id`,`name`,`email`,`password`,`role_ids`,`approver_ids`)
VALUES(1,'SuperAdmin','superadmin@mail.com','secret123','[1]','[]');

INSERT INTO `afsaridb`.`user`(`id`,`name`,`email`,`password`,`role_ids`,`approver_ids`)
VALUES(2,'John Doe','johndoe@mail.com','secret123','[2]','[1]');

INSERT INTO `afsaridb`.`user`(`id`,`name`,`email`,`password`,`role_ids`,`approver_ids`)
VALUES(3,'Jane Doe','janedoe@mail.com','secret123','[2]','[1]');