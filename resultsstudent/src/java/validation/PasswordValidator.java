/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author thomas
 */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String>{

    @Override
    public void initialize(ValidPassword constraintAnnotation)
    {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context)
    {
        return password != null && password.length() >= 8 && password.length() <= 255;
    }
}
