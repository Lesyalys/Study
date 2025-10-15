select top 5
b.BRANDNAME
,a.PRICE
,a.MILEAGE
,s.STATUS_NAME
,DATA
from DEALS
left join STATUSCODE s on DEALS.STATUS_ID = s.id
left join AUTO a on DEALS.CAR_ID = a.id
left join BRAND b on a.BRAND_ID  = b.id
where DATA between '20231001' and '20231030'
order by PRICE desc