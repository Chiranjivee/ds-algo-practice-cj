# Write your MySQL query statement below
select 
business_id

from events as a
left join
    (
    select event_type, avg(occurences) as av
    from events
    group by event_type
    ) as b
on a.event_type = b.event_type
where a.occurences > b.av
group by business_id
having count(*)>1;
