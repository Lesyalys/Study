--������� ��� ���������� � ����������� ���� ������ 5 ��� ����� ���������� �������

SELECT 
	 A.��� AS ���,
	 A.���_����������_������ AS '������������� ��� ���������',
	CONVERT(varchar,A.���_����������_������ + 5) AS '������������� ����� 5 ���'

FROM ��������� as A

ORDER BY ���