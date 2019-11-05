# Write your MySQL query statement below
select
    u.user_id as seller_id, 
    case when i.item_brand = u.favorite_brand then "yes" else "no" end as 2nd_item_fav_brand 
from
    users u left join (select o2.order_id, o1.seller_id, o2.item_id
                        from
                            orders o1 left join orders o2 on o1.order_date<o2.order_date and o1.seller_id=o2.seller_id
                        group by o2.order_id
                        having count(o1.order_id) = 1) o on u.user_id=o.seller_id 
    left join items i on o.item_id=i.item_id
order by seller_id