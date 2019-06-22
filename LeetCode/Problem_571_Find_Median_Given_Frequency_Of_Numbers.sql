# Write your MySQL query statement below
select  avg(n.Number) median
from Numbers n
where n.Frequency >= 
    abs((select sum(Frequency) from Numbers where Number<=n.Number) -
        (select sum(Frequency) from Numbers where Number>=n.Number))