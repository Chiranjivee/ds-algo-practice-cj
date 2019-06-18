# Write your MySQL query statement below
select p.project_id, e.employee_id 
from project as p 
inner join employee as e 
on p.employee_id = e.employee_id 
where (p.project_id, e.experience_years) in 
(
    select p.project_id, max(e.experience_years)
    from project as p 
    inner join employee as e
    on p.employee_id = e.employee_id 
    group by p.project_id
)
