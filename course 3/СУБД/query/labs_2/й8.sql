-- 8. ������������� ����������� �� ������� ����������
SELECT 
    CASE 
        WHEN PRICE < 1000000 THEN '�� 1 ���'
        WHEN PRICE BETWEEN 1000000 AND 2000000 THEN '1-2 ���'
        WHEN PRICE BETWEEN 2000001 AND 5000000 THEN '2-5 ���'
        WHEN PRICE > 5000000 THEN '����� 5 ���'
        ELSE '���� �� �������'
    END as price_category,
    COUNT(*) as auto_count,
    AVG(PRICE) as avg_price,
    MIN(PRICE) as min_price,
    MAX(PRICE) as max_price
FROM dbo.AUTO
GROUP BY 
    CASE 
        WHEN PRICE < 1000000 THEN '�� 1 ���'
        WHEN PRICE BETWEEN 1000000 AND 2000000 THEN '1-2 ���'
        WHEN PRICE BETWEEN 2000001 AND 5000000 THEN '2-5 ���'
        WHEN PRICE > 5000000 THEN '����� 5 ���'
        ELSE '���� �� �������'
    END
ORDER BY MIN(COALESCE(PRICE, 0));