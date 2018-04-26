package attributes;

public class RequiredValidator implements AttributeValidate {

    @Override
    public boolean validate(String value) {

        if (value == null || value.isEmpty()) {
            return false;
        }

        return true;
    }
}
