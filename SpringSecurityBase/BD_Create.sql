CREATE TABLE testdb.user (
  `user_id` binary(16) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `dt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dt_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE testdb.annotation (
  `annotation_id` binary(16) NOT NULL,
  `name` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `user_id` binary(16) NOT NULL,
  PRIMARY KEY (`annotation_id`),
  FOREIGN KEY (`user_id`) REFERENCES testdb.user(`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
