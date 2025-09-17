select 
p.PAYMENTFIO
,b.BRANDNAME
,a.PRICE
,a.MILEAGE
,s.STATUS_NAME
,DATA
from DEALS
left join STATUSCODE s on DEALS.STATUS_ID = s.id
left join AUTO a on DEALS.CAR_ID = a.id
left join BRAND b on a.BRAND_ID  = b.id
left join PAYMENT p on DEALS.PAYMENT_ID  = p.id
where DATA between '20230101' and '20231231'
and s.id in (1,2,3)
order by s.STATUS_NAME asc