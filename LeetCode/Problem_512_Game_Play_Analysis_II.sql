# Write your MySQL query statement below

SELECT player_id, device_id
FROM Activity
INNER JOIN (
    SELECT player_id id, MIN(event_date) date
    FROM Activity
    GROUP BY player_id
) m
ON player_id = m.id AND event_date = m.date;
