# Write your MySQL query statement below
SELECT IFNULL(ROUND(SUM(sessions) / SUM(users), 2), 0.0) AS average_sessions_per_user FROM (
    SELECT COUNT(DISTINCT session_id) AS sessions, COUNT(DISTINCT user_id) AS users
    FROM Activity
    WHERE '2019-06-27' < activity_date AND activity_date <= '2019-07-27'
    GROUP BY user_id
) a
