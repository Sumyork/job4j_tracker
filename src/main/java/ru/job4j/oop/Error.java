package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void errorInfo() {
        System.out.println("active: " + active + ", status: " + status + ", message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error errorNotFound = new Error(false, 404, "Not found");
        Error errorInternalServerError = new Error(false, 500, "Internal Server Error");
        Error errorOk = new Error(true, 200, "OK");
        error.errorInfo();
        errorNotFound.errorInfo();
        errorInternalServerError.errorInfo();
        errorOk.errorInfo();
    }
}
