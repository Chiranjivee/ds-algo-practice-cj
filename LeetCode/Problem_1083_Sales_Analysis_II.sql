# Write your MySQL query statement below
select distinct buyer_id
from sales join product using(product_id)
where product_name = 'S8' 
and buyer_id not in
    (select distinct buyer_id
        from sales join product using(product_id)
        where product_name = 'iPhone' )
