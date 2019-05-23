package company.utils;

public class SearchParamsBean {
    private Integer id;
    private Integer jobId;
    private Integer departmentId;
    private Double salaryDownLimit;
    private Double salaryUpLimit;
    private String firstName;
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Double getSalaryDownLimit() {
        return salaryDownLimit;
    }

    public void setSalaryDownLimit(Double salaryDownLimit) {
        this.salaryDownLimit = salaryDownLimit;
    }

    public Double getSalaryUpLimit() {
        return salaryUpLimit;
    }

    public void setSalaryUpLimit(Double salaryUpLimit) {
        this.salaryUpLimit = salaryUpLimit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
