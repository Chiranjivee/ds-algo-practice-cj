SELECT
    dept_name, COUNT(student_id) AS student_number
FROM
    department
        LEFT OUTER JOIN
    student ON department.dept_id = student.dept_id
GROUP BY department.dept_name
ORDER BY student_number DESC , department.dept_name
;
