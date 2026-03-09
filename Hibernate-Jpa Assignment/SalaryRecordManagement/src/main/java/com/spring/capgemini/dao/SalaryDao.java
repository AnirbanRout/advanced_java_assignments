package com.spring.capgemini.dao;

import com.spring.capgemini.entity.SalaryRecord;

interface SalaryDao {

    void addSalaryRecord(SalaryRecord salaryRecord);

    void updateSalaryRecord(int id, double base_salary);

    void deleteSalaryRecord(int id);

    void getSalaryRecordByEmpCode(int emp_code);

    void getSalaryRecordBySalaryMonth(int salaryMonth);

    void fetchAllSalaryRecords(int id);

}
