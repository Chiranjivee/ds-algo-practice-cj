# Write your MySQL query statement below
SELECT activity_date day,
       count(distinct user_id) active_users
FROM Activity
WHERE activity_date between DATE_SUB('2019-07-27', interval 29 day) and '2019-07-27'
GROUP BY 1
ORDER BY 1 
