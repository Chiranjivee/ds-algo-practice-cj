# Write your MySQL query statement below
select product_id, SUM(quantity) as total_quantity from sales group by product_id;
