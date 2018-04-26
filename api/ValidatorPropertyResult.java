package api;

public class ValidatorPropertyResult {

    private String property;
    private String error;

    public String getError() {
        return error;
    }

    public String getProperty() {
        return property;
    }

    public ValidatorPropertyResult() {

    }

    public ValidatorPropertyResult(String property, String error) {
        this.property = property;
        this.error = error;
    }
}
