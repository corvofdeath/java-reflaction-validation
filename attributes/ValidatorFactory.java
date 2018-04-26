package attributes;

import java.util.HashMap;

public class ValidatorFactory {

    private static HashMap<Class, AttributeValidate> validators = new HashMap<>();

    public static AttributeValidate getValidator(Class annotationType) throws Exception {

        AttributeValidate validator = validators.get(annotationType);

        if (validator == null) {

            try {
                String validatorClassName = annotationType.getName() + "Validator";
                Class objectClass = Class.forName(validatorClassName);
                validator = (AttributeValidate) objectClass.newInstance();

                validators.put(annotationType, validator);

                return validator;
            } catch (Exception ex) {
                throw ex;
            }
        }

        return validator;
    }
}
