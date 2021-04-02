INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MANAGER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO `users_` (`id`, `created_at`, `updated_at`, `email`, `is_disabled`, `is_online`, `name`, `password`, `username`) VALUES
(3, '2020-12-21 03:16:50', '2021-02-09 18:52:21', 'admin@d3h.ma', b'0', b'0', 'amine', '$2a$10$WRl.Xh4Q9yqCjgOayHDnBuv1MQA0hNisLKUPHSmeX9fCjnPgHewwy', 'admin'),
(4, '2020-12-21 04:25:16', '2021-01-24 01:39:39', 'manger@d3h.ma', b'0', b'0', 'user2', '$2a$10$MmjJq5KSJWexXQWg9U4QPuypnZydsZkiw9/lzQb65PXOoNBBu/lRu', 'manager');

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(3, 1),
(4, 2);