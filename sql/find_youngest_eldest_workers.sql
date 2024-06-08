SELECT CASE
           WHEN birthday = (SELECT MAX(birthday) FROM worker) THEN 'YOUNGEST'
           END AS TYPE,
       name,
       birthday
FROM worker
WHERE birthday = (SELECT MAX(birthday) FROM worker)

UNION

SELECT CASE
           WHEN birthday = (SELECT MIN(birthday) FROM worker) THEN 'ELDEST'
           END AS TYPE,
       name,
       birthday
FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker);