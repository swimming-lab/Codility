SELECT
    a.USER_ID AS USER_ID,
    COUNT(a.PURCHASE_ID) AS PURCHASE_COUNT,
    SUM(a.ITEM_PRICE) AS TOTAL_PRICE
FROM (
     SELECT
         gu.id AS USER_ID,
         p.id AS PURCHASE_ID,
         IFNULL(
             (SELECT
                  c.PRICE
              FROM CHARACTERS AS c
              WHERE c.NAME = p.ITEM)
         , 0) AS ITEM_PRICE
     FROM
         GAME_USERS AS gu
     LEFT OUTER JOIN PURCHASES AS p
         ON gu.ID = p.USER_ID
) a
GROUP BY a.USER_ID
ORDER BY a.USER_ID ASC;