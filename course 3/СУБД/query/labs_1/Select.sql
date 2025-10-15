select BRANDNAME, PRICE,MILEAGE,STATUS_NAME from AUTO
left join BRAND b on b.id = AUTO.BRAND_ID
left join STATUSCODE s on s.id = AUTO.STATUS
where BRANDNAME = 'Hyundai'
and STATUS_NAME in ('Активный')
AND PRICE <= 10000000