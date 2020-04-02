create table `train_user`(
  `id` varchar(64) not null primary key,
  `user_name` varchar(16) not null comment '用户名',
  `age` int(2) not null comment '年龄',
  `address` varchar(255) comment '地址',
  `phone` varchar(11) comment '手机号码',
  `birth_day` datetime comment '生日',
  `create_time` datetime not null default current_timestamp comment '创建日期',
  `update_time` datetime not null default current_timestamp on update current_timestamp comment  '更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户管理表';