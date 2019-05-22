package company.controller.validators;

import company.hibernate.EmployeeEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return EmployeeEntity.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EmployeeEntity employee = (EmployeeEntity) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "","empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hireDate", "", "empty");
        if (employee.getPersonaldataByPersonalId() == null) {
            throw new RuntimeException("!!! Not Valid Personal Data !!!");
        }
        if (employee.getEmployeejobsHistoriesById() == null) {
            throw new RuntimeException("!!! Not Valid History !!!");
        }
    }
}
