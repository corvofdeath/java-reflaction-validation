package api;

import java.util.ArrayList;

public class ValidatorResult {

    private ArrayList<ValidatorPropertyResult> errors;
    private boolean modelState;

    public ValidatorResult() {
        errors = new ArrayList<ValidatorPropertyResult>();
        modelState = true;
    }

    public ArrayList<ValidatorPropertyResult> getErrors() {
        return errors;
    }

    public boolean isModelState() {
        return modelState;
    }

    public void addError(ValidatorPropertyResult error) {
        modelState = false;
        errors.add(error);
    }
}
