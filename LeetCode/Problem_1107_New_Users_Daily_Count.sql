select login_date, count(1) user_count
from
(select user_id, min(activity_date) login_date
from traffic
where activity = 'login'
group by user_id) a
where login_date between date_add('2019-06-30', interval -90 day) and '2019-06-30'
group by login_date
