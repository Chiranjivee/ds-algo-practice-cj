# Write your MySQL query statement below
select 
extra as report_reason, COUNT(DISTINCT post_id) as report_count
from actions
where action_date='2019-07-04' and action = "report"
group by extra;
