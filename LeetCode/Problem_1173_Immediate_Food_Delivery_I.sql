# Write your MySQL query statement below
SELECT 
ROUND((SELECT COUNT(delivery_id) AS sameday_delivery
FROM Delivery
WHERE order_date = customer_pref_delivery_date)/ COUNT(delivery_id), 4)*100.00 AS immediate_percentage
FROM Delivery;
