-- ������ � �������������� �������� ������� � ����������� ����������� AND, OR � �����������.

SELECT *
,CASE
	WHEN FIO = '������� ����� ����������' THEN 'ITS ME' 
	ELSE 'OTHER'
	END AS 'FIND ME'
FROM ������_�������
ORDER BY 'FIND ME'