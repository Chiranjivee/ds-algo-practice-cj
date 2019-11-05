# Write your MySQL query statement below
SELECT seller_id
FROM Sales
GROUP BY seller_id
HAVING sum(price) = 
(
    SELECT sum(price)
    FROM sales
    group by seller_id
    order by sum(price) desc
    limit 1
)
