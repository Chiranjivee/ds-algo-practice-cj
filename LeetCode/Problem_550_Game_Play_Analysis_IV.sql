# Write your MySQL query statement below
select
round(sum(case when a.min +1 = a2.event_date then 1 else 0 end) / count(distinct a.player_id),2) as fraction
from
(select player_id, min(event_date) as min from activity group by 1) a 
join activity a2 on a.player_id = a2.player_id
