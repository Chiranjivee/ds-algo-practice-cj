# Write your MySQL query statement below
SELECT ROUND(SUM(perc_removal) / COUNT(1), 2) average_daily_percent
FROM (
    SELECT a.action_date, COUNT(DISTINCT r.post_id) / COUNT(DISTINCT a.post_id) * 100 perc_removal
    FROM Actions a
    LEFT JOIN Removals r
    ON a.post_id = r.post_id
    WHERE a.extra= 'spam'
    GROUP BY a.action_date
) t
