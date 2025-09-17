select PAYMENTFIO
, c.EMAIL
, b.BRANDNAME
,a.PRICE
,a.MILEAGE
,a.STATUS
from PAYMENT
left join AUTO a on a.id = PAYMENT.PAYMENTCAR_ID
left join CONTACT c on c.id = PAYMENT.CONTACT_ID
left join STATUSCODE s on a.STATUS = s.id
left join BRAND b on a.BRAND_ID  = b.id
order by PAYMENTFIO asc