package com.study.security.base;

// Mensagens padronizadas
public class SystemMessages {

    public static class System {
        public static final String GENERAL_ERROR        ="SYS-001";
        public static final String SUSPICIOUS_DATA      ="SYS-002";
        public static final String ENTITY_NOT_FOUND     ="SYS-003";
        public static final String DYNAMIC_ERROR        ="SYS-100";
    }

    public static class User {
        public static final String GET_FAIL = "Fail when try to get users.";
        public static final String NO_USERS = "Theres no users.";
        public static final String NOT_FOUND = "Can't find any User with this email.";
        public static final String MISSING_VALUES = "Missing values in fields.";
        public static final String SUCCESS_CREATED = "User successfully created.";
        public static final String SUCCESS_GOT = "User(s) successfully got.";
        public static final String FAIL_CREATE = "Fail when try to created User.";
        public static final String FAIL_UPDATE = "Fail when try to updated User.";
        public static final String SUCCESS_UPDATED = "User successfully updated.";
        public static final String SUCCESS_DELETED = "User successfully deleted.";
        public static final String FAIL_DELETE = "Fail when try to delete user.";
    }

    public static class Auth {
        public static final String MISSING_VALUES = "Missing values in fields.";
        public static final String INVALID_TOKEN = "Invalid token used.";
        public static final String ACCESS_DENIED = "Email or password invalid.";
        public static final String INVALID_CREDENTIALS = "Login must match required patterns.";
        public static final String SUCCESSFULLY_LOGIN = "Successfully Login.";
    }

    public static class Annotation {
        public static final String SUCCESS_DELETED = "Annotation successfully deleted.";
        public static final String FAIL_DELETE = "Fail when try to delete annotation.";
        public static final String FAIL_GET = "Fail when try to get annotation.";
        public static final String NO_ANNOTATIONS = "Theres no annotations.";
        public static final String NOT_FOUND = "Can't find any annotation with this name.";
        public static final String MISSING_VALUES = "Missing values in fields.";
        public static final String SUCCESS_CREATED = "Annotation successfully created.";
        public static final String SUCCESS_GOT = "Annotation(s) successfully got.";
        public static final String FAIL_CREATE = "Fail when try to created Annotation.";
    }
}
