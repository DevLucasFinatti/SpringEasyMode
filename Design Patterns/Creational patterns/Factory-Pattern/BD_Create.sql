CREATE TABLE testdb.user (
  `user_id` binary(16) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `dt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dt_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE testdb.vehicle (
    vehicle_id CHAR(36) PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    color VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL
);

CREATE TABLE testdb.car (
    car_id CHAR(36) PRIMARY KEY,
    vehicle_id CHAR(36) NOT NULL,
    wheels_type VARCHAR(50) NOT NULL,
    wheel_drive_type VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    doors_num INTEGER NOT NULL,
    CONSTRAINT fk_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE
);

CREATE TABLE testdb.helicopter (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vehicle_id CHAR(36) NOT NULL,
    propeller_num INT NOT NULL,
    propeller_blades_num INT NOT NULL,
    windows_num INT NOT NULL,
    CONSTRAINT fk_vehicle_helicopter FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE
);

CREATE TABLE testdb.boat (
    boat_id CHAR(36) PRIMARY KEY,
    vehicle_id CHAR(36) NOT NULL,
    chairs_num INT NOT NULL,
    category VARCHAR(50) NOT NULL,
    windows_num INT NOT NULL,
    CONSTRAINT fk_vehicle_boat FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE
);