create table user (
`id` int(10) not null auto_increment,
`username` varchar(20) not null,
`password` varchar(30) not null,
`head_img_url` varchar(40) default null,
`phone_num` varchar(20) not null,
`role` int(2) default 0,
`create_time` date not null,
`update_time` date not null,
PRIMARY KEY (`id`),
UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;