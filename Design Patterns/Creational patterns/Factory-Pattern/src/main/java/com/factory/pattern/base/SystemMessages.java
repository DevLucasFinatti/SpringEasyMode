package com.factory.pattern.base;

// Mensagens padronizadas
public class SystemMessages {

    public static class System {
        public static final String GENERAL_ERROR        = "SYS-001: General system error.";
        public static final String SUSPICIOUS_DATA      = "SYS-002: Suspicious data detected.";
        public static final String ENTITY_NOT_FOUND     = "SYS-003: Entity not found.";
        public static final String DYNAMIC_ERROR        = "SYS-100: Dynamic error occurred.";
    }

    public static class User {
        public static final String GET_FAIL             = "USER-001: Failed to retrieve users.";
        public static final String NO_USERS             = "USER-002: No users found.";
        public static final String NOT_FOUND            = "USER-003: No user found with the provided email.";
        public static final String MISSING_VALUES       = "USER-004: Missing required fields.";
        public static final String SUCCESS_CREATED      = "USER-005: User successfully created.";
        public static final String SUCCESS_RETRIEVED    = "USER-006: User(s) successfully retrieved.";
        public static final String FAIL_CREATE          = "USER-007: Failed to create user.";
        public static final String FAIL_UPDATE          = "USER-008: Failed to update user.";
        public static final String SUCCESS_UPDATED      = "USER-009: User successfully updated.";
        public static final String SUCCESS_DELETED      = "USER-010: User successfully deleted.";
        public static final String FAIL_DELETE          = "USER-011: Failed to delete user.";
    }

    public static class Auth {
        public static final String MISSING_VALUES       = "AUTH-001: Missing required fields.";
        public static final String INVALID_TOKEN        = "AUTH-002: Invalid token provided.";
        public static final String ACCESS_DENIED        = "AUTH-003: Invalid email or password.";
        public static final String INVALID_CREDENTIALS  = "AUTH-004: Credentials do not match required patterns.";
        public static final String SUCCESS_LOGIN        = "AUTH-005: Successfully logged in.";
    }

    public static class Helicopter {
        public static final String SUCCESS_RETRIEVED    = "HELICOPTER-001: Helicopter(s) successfully retrieved.";
        public static final String NO_VEHICLE           = "HELICOPTER-002: No helicopters found.";
        public static final String GET_FAIL             = "HELICOPTER-003: Failed to retrieve helicopter.";
        public static final String SUCCESS_CREATED      = "HELICOPTER-004: Helicopter successfully created.";
        public static final String SUCCESS_UPDATED      = "HELICOPTER-005: Helicopter successfully updated.";
        public static final String MISSING_VALUES       = "HELICOPTER-006: Missing required fields.";
        public static final String NOT_FOUND            = "HELICOPTER-007: No helicopter found.";
        public static final String SUCCESS_DELETED      = "HELICOPTER-008: Helicopter successfully deleted.";
    }

    public static class Car {
        public static final String SUCCESS_RETRIEVED    = "CAR-001: Car(s) successfully retrieved.";
        public static final String NO_VEHICLE           = "CAR-002: No cars found.";
        public static final String GET_FAIL             = "CAR-003: Failed to retrieve car.";
        public static final String SUCCESS_CREATED      = "CAR-004: Car successfully created.";
        public static final String SUCCESS_UPDATED      = "CAR-005: Car successfully updated.";
        public static final String MISSING_VALUES       = "CAR-006: Missing required fields.";
        public static final String NOT_FOUND            = "CAR-007: No car found.";
        public static final String SUCCESS_DELETED      = "CAR-008: Car successfully deleted.";
    }

    public static class Boat {
        public static final String SUCCESS_RETRIEVED    = "BOAT-001: Boat(s) successfully retrieved.";
        public static final String NO_VEHICLE           = "BOAT-002: No boats found.";
        public static final String GET_FAIL             = "BOAT-003: Failed to retrieve boat.";
        public static final String SUCCESS_CREATED      = "BOAT-004: Boat successfully created.";
        public static final String SUCCESS_UPDATED      = "BOAT-005: Boat successfully updated.";
        public static final String MISSING_VALUES       = "BOAT-006: Missing required fields.";
        public static final String NOT_FOUND            = "BOAT-007: No boat found.";
        public static final String SUCCESS_DELETED      = "BOAT-008: Boat successfully deleted.";
    }
}
