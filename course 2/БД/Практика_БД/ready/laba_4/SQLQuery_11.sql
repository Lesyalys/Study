--11.������� ��� � ������������ ���� �������� ������� ���������.

SELECT A.���
,FORMAT(A.����_��������,'dd/MM/yyyy') AS 'DATE'
, CASE 
	WHEN  YEAR(A.����_��������) % 400 = 0 THEN '����������'
	WHEN YEAR(A.����_��������) % 4 = 0 THEN '����������'
	ELSE '�� ����������'
	END AS 'YEAR'
FROM ��������� AS A

ORDER BY 'YEAR'
