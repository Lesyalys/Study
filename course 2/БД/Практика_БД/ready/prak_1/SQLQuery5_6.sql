SELECT
O.�����_ID
,FORMAT(O.LASTPAY,'dd/MM/yyyy') AS '��������� ������'
,FORMAT(O.NEXTPAY,'dd/MM/yyyy') AS '��������� ������'
,DATEDIFF(DAY,FORMAT(O.LASTPAY,'dd/MM/yyyy'), FORMAT(O.NEXTPAY,'dd/MM/yyyy')) AS '�� ��������� ������'
FROM ������ AS O
