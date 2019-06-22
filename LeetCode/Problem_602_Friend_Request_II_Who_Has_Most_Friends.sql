# Write your MySQL query statement below
select ids as id, cnt as num
from
(
select ids, count(*) as cnt
   from
   (
        select requester_id as ids from request_accepted
        union all
        select accepter_id from request_accepted
    ) as tbl1
   group by ids
   ) as tbl2
order by cnt desc
limit 1
;
