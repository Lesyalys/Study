--5. ������� ������ ����������, ��� � ������� ������� � ��������

SELECT 
    CONCAT(
        LEFT(A.���, CHARINDEX(' ', A.���) - 1), ' ',
        UPPER(SUBSTRING(A.���, CHARINDEX(' ', A.���) + 1, 1)), '. ',
        UPPER(SUBSTRING(
            A.���, 
            CHARINDEX(' ', A.���, CHARINDEX(' ', A.���) + 1) + 1, 
            1
        )), '.'
    ) AS ���_���������������
FROM 
    ��������� AS A