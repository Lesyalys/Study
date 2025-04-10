SELECT
O.Жилец_ID
,FORMAT(O.LASTPAY,'dd/MM/yyyy') AS 'Последняя оплата'
,FORMAT(O.NEXTPAY,'dd/MM/yyyy') AS 'Следующая оплата'
,DATEDIFF(DAY,FORMAT(O.LASTPAY,'dd/MM/yyyy'), FORMAT(O.NEXTPAY,'dd/MM/yyyy')) AS 'До следующей оплаты'
FROM Оплаты AS O
