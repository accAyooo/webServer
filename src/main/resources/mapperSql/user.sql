create table user (
  `id` int(10) not null auto_increment,
  `username` varchar(20) not null,
  `password` varchar(30) not null,
  `email` varchar(20) not null,
  `role` int(2) default 0,
  `staff` bool default false,
  `mark` int(2) default 0,
  `last_active_time` date,
  `icon_url_small` varchar(40),
  `icon_url_normal` varchar(40),
  `create_time` date not null,
  `update_time` date not null,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;