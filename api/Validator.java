package api;

import attributes.Required;
import attributes.ValidatorFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Validator {

    public static ValidatorResult validate(Class type, Object object) {
        try {

            ValidatorResult result = new ValidatorResult();

            for (Method method : type.getDeclaredMethods()) {
                Annotation[] annotations = method.getDeclaredAnnotations();

                ValidatorPropertyResult modelState;
                String value;

                for (Annotation annotation : annotations) {

                    value = (String) method.invoke(object);
                    modelState = resolveValidation(annotation, method.getName(), value);

                    if (modelState != null)
                        result.addError(modelState);
                }

                return result;
            }

            return new ValidatorResult();
        } catch (Exception e) {
            ValidatorResult result = new ValidatorResult();
            result.addError(new ValidatorPropertyResult("Exception", "Try Catch error"));
        }

        return new ValidatorResult();
    }

    private static String getPropertyName(String method) {
        return method.substring(3);
    }

    // =========================== Identifies Annotation Type ================================================

    private static ValidatorPropertyResult resolveValidation(Annotation annotation, String methodName, String value) {

        if (annotation.annotationType().equals(Required.class))
            return requiredValidator(annotation, methodName, value);
        // else if (annotation.annotationType().equal(MeuAnnotation.class))
        //   return meuValidator(annotation, methodName, value);
        // ...

        return null;
    }

    // ========================== Annotations Validator by Type ==============================================

    private static ValidatorPropertyResult requiredValidator(Annotation annotation, String methodName, String value) {

        try {
            boolean result = ValidatorFactory.getValidator(Required.class).validate(value);

            if (!result) {

                Required requiredAnnotation = (Required) annotation;
                String property = getPropertyName(methodName);
                String error = property + " " + requiredAnnotation.errorMessage();

                return new ValidatorPropertyResult(property, error);
            }

            return null;
        } catch (Exception ex) {
            // logger or throw exception
            return null;
        }
    }
}
