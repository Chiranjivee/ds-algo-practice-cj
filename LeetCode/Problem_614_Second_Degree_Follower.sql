# Write your MySQL query statement below
select distinct follower, num
from follow, 
(select followee, count(distinct follower) as num from follow 
group by followee) as t
where follower = t.followee
order by follower;
